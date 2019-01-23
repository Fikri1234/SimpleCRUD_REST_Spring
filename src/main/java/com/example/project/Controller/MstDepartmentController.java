/**
 * 
 */
package com.example.project.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.project.DTO.EmbeddDTO;
import com.example.project.DTO.MstDepartmentDTO;
import com.example.project.Entity.EmbeddEntity;
import com.example.project.Entity.MstDepartmentEntity;
import com.example.project.Service.MstDepartmentService;

/**
 * @author FIKRI-PC
 *
 */

@RestController
@RequestMapping("/department")
public class MstDepartmentController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	MstDepartmentService mstDepartmentService;
	
	@GetMapping("/{id}")
	public ResponseEntity<MstDepartmentDTO> retrieveMstDepartmentById(@PathVariable("id") int id) {
		
		Optional<MstDepartmentEntity> mstDepartmentEntity = mstDepartmentService.findById(id);
		
		if (mstDepartmentEntity.isPresent()) {
			EmbeddDTO embeddDTO = new EmbeddDTO(mstDepartmentEntity.get().getEmbeddEntity());

			MstDepartmentDTO mstDepartmentDTO = new MstDepartmentDTO(mstDepartmentEntity.get(), embeddDTO);
			
			return new ResponseEntity<MstDepartmentDTO> (mstDepartmentDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<MstDepartmentDTO>(HttpStatus.NOT_FOUND);
		}
	}
	
	// ---------------- retrieve all data ----------------------
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<?> getAllMstDepartment(){
		
		List<MstDepartmentEntity> mstDepartmentServices = mstDepartmentService.findMstDepartmentAll();
		
		if (mstDepartmentServices.isEmpty()) {
			return new ResponseEntity<MstDepartmentEntity>(HttpStatus.NO_CONTENT);
		} else {
			
			EmbeddDTO embeddDTO;
			MstDepartmentDTO mstDepartmentDTO;
			
			List<MstDepartmentDTO> listData = new ArrayList<MstDepartmentDTO>();
			
			for (MstDepartmentEntity model : mstDepartmentServices) {
				
				mstDepartmentDTO = new MstDepartmentDTO();
				
				embeddDTO = new EmbeddDTO(model.getEmbeddEntity());
				mstDepartmentDTO = new MstDepartmentDTO(model, embeddDTO);
				
				listData.add(mstDepartmentDTO);
			}
			
			return new ResponseEntity<>(listData,HttpStatus.OK);
		}
	}
	
	/*for register*/
	@RequestMapping(value = "/", method = RequestMethod.POST, produces= {MediaType.APPLICATION_JSON_VALUE},
			consumes= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> createUserProfiles(@RequestBody MstDepartmentDTO mstDepartmentDTO, UriComponentsBuilder ucBuilder){
		try {

			MstDepartmentEntity mstDepartmentEntity = new MstDepartmentEntity();
			
			mstDepartmentEntity.setId(mstDepartmentDTO.getId());
			mstDepartmentEntity.setDepartmentName(mstDepartmentDTO.getDepartmentName());

			EmbeddEntity embeddEntity = new EmbeddEntity(new Date(), new Date());
			
			mstDepartmentEntity.setEmbeddEntity(embeddEntity);
			
			mstDepartmentService.saveMstDepartment(mstDepartmentEntity);
			
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/{id}").buildAndExpand(mstDepartmentEntity.getId()).toUri());
			
			return new ResponseEntity<>(headers, HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateDepartment(@PathVariable("id") int id, @RequestBody MstDepartmentDTO mstDepartmentDTO){
		
		Optional<MstDepartmentEntity> mstDepartmentServices = mstDepartmentService.findById(id);
		if (!mstDepartmentServices.isPresent()) {
			logger.error("Unable to update. updateDepartment with id {} not found",id);
			return new ResponseEntity<>("Unable to update. Id  "+id+" not found", HttpStatus.NOT_FOUND);
		}
		
		MstDepartmentEntity mstDepartmentEntity = new MstDepartmentEntity();
		
		mstDepartmentEntity.setId(mstDepartmentDTO.getId());
		mstDepartmentEntity.setDepartmentName(mstDepartmentDTO.getDepartmentName());

		EmbeddEntity embeddEntity = new EmbeddEntity(new Date());		/*define by sistem*/
		embeddEntity.setCreatedDate(mstDepartmentServices.get().getEmbeddEntity().getCreatedDate());
		
		mstDepartmentEntity.setEmbeddEntity(embeddEntity);
		
		mstDepartmentService.saveMstDepartment(mstDepartmentEntity);
		
		return new ResponseEntity<>(mstDepartmentService, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteMstDepartmentById(@PathVariable("id") int id){
		
		logger.info("Fetching & Deleting UserProfiles with id {}", id);
		
		Optional<MstDepartmentEntity> mstDepartmentEntity = mstDepartmentService.findById(id);
		if (!mstDepartmentEntity.isPresent()) {
			logger.error("Unable to delete. deleteMstDepartmentById with id {} not found",id);
			return new ResponseEntity<>("Unable to update. Id "+id+" not found", HttpStatus.NOT_FOUND);
		}
		
		mstDepartmentService.deleteMstDepartmentById(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}

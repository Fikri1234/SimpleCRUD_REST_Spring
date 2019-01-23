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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.DTO.EmbeddDTO;
import com.example.project.DTO.MstParamDTO;
import com.example.project.Entity.EmbeddEntity;
import com.example.project.Entity.MstParamEntity;
import com.example.project.Service.MstParamService;

/**
 * @author FIKRI-PC
 *
 */
@RestController
@RequestMapping("/param")
public class MstParamController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	MstParamService mstParamService;
	
//  --------------- retreave single data ------------------
	@GetMapping("/paramName/{paramName}")
	public ResponseEntity<MstParamDTO> retrieveMstParamByParamName(@PathVariable("paramName") String paramName) {
		
		Optional<MstParamEntity> mstParam = mstParamService.findByParamName(paramName);
		
		if (mstParam.isPresent()) {
			EmbeddDTO embeddDTO = new EmbeddDTO(mstParam.get().getEmbeddEntity());
			MstParamDTO mstParamDTO = new MstParamDTO(mstParam.get(), embeddDTO);
			
			return new ResponseEntity<MstParamDTO> (mstParamDTO, HttpStatus.OK);
		} else {
			logger.error("param not found: {}",paramName);
			return new ResponseEntity<MstParamDTO> (HttpStatus.NOT_FOUND);
		}
	}

//  --------------- retreave single data ------------------
	@GetMapping("/{paramCode}")
	public ResponseEntity<MstParamDTO> retrieveMstParamByParamCode(@PathVariable("paramCode") int paramCode) {
		
		Optional<MstParamEntity> mstParam = mstParamService.findById(paramCode);
		
		if (mstParam.isPresent()) {
			EmbeddDTO embeddDTO = new EmbeddDTO(mstParam.get().getEmbeddEntity());
			MstParamDTO mstParamDTO = new MstParamDTO(mstParam.get(), embeddDTO);
			
			return new ResponseEntity<MstParamDTO> (mstParamDTO, HttpStatus.OK);
		} else {
			logger.error("param not found: {}",paramCode);
			return new ResponseEntity<MstParamDTO> (HttpStatus.NOT_FOUND);
		}
	}
	
	// ---------------- retrieve all data ----------------------
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<?> getAllMstParam(){

		List<MstParamEntity> mstParamEntities = mstParamService.findMstParamAll();
		
		if (mstParamEntities.isEmpty()) {
			logger.error("param not found: {}");
			return new ResponseEntity<MstParamDTO> (HttpStatus.NO_CONTENT);
		} else {
			
			MstParamDTO mstParamDTO;
			EmbeddDTO embeddDTO;
			List<MstParamDTO> listData = new ArrayList<MstParamDTO>();
			
			for (MstParamEntity model : mstParamEntities) {
				mstParamDTO = new MstParamDTO();
				
				embeddDTO = new EmbeddDTO(model.getEmbeddEntity());					
				mstParamDTO = new MstParamDTO(model, embeddDTO);
				
				listData.add(mstParamDTO);
			}
			
			return new ResponseEntity<>(listData,HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST, produces= {MediaType.APPLICATION_JSON_VALUE},
			consumes= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> createMstParam(@RequestBody MstParamDTO mstParamDTO){
		try {
			
			MstParamEntity mstParamEntity = new MstParamEntity();
			
			mstParamEntity.setParamName(mstParamDTO.getParamName());
			mstParamEntity.setParamValue(mstParamDTO.getParamValue());
			mstParamEntity.setParamDescription(mstParamDTO.getParamDescription());
			
			EmbeddEntity embeddEntity = new EmbeddEntity(new Date(), new Date());
			
			mstParamEntity.setEmbeddEntity(embeddEntity);
			
			mstParamService.saveMstParam(mstParamEntity);
			
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(value = "/{paramCode}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateMstParam(@PathVariable("paramCode") int paramCode, @RequestBody MstParamDTO mstParamDTO){
		
		Optional<MstParamEntity> mstParam = mstParamService.findById(paramCode);
		if(!mstParam.isPresent()) {
			logger.error("Unable to update. MstParam with paramCode {} not found",paramCode);
			return new ResponseEntity<>("Unable to update. MstParam with id "+paramCode+" not found", HttpStatus.NOT_FOUND);
		} else {
			MstParamEntity mstParamEntity = new MstParamEntity();
			mstParamEntity.setParamCode(paramCode);
			mstParamEntity.setParamName(mstParamDTO.getParamName());
			mstParamEntity.setParamValue(mstParamDTO.getParamValue());
			mstParamEntity.setParamDescription(mstParamDTO.getParamDescription());
			
			EmbeddEntity embeddEntity = new EmbeddEntity(new Date());
			embeddEntity.setCreatedDate(mstParam.get().getEmbeddEntity().getCreatedDate());
			
			mstParamEntity.setEmbeddEntity(embeddEntity);
			
			mstParamService.saveMstParam(mstParamEntity);
			
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/{paramCode}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteMstParamById(@PathVariable("paramCode") int paramCode){
		
		logger.info("Fetching & Deleting MstParam with id {}", paramCode);
		
		Optional<MstParamEntity> mstParam = mstParamService.findById(paramCode);
		if (!mstParam.isPresent()) {
			logger.error("Unable to delete. MstParam with id {} not found",paramCode);
			return new ResponseEntity<>("Unable to delete. MstParam with id "+paramCode+" not found", HttpStatus.NOT_FOUND);
		}
		
		mstParamService.deleteMstParamById(paramCode);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}

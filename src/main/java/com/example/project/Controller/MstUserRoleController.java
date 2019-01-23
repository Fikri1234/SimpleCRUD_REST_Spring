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
import com.example.project.DTO.MstUserRoleDTO;
import com.example.project.Entity.EmbeddEntity;
import com.example.project.Entity.MstUserRoleEntity;
import com.example.project.Service.MstUserRoleService;

/**
 * @author FIKRI-PC
 *
 */
@RestController
@RequestMapping("/userRole")
public class MstUserRoleController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	MstUserRoleService mstUserRoleService;
	
	@GetMapping("/{roleCode}")
	public ResponseEntity<MstUserRoleDTO> retrieveMUserRoleByRoleCode(@PathVariable("roleCode") String roleCode) {
		
		Optional<MstUserRoleEntity> mstUserRoleEntity = mstUserRoleService.findById(roleCode);
		
		if (mstUserRoleEntity.isPresent()) {
			EmbeddDTO embeddDTO = new EmbeddDTO(mstUserRoleEntity.get().getEmbeddEntity());
			MstUserRoleDTO mstUserRoleDTO = new MstUserRoleDTO(mstUserRoleEntity.get(), embeddDTO);
			
			return new ResponseEntity<MstUserRoleDTO> (mstUserRoleDTO, HttpStatus.OK);
		}else {
			logger.error("roleCode not found: ",roleCode);
			return new ResponseEntity<MstUserRoleDTO>(HttpStatus.NOT_FOUND);
		}
	}
	
	// ---------------- retrieve all data ----------------------
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<?> getAllMstUserRole(){
		
		List<MstUserRoleEntity> mUserRoleEntities = mstUserRoleService.findMstUserRoleAll();
		
		if (mUserRoleEntities.isEmpty()) {
			return new ResponseEntity<MstUserRoleEntity>(HttpStatus.NO_CONTENT);
		} else {
			
			EmbeddDTO embeddDTO;
			MstUserRoleDTO mstUserRoleDTO;
			
			List<MstUserRoleDTO> listData = new ArrayList<MstUserRoleDTO>();
			
			for (MstUserRoleEntity model : mUserRoleEntities) {
				mstUserRoleDTO = new MstUserRoleDTO();
				
				embeddDTO = new EmbeddDTO(model.getEmbeddEntity());
				mstUserRoleDTO = new MstUserRoleDTO(model, embeddDTO);
				
				listData.add(mstUserRoleDTO);
			}
			
			return new ResponseEntity<>(listData,HttpStatus.OK);
		}
	}
	
	/*for register user role*/
	@RequestMapping(value = "/", method = RequestMethod.POST, produces= {MediaType.APPLICATION_JSON_VALUE},
			consumes= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> createUserRole(@RequestBody MstUserRoleDTO mstUserRoleDTO, UriComponentsBuilder ucBuilder){
		try {

			MstUserRoleEntity mstUserRoleEntity = new MstUserRoleEntity();
			
			mstUserRoleEntity.setRoleCode(mstUserRoleDTO.getRoleCode());
			mstUserRoleEntity.setRoleName(mstUserRoleDTO.getRoleName());
			mstUserRoleEntity.setIsActive(true);									/*define by sistem*/
			mstUserRoleEntity.setDescription(mstUserRoleDTO.getDescription());

			EmbeddEntity embeddEntity = new EmbeddEntity(new Date(), new Date());
			
			mstUserRoleEntity.setEmbeddEntity(embeddEntity);
			
			mstUserRoleService.saveMstUserRole(mstUserRoleEntity);
			
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/{roleCode}").buildAndExpand(mstUserRoleEntity.getRoleCode()).toUri());
			
			return new ResponseEntity<>(headers, HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(value = "/{roleCode}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUserRole(@PathVariable("roleCode") String roleCode, @RequestBody MstUserRoleDTO mstUserRoleDTO){
		
		logger.info("Updating userRole with role {}",roleCode);
		
		Optional<MstUserRoleEntity> mUserRole = mstUserRoleService.findById(roleCode);
		if (!mUserRole.isPresent()) {
			logger.error("Unable to update. UserRole with role {} not found",roleCode);
			return new ResponseEntity<>("Unable to update. RoleCode with id "+roleCode+" not found", HttpStatus.NOT_FOUND);
		}
		
		MstUserRoleEntity mstUserRoleEntity = new MstUserRoleEntity();
		
		mstUserRoleEntity.setRoleCode(mstUserRoleDTO.getRoleCode());
		mstUserRoleEntity.setRoleName(mstUserRoleDTO.getRoleName());
		mstUserRoleEntity.setIsActive(true);									/*define by sistem*/
		mstUserRoleEntity.setDescription(mstUserRoleDTO.getDescription());

		EmbeddEntity embeddEntity = new EmbeddEntity(new Date());				/*define by sistem*/
		embeddEntity.setCreatedDate(mUserRole.get().getEmbeddEntity().getCreatedDate());
		
		mstUserRoleEntity.setEmbeddEntity(embeddEntity);
		
		mstUserRoleService.saveMstUserRole(mstUserRoleEntity);
		
		return new ResponseEntity<>(mUserRole, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{roleCode}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUserProfilesById(@PathVariable("roleCode") String roleCode){
		
		logger.info("Fetching & Deleting UserProfiles with id {}", roleCode);
		
		Optional<MstUserRoleEntity> mstUserRoleEntity = mstUserRoleService.findById(roleCode);
		if (!mstUserRoleEntity.isPresent()) {
			logger.error("Unable to update. UserRole with id {} not found",roleCode);
			return new ResponseEntity<>("Unable to update. RoleCode with id "+roleCode+" not found", HttpStatus.NOT_FOUND);
		}
		
		mstUserRoleService.deleteMstUserRoleById(roleCode);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}

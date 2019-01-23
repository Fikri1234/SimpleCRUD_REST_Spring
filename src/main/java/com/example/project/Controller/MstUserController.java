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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import com.example.project.DTO.MstUserDTO;
import com.example.project.Entity.EmbeddEntity;
import com.example.project.Entity.MstUserEntity;
import com.example.project.Service.MstUserService;

/**
 * @author FIKRI-PC
 *
 */

@RestController
@RequestMapping("/user")
public class MstUserController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	MstUserService mstUserService;
	
	/*@Autowired
	PasswordEncoder userPasswordEncoder;*/
	
	@GetMapping("/{userId}")
	public ResponseEntity<MstUserDTO> retrieveMUserByUserId(@PathVariable("userId") String userId) {
		
		Optional<MstUserEntity> mstUserEntity = mstUserService.findById(userId);
		
		if (mstUserEntity.isPresent()) {
			EmbeddDTO embeddDTO = new EmbeddDTO(mstUserEntity.get().getEmbeddEntity());

			MstUserDTO mstUserDTO = new MstUserDTO(mstUserEntity.get(), embeddDTO);
			
			return new ResponseEntity<MstUserDTO> (mstUserDTO, HttpStatus.OK);
		}else {
			logger.error("userId not found: ",userId);
			return new ResponseEntity<MstUserDTO>(HttpStatus.NOT_FOUND);
		}
	}
	
	// ---------------- retrieve all paging data ----------------------
	@RequestMapping(value = "/{page}/{pagingSize}", method = RequestMethod.GET)
	public ResponseEntity<?> getAllMstUser(@PathVariable("page") int page, @PathVariable("pagingSize") int pagingSize){
		
		Pageable pageable = PageRequest.of(page, pagingSize);
		
		Page<MstUserEntity> mUserEntities = mstUserService.findMstUserAllPaging(pageable);
		
		if (mUserEntities.isEmpty()) {
			return new ResponseEntity<MstUserEntity>(HttpStatus.NO_CONTENT);
		} else {
			
			EmbeddDTO embeddDTO;
			MstUserDTO data;
			
			List<MstUserDTO> listData = new ArrayList<MstUserDTO>();
			
			long totalElements = mUserEntities.getTotalElements();
	        int totalPages = mUserEntities.getTotalPages();
			
			for (MstUserEntity model : mUserEntities) {
				data = new MstUserDTO();
				
				embeddDTO = new EmbeddDTO(model.getEmbeddEntity());
				
				data = new MstUserDTO(model, embeddDTO);
				data.setTotalElements((int)totalElements);
				data.setTotalPages(totalPages);
				
				listData.add(data);
			}
			
			return new ResponseEntity<>(listData,HttpStatus.OK);
		}
	}
	
	// ---------------- retrieve all paging data ----------------------
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<?> getAllMstUser(){
		
		List<MstUserEntity> mUserEntities = mstUserService.findMstUserAll();
		
		if (mUserEntities.isEmpty()) {
			return new ResponseEntity<MstUserEntity>(HttpStatus.NO_CONTENT);
		} else {
			
			EmbeddDTO embeddDTO;
			MstUserDTO data;
			
			List<MstUserDTO> listData = new ArrayList<MstUserDTO>();
			
			for (MstUserEntity model : mUserEntities) {
				data = new MstUserDTO();
				
				embeddDTO = new EmbeddDTO(model.getEmbeddEntity());
				
				data = new MstUserDTO(model, embeddDTO);
				
				listData.add(data);
			}
			
			return new ResponseEntity<>(listData,HttpStatus.OK);
		}
	}
	
	/*for register user*/
	@RequestMapping(value = "/", method = RequestMethod.POST, produces= {MediaType.APPLICATION_JSON_VALUE},
			consumes= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> createUserProfiles(@RequestBody MstUserDTO mstUserDTO, UriComponentsBuilder ucBuilder){
		try {

			MstUserEntity mstUserEntity = new MstUserEntity();
			
			mstUserEntity.setUserId(mstUserDTO.getUserId());
			//mstUserEntity.setPassword(userPasswordEncoder.encode(mstUserDTO.getPassword()));
			mstUserEntity.setName(mstUserDTO.getName());
			mstUserEntity.setAccountNonExpired(true);								/*define by sistem*/
			mstUserEntity.setAccountNonLocked(true);								/*define by sistem*/
			mstUserEntity.setCredentialsNonExpired(true);							/*define by sistem*/
			mstUserEntity.setEnabled(true);											/*define by sistem*/
			mstUserEntity.setBirthDate(mstUserDTO.getBirthDate());
			mstUserEntity.setEmail(mstUserDTO.getEmail());
			mstUserEntity.setNik(mstUserDTO.getNik());
			mstUserEntity.setPosisi_skrg(mstUserDTO.getPosisi_skrg());

			EmbeddEntity embeddEntity = new EmbeddEntity(new Date(), new Date());
			
			mstUserEntity.setEmbeddEntity(embeddEntity);
			
			mstUserService.saveMstUser(mstUserEntity);
			
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/{userId}").buildAndExpand(mstUserEntity.getUserId()).toUri());
			
			return new ResponseEntity<>(headers, HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUserProfiles(@PathVariable("userId") String userId, @RequestBody MstUserDTO mstUserDTO){
		
		logger.info("Updating userProfiles with user {}",userId);
		
		Optional<MstUserEntity> mUser = mstUserService.findById(userId);
		if (!mUser.isPresent()) {
			logger.error("Unable to update. UserProfiles with user {} not found",userId);
			return new ResponseEntity<>("Unable to update. User with id "+userId+" not found", HttpStatus.NOT_FOUND);
		}
		
		MstUserEntity mstUserEntity = new MstUserEntity();
		
		mstUserEntity.setUserId(mstUserDTO.getUserId());
		//mstUserEntity.setPassword(userPasswordEncoder.encode(mstUserDTO.getPassword()));
		mstUserEntity.setName(mstUserDTO.getName());
		mstUserEntity.setAccountNonExpired(true);								/*define by sistem*/
		mstUserEntity.setAccountNonLocked(true);								/*define by sistem*/
		mstUserEntity.setCredentialsNonExpired(true);							/*define by sistem*/
		mstUserEntity.setEnabled(true);											/*define by sistem*/
		mstUserEntity.setBirthDate(mstUserDTO.getBirthDate());
		mstUserEntity.setEmail(mstUserDTO.getEmail());
		mstUserEntity.setNik(mstUserDTO.getNik());
		mstUserEntity.setType(mstUserDTO.getType());
		mstUserEntity.setPosisi_dulu(mstUserDTO.getPosisi_dulu());
		mstUserEntity.setPosisi_skrg(mstUserDTO.getPosisi_skrg());

		EmbeddEntity embeddEntity = new EmbeddEntity(new Date());		/*define by sistem*/
		embeddEntity.setCreatedDate(mUser.get().getEmbeddEntity().getCreatedDate());
		
		mstUserEntity.setEmbeddEntity(embeddEntity);
		
		mstUserService.saveMstUser(mstUserEntity);
		
		return new ResponseEntity<>(mUser, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUserProfilesById(@PathVariable("userId") String userId){
		
		logger.info("Fetching & Deleting UserProfiles with id {}", userId);
		
		Optional<MstUserEntity> mstUserEntity = mstUserService.findById(userId);
		if (!mstUserEntity.isPresent()) {
			logger.error("Unable to update. UserProfiles with id {} not found",userId);
			return new ResponseEntity<>("Unable to update. User with id "+userId+" not found", HttpStatus.NOT_FOUND);
		}
		
		mstUserService.deleteMstUserById(userId);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}

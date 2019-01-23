/**
 * 
 */
package com.example.project.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.project.Entity.MstUserEntity;

/**
 * @author FIKRI-PC
 *
 */
public interface MstUserService {
	
	Optional<MstUserEntity> findById (String userId);
	void saveMstUser(MstUserEntity mstUserEntity);
	void updateMstUser(MstUserEntity mstUserEntity);
    void deleteMstUserById(String userId);
    void deleteMstUserAll();
    List<MstUserEntity> findMstUserAll();
    Page<MstUserEntity> findMstUserAllPaging(Pageable pageable);

}

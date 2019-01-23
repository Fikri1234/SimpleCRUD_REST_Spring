/**
 * 
 */
package com.example.project.Service;

import java.util.List;
import java.util.Optional;

import com.example.project.Entity.MstUserRoleEntity;

/**
 * @author FIKRI-PC
 *
 */
public interface MstUserRoleService {
	
	Optional<MstUserRoleEntity> findById (String roleCode);
	void saveMstUserRole(MstUserRoleEntity mstUserRoleEntity);
	void updateMstUserRole(MstUserRoleEntity mstUserRoleEntity);
    void deleteMstUserRoleById(String roleCode);
    void deleteMstUserRoleAll();
    List<MstUserRoleEntity> findMstUserRoleAll();

}

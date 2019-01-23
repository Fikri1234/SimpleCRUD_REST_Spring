/**
 * 
 */
package com.example.project.Service;

import java.util.List;
import java.util.Optional;

import com.example.project.Entity.MstDepartmentEntity;

/**
 * @author FIKRI-PC
 *
 */
public interface MstDepartmentService {
	
	Optional<MstDepartmentEntity> findById (int id);
	void saveMstDepartment(MstDepartmentEntity mstDepartmentEntity);
	void updateMstDepartment(MstDepartmentEntity mstDepartmentEntity);
    void deleteMstDepartmentById(int id);
    void deleteMstDepartmentAll();
    List<MstDepartmentEntity> findMstDepartmentAll();

}

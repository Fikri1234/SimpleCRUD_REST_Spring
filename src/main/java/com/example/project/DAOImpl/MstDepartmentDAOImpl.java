/**
 * 
 */
package com.example.project.DAOImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.project.DAO.MstDepartmentDAO;
import com.example.project.Entity.MstDepartmentEntity;
import com.example.project.Service.MstDepartmentService;

/**
 * @author FIKRI-PC
 *
 */
@Service
@Transactional
public class MstDepartmentDAOImpl implements MstDepartmentService {
	
	@Autowired
	MstDepartmentDAO mstDepartmentDAO;
	
	@Override
	public Optional<MstDepartmentEntity> findById(int id) {
		return mstDepartmentDAO.findById(id);
	}

	@Override
    public void saveMstDepartment(MstDepartmentEntity MstDepartmentEntity) {
        mstDepartmentDAO.save(MstDepartmentEntity);
    }
	
	@Override
	public void updateMstDepartment(MstDepartmentEntity MstDepartmentEntity) {
		saveMstDepartment(MstDepartmentEntity);
	}
	
	@Override
	public void deleteMstDepartmentAll() {
		mstDepartmentDAO.deleteAll();
	}
	
	@Override
	public void deleteMstDepartmentById(int id) {
		mstDepartmentDAO.deleteById(id);
	}
	
	@Override
	public List<MstDepartmentEntity> findMstDepartmentAll(){
		return mstDepartmentDAO.findAll();
	}

}

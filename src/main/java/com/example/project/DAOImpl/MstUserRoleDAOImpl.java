/**
 * 
 */
package com.example.project.DAOImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.project.DAO.MstUserRoleDAO;
import com.example.project.Entity.MstUserRoleEntity;
import com.example.project.Service.MstUserRoleService;

/**
 * @author FIKRI-PC
 *
 */
@Service
@Transactional
public class MstUserRoleDAOImpl implements MstUserRoleService {
	
	@Autowired
	MstUserRoleDAO mstUserRoleDAO;
	
	@Override
	public Optional<MstUserRoleEntity> findById(String id) {
		return mstUserRoleDAO.findById(id);
	}

	@Override
    public void saveMstUserRole(MstUserRoleEntity MstUserRoleEntity) {
        mstUserRoleDAO.save(MstUserRoleEntity);
    }
	
	@Override
	public void updateMstUserRole(MstUserRoleEntity MstUserRoleEntity) {
		saveMstUserRole(MstUserRoleEntity);
	}
	
	@Override
	public void deleteMstUserRoleAll() {
		mstUserRoleDAO.deleteAll();
	}
	
	@Override
	public void deleteMstUserRoleById(String id) {
		mstUserRoleDAO.deleteById(id);
	}
	
	@Override
	public List<MstUserRoleEntity> findMstUserRoleAll(){
		return mstUserRoleDAO.findAll();
	}

}

/**
 * 
 */
package com.example.project.DAOImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.project.DAO.MstUserDAO;
import com.example.project.Entity.MstUserEntity;
import com.example.project.Service.MstUserService;

/**
 * @author FIKRI-PC
 *
 */
@Service
@Transactional
public class MstUserDAOImpl implements MstUserService {
	
	@Autowired
	MstUserDAO mstUserDAO;
	
	@Override
	public Optional<MstUserEntity> findById(String id) {
		return mstUserDAO.findById(id);
	}

	@Override
    public void saveMstUser(MstUserEntity MstUserEntity) {
        mstUserDAO.save(MstUserEntity);
    }
	
	@Override
	public void updateMstUser(MstUserEntity MstUserEntity) {
		saveMstUser(MstUserEntity);
	}
	
	@Override
	public void deleteMstUserAll() {
		mstUserDAO.deleteAll();
	}
	
	@Override
	public void deleteMstUserById(String id) {
		mstUserDAO.deleteById(id);
	}
	
	@Override
	public List<MstUserEntity> findMstUserAll(){
		return mstUserDAO.findAll();
	}
	
	@Override
	public Page<MstUserEntity> findMstUserAllPaging(Pageable pageable){
		return mstUserDAO.findAll(pageable);
	}

}

/**
 * 
 */
package com.example.project.DAOImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.project.DAO.MstParamDAO;
import com.example.project.Entity.MstParamEntity;
import com.example.project.Service.MstParamService;

/**
 * @author FIKRI-PC
 *
 */
@Service
@Transactional
public class MstParamDAOImpl implements MstParamService {
	
	@Autowired
	MstParamDAO mstParamDAO;
	
	@Override
	public Optional<MstParamEntity> findById(int id) {
		return mstParamDAO.findById(id);
	}
	
	@Override
	public Optional<MstParamEntity> findByParamName(String paramName) {
		return mstParamDAO.findByParamName(paramName);
	}

	@Override
    public void saveMstParam(MstParamEntity MstParamEntity) {
        mstParamDAO.save(MstParamEntity);
    }
	
	@Override
	public void updateMstParam(MstParamEntity MstParamEntity) {
		saveMstParam(MstParamEntity);
	}
	
	@Override
	public void deleteMstParamAll() {
		mstParamDAO.deleteAll();;
	}
	
	@Override
	public void deleteMstParamById(int id) {
		mstParamDAO.deleteById(id);
	}
	
	@Override
	public List<MstParamEntity> findMstParamAll(){
		return mstParamDAO.findAll();
	}

}

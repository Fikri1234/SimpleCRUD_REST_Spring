/**
 * 
 */
package com.example.project.Service;

import java.util.List;
import java.util.Optional;

import com.example.project.Entity.MstParamEntity;

/**
 * @author FIKRI-PC
 *
 */
public interface MstParamService {
	
	Optional<MstParamEntity> findById (int id);
	Optional<MstParamEntity> findByParamName (String paramName);
	void saveMstParam(MstParamEntity mstParamEntity);
	void updateMstParam(MstParamEntity mstParamEntity);
    void deleteMstParamById(int id);
    void deleteMstParamAll();
    List<MstParamEntity> findMstParamAll();

}

/**
 * 
 */
package com.example.project.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.Entity.MstParamEntity;

/**
 * @author FIKRI-PC
 *
 */
@Repository
public interface MstParamDAO extends JpaRepository<MstParamEntity, Integer> {
	
	Optional<MstParamEntity> findByParamName(String paramName);

}

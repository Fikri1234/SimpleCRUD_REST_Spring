/**
 * 
 */
package com.example.project.DAO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.Entity.MstUserEntity;

/**
 * @author FIKRI-PC
 *
 */
@Repository
public interface MstUserDAO extends JpaRepository<MstUserEntity, String> {
	
	Page<MstUserEntity> findAll(Pageable pageable);

}

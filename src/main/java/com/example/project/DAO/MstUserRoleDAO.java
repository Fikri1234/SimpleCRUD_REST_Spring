/**
 * 
 */
package com.example.project.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.Entity.MstUserRoleEntity;

/**
 * @author FIKRI-PC
 *
 */
@Repository
public interface MstUserRoleDAO extends JpaRepository<MstUserRoleEntity, String>{

}

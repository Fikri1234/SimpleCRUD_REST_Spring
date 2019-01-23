/**
 * 
 */
package com.example.project.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.Entity.MstDepartmentEntity;

/**
 * @author FIKRI-PC
 *
 */
@Repository
public interface MstDepartmentDAO extends JpaRepository<MstDepartmentEntity, Integer>{

}

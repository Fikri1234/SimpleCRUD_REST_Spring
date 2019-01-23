/**
 * 
 */
package com.example.project.DTO;

import com.example.project.Entity.MstDepartmentEntity;

/**
 * @author FIKRI-PC
 *
 */
public class MstDepartmentDTO {
	
	private int id;
	private String departmentName;
	
	private EmbeddDTO embeddDTO;

	public MstDepartmentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MstDepartmentDTO(int id, String departmentName, EmbeddDTO embeddDTO) {
		super();
		this.id = id;
		this.departmentName = departmentName;
		this.embeddDTO = embeddDTO;
	}
	
	public MstDepartmentDTO(MstDepartmentEntity mstDepartmentEntity, EmbeddDTO embeddDTO) {
		super();
		this.id = mstDepartmentEntity.getId();
		this.departmentName = mstDepartmentEntity.getDepartmentName();
		this.embeddDTO = embeddDTO;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public EmbeddDTO getEmbeddDTO() {
		return embeddDTO;
	}

	public void setEmbeddDTO(EmbeddDTO embeddDTO) {
		this.embeddDTO = embeddDTO;
	}

}

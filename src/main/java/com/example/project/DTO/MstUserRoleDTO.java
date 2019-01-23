/**
 * 
 */
package com.example.project.DTO;

import com.example.project.Entity.MstUserRoleEntity;

/**
 * @author FIKRI-PC
 *
 */
public class MstUserRoleDTO {
	
	private String roleCode;
	private Boolean isActive;
	private String description;
	private String roleName;
	private EmbeddDTO embeddDTO;
		
	public MstUserRoleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MstUserRoleDTO(String roleCode, Boolean isActive, String description, String roleName, EmbeddDTO embeddDTO) {
		super();
		this.roleCode = roleCode;
		this.isActive = isActive;
		this.description = description;
		this.roleName = roleName;
		this.embeddDTO = embeddDTO;
	}
	
	public MstUserRoleDTO(MstUserRoleEntity mstUserRoleEntity, EmbeddDTO embeddDTO) {
		super();
		this.roleCode = mstUserRoleEntity.getRoleCode();
		this.isActive = mstUserRoleEntity.getIsActive();
		this.description = mstUserRoleEntity.getDescription();
		this.roleName = mstUserRoleEntity.getRoleName();
		this.embeddDTO = embeddDTO;
	}

	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public EmbeddDTO getEmbeddDTO() {
		return embeddDTO;
	}
	public void setEmbeddDTO(EmbeddDTO embeddDTO) {
		this.embeddDTO = embeddDTO;
	}

}

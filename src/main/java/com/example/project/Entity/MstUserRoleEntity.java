/**
 * 
 */
package com.example.project.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author FIKRI-PC
 *
 */

@Entity
@Table(name="MST_USER_ROLE")
public class MstUserRoleEntity {
	
	private String roleCode;
	private Boolean isActive;
	private String description;
	private String roleName;
	private EmbeddEntity embeddEntity;
	
	@Id
	@Column(name = "role_code")
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	
	@Column(name = "is_active")
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	@Column(name = "description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "role_name")
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public EmbeddEntity getEmbeddEntity() {
		return embeddEntity;
	}
	public void setEmbeddEntity(EmbeddEntity embeddEntity) {
		this.embeddEntity = embeddEntity;
	}
	
	public MstUserRoleEntity() {
		super();
		this.isActive = true;
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((embeddEntity == null) ? 0 : embeddEntity.hashCode());
		result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((roleCode == null) ? 0 : roleCode.hashCode());
		result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MstUserRoleEntity other = (MstUserRoleEntity) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (embeddEntity == null) {
			if (other.embeddEntity != null)
				return false;
		} else if (!embeddEntity.equals(other.embeddEntity))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (roleCode == null) {
			if (other.roleCode != null)
				return false;
		} else if (!roleCode.equals(other.roleCode))
			return false;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "MstUserRole [roleCode=" + roleCode + ", isActive=" + isActive + ", description=" + description
				+ ", roleName=" + roleName + ", embeddEntity=" + embeddEntity + "]";
	}

}

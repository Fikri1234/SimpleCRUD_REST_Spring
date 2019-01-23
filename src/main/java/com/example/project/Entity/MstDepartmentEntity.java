/**
 * 
 */
package com.example.project.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author FIKRI-PC
 *
 */

@Entity
@Table(name="MST_DEPARTMENT")
public class MstDepartmentEntity {
	
	private int id;
	private String departmentName;
	
	private EmbeddEntity embeddEntity;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "department_name")
	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public EmbeddEntity getEmbeddEntity() {
		return embeddEntity;
	}

	public void setEmbeddEntity(EmbeddEntity embeddEntity) {
		this.embeddEntity = embeddEntity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departmentName == null) ? 0 : departmentName.hashCode());
		result = prime * result + ((embeddEntity == null) ? 0 : embeddEntity.hashCode());
		result = prime * result + id;
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
		MstDepartmentEntity other = (MstDepartmentEntity) obj;
		if (departmentName == null) {
			if (other.departmentName != null)
				return false;
		} else if (!departmentName.equals(other.departmentName))
			return false;
		if (embeddEntity == null) {
			if (other.embeddEntity != null)
				return false;
		} else if (!embeddEntity.equals(other.embeddEntity))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DepartmentEntity [id=" + id + ", departmentName=" + departmentName + ", embeddEntity=" + embeddEntity
				+ "]";
	}

}

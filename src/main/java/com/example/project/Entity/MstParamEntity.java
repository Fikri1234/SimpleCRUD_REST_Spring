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
@Table(name="MST_PARAM")
public class MstParamEntity {
	
	private int paramCode;
	private String paramName;
	private String paramValue;
	private String paramDescription;
	
	private EmbeddEntity embeddEntity;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "param_code", nullable = false, unique = true)
	public Integer getParamCode() {
		return paramCode;
	}

	public void setParamCode(Integer paramCode) {
		this.paramCode = paramCode;
	}

	@Column(name = "param_name")
	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	@Column(name = "param_value")
	public String getParamValue() {
		return paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	@Column(name = "param_description")
	public String getParamDescription() {
		return paramDescription;
	}

	public void setParamDescription(String paramDescription) {
		this.paramDescription = paramDescription;
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
		result = prime * result + ((embeddEntity == null) ? 0 : embeddEntity.hashCode());
		result = prime * result + paramCode;
		result = prime * result + ((paramDescription == null) ? 0 : paramDescription.hashCode());
		result = prime * result + ((paramName == null) ? 0 : paramName.hashCode());
		result = prime * result + ((paramValue == null) ? 0 : paramValue.hashCode());
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
		MstParamEntity other = (MstParamEntity) obj;
		if (embeddEntity == null) {
			if (other.embeddEntity != null)
				return false;
		} else if (!embeddEntity.equals(other.embeddEntity))
			return false;
		if (paramCode != other.paramCode)
			return false;
		if (paramDescription == null) {
			if (other.paramDescription != null)
				return false;
		} else if (!paramDescription.equals(other.paramDescription))
			return false;
		if (paramName == null) {
			if (other.paramName != null)
				return false;
		} else if (!paramName.equals(other.paramName))
			return false;
		if (paramValue == null) {
			if (other.paramValue != null)
				return false;
		} else if (!paramValue.equals(other.paramValue))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MstParamEntity [paramCode=" + paramCode + ", paramName=" + paramName + ", paramValue=" + paramValue
				+ ", paramDescription=" + paramDescription + ", embeddEntity=" + embeddEntity + "]";
	}

}

/**
 * 
 */
package com.example.project.DTO;

import com.example.project.Entity.MstParamEntity;

/**
 * @author FIKRI-PC
 *
 */
public class MstParamDTO {
	
	private int paramCode;
	private String paramName;
	private String paramValue;
	private String paramDescription;
	
	private EmbeddDTO embeddDTO;

	public MstParamDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MstParamDTO(int paramCode, String paramName, String paramValue, String paramDescription,
			EmbeddDTO embeddDTO) {
		super();
		this.paramCode = paramCode;
		this.paramName = paramName;
		this.paramValue = paramValue;
		this.paramDescription = paramDescription;
		this.embeddDTO = embeddDTO;
	}
	
	public MstParamDTO(MstParamEntity mstParamEntity, EmbeddDTO embeddDTO) {
		super();
		this.paramCode = mstParamEntity.getParamCode();
		this.paramName = mstParamEntity.getParamName();
		this.paramValue = mstParamEntity.getParamValue();
		this.paramDescription = mstParamEntity.getParamDescription();
		this.embeddDTO = embeddDTO;
	}

	public int getParamCode() {
		return paramCode;
	}

	public void setParamCode(int paramCode) {
		this.paramCode = paramCode;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getParamValue() {
		return paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	public String getParamDescription() {
		return paramDescription;
	}

	public void setParamDescription(String paramDescription) {
		this.paramDescription = paramDescription;
	}

	public EmbeddDTO getEmbeddDTO() {
		return embeddDTO;
	}

	public void setEmbeddDTO(EmbeddDTO embeddDTO) {
		this.embeddDTO = embeddDTO;
	}

}

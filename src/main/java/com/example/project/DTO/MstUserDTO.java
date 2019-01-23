/**
 * 
 */
package com.example.project.DTO;

import java.time.LocalDate;

import com.example.project.Entity.MstUserEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author FIKRI-PC
 *
 */
public class MstUserDTO {
	
	private String userId;
	private String password;
	private String name;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;
	
	private String roleCode;
	private String roleName;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private LocalDate birthDate;
	private String email;
	
	private String nik;
	private String type;
	private String posisi_skrg;
	private String posisi_dulu;
	
	private int totalElements;
	private int totalPages;
	
	private EmbeddDTO embeddDTO;

	public MstUserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MstUserDTO(MstUserEntity mstUserEntity, EmbeddDTO embeddDTO) {
		super();
		this.userId = mstUserEntity.getUserId();
		this.password = mstUserEntity.getPassword();
		this.name = mstUserEntity.getName();
		this.accountNonExpired = mstUserEntity.getAccountNonExpired();
		this.accountNonLocked = mstUserEntity.getAccountNonLocked();
		this.credentialsNonExpired = mstUserEntity.getCredentialsNonExpired();
		this.enabled = mstUserEntity.getEnabled();
		this.birthDate = mstUserEntity.getBirthDate();
		this.email = mstUserEntity.getEmail();
		this.nik = mstUserEntity.getNik();
		this.type = mstUserEntity.getType();
		this.posisi_skrg = mstUserEntity.getPosisi_skrg();
		this.posisi_dulu = mstUserEntity.getPosisi_dulu();
		this.embeddDTO = embeddDTO;
	}

	public MstUserDTO(String userId, String password, String name, boolean accountNonExpired, boolean accountNonLocked,
			boolean credentialsNonExpired, boolean enabled, String roleCode, String roleName,
			LocalDate birthDate, String email, String nik, String type, String posisi_skrg, String posisi_dulu,
			EmbeddDTO embeddDTO) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
		this.roleCode = roleCode;
		this.roleName = roleName;
		this.birthDate = birthDate;
		this.email = email;
		this.nik = nik;
		this.type = type;
		this.posisi_skrg = posisi_skrg;
		this.posisi_dulu = posisi_dulu;
		this.embeddDTO = embeddDTO;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNik() {
		return nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPosisi_skrg() {
		return posisi_skrg;
	}

	public void setPosisi_skrg(String posisi_skrg) {
		this.posisi_skrg = posisi_skrg;
	}

	public String getPosisi_dulu() {
		return posisi_dulu;
	}

	public void setPosisi_dulu(String posisi_dulu) {
		this.posisi_dulu = posisi_dulu;
	}

	public EmbeddDTO getEmbeddDTO() {
		return embeddDTO;
	}

	public void setEmbeddDTO(EmbeddDTO embeddDTO) {
		this.embeddDTO = embeddDTO;
	}

	public int getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(int totalElements) {
		this.totalElements = totalElements;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

}

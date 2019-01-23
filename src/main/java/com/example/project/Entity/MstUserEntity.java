/**
 * 
 */
package com.example.project.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * @author FIKRI-PC
 *
 */

@Entity
@Table(name="MST_USER")
public class MstUserEntity {
	
	private String userId;
	private String password;
	private String name;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;
	
	private LocalDate birthDate;
	private String email;
	
	private String nik;
	private String type;
	private String posisi_skrg;
	private String posisi_dulu;
	
	private EmbeddEntity embeddEntity;
	
	@Id
	@Column(name = "user_id")
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Column(name = "password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "account_non_expired")
	public boolean getAccountNonExpired() {
		return accountNonExpired;
	}
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	
	@Column(name = "account_non_locked")
	public boolean getAccountNonLocked() {
		return accountNonLocked;
	}
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	
	@Column(name = "credentials_non_expired")
	public boolean getCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	
	@Column(name = "enabled")
	public boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@Column(name = "birth_date")
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	@Column(name = "email", nullable = false, unique = true)
	@Email(message = "Please provide a valid e-mail")
	@NotEmpty(message = "Please provide an e-mail")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "nik")
	public String getNik() {
		return nik;
	}
	public void setNik(String nik) {
		this.nik = nik;
	}
	
	@Column(name = "type")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name = "posisi_skrg")
	public String getPosisi_skrg() {
		return posisi_skrg;
	}
	public void setPosisi_skrg(String posisi_skrg) {
		this.posisi_skrg = posisi_skrg;
	}
	
	@Column(name = "posisi_dulu")
	public String getPosisi_dulu() {
		return posisi_dulu;
	}
	public void setPosisi_dulu(String posisi_dulu) {
		this.posisi_dulu = posisi_dulu;
	}
	/*----------------------------------------------*/
	public EmbeddEntity getEmbeddEntity() {
		return embeddEntity;
	}
	public void setEmbeddEntity(EmbeddEntity embeddEntity) {
		this.embeddEntity = embeddEntity;
	}
	
	public MstUserEntity() {
		super();
		this.enabled = true;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (accountNonExpired ? 1231 : 1237);
		result = prime * result + (accountNonLocked ? 1231 : 1237);
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + (credentialsNonExpired ? 1231 : 1237);
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((embeddEntity == null) ? 0 : embeddEntity.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nik == null) ? 0 : nik.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((posisi_dulu == null) ? 0 : posisi_dulu.hashCode());
		result = prime * result + ((posisi_skrg == null) ? 0 : posisi_skrg.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		MstUserEntity other = (MstUserEntity) obj;
		if (accountNonExpired != other.accountNonExpired)
			return false;
		if (accountNonLocked != other.accountNonLocked)
			return false;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (credentialsNonExpired != other.credentialsNonExpired)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (embeddEntity == null) {
			if (other.embeddEntity != null)
				return false;
		} else if (!embeddEntity.equals(other.embeddEntity))
			return false;
		if (enabled != other.enabled)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nik == null) {
			if (other.nik != null)
				return false;
		} else if (!nik.equals(other.nik))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (posisi_dulu == null) {
			if (other.posisi_dulu != null)
				return false;
		} else if (!posisi_dulu.equals(other.posisi_dulu))
			return false;
		if (posisi_skrg == null) {
			if (other.posisi_skrg != null)
				return false;
		} else if (!posisi_skrg.equals(other.posisi_skrg))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MstUserEntity [userId=" + userId + ", password=" + password + ", name=" + name + ", accountNonExpired="
				+ accountNonExpired + ", accountNonLocked=" + accountNonLocked + ", credentialsNonExpired="
				+ credentialsNonExpired + ", enabled=" + enabled + ", birthDate=" + birthDate + ", email=" + email
				+ ", nik=" + nik + ", type=" + type + ", posisi_skrg=" + posisi_skrg + ", posisi_dulu=" + posisi_dulu
				+ ", embeddEntity=" + embeddEntity + "]";
	}

}

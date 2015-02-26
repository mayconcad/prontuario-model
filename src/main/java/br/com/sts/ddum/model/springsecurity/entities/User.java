package br.com.sts.ddum.model.springsecurity.entities;

import java.beans.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.sts.ddum.model.entities.BaseEntity;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }) })
@NamedQueries({ @NamedQuery(name = "UserfindByUsername", query = "SELECT usu FROM User usu WHERE usu.username = :username") })
public class User extends BaseEntity implements Serializable, UserDetails {

	private static final long serialVersionUID = -8451679170281063697L;

	@NotNull
	@Size(min = 5, max = 20)
	@Column(unique = true)
	private String username;

	@NotNull
	@Size(min = 5, max = 100)
	private String password;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	@Column(updatable = false)
	private Date createdAt;

	@NotBlank
	private String name;

	@Email
	private String email;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Role> roles;

	@Transient
	public Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> result = new ArrayList<GrantedAuthority>();
		for (Role role : roles) {
			result.add(new GrantedAuthorityImpl(role.getName()));
		}
		return result;
	}

	@Transient
	public boolean isEnabled() {
		return true;
	}

	@Transient
	public boolean isAccountNonExpired() {
		return true;
	}

	@Transient
	public boolean isAccountNonLocked() {
		return true;
	}

	@Transient
	public boolean isCredentialsNonExpired() {
		return true;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

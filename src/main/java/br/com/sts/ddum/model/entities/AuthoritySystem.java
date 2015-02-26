package br.com.sts.ddum.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class AuthoritySystem implements GrantedAuthority {

  private static final long serialVersionUID = 2308718721179712683L;

  @Id
  @GeneratedValue
  private Long id;

  private String role;

  private String description;

  @Override
  public String getAuthority() {
    return this.role;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}

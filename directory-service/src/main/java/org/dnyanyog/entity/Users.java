package org.dnyanyog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.dnyanyog.utility.CustomIdGenerator;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Component
@Table
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Users {

  @Column private String userId;

  @Column private String userName;

  @Column private String email;

  @Column private String mobileNumber;

  @Column private String password;
  
  @Column private String status;

  @Column private String userRole;
  
  public static final String ACTIVE = "ACTIVE";
  public static final String INACTIVE = "INACTIVE";

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  
  public String getStatus() {
return status;}

public void setStatus(String status) {
this.status = status;}

public String getUserRole() {
    return userRole;
  }

  public void setUserRole(String userRole) {
    this.userRole = userRole;
  }
  
  @PrePersist
  private void generateUserId() {
      if (this.userId == null) {
          this.userId = CustomIdGenerator.generatePatientId();
      }
  }
  
}

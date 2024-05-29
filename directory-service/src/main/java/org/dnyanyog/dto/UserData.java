package org.dnyanyog.dto;

import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Size;

public class UserData {
	
	private String userId;
	
	@NotBlank
	@Size(min=2,max=15)
	private String userName;
	
	@NotBlank
	private String Email;
	
	@NotBlank
	private String mobileNumber;
	
	@NotBlank
	private String Role;
	
	@NotBlank
	@Size(min=8,max=14)
	private String password;

  public String getUserName() {
  return userName;}

  public void setUserName(String userName) {
  this.userName = userName;}

  public String getEmail() {
  return Email;}

  public void setEmail(String email) {
  Email = email;}

  public String getMobileNumber() {
  return mobileNumber;}

  public void setMobileNumber(String mobileNumber) {
  this.mobileNumber = mobileNumber;}

  public String getRole() {
  return Role;}

  public void setRole(String role) {
  Role = role;}

  public String getPassword() {
  return password;}

  public void setPassword(String password) {
  this.password = password;}

public String getUserId(){return userId;}

public void setUserId(String userId){this.userId = userId;}
	
	
}

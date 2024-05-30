package org.dnyanyog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.dnyanyog.utility.CustomIdGenerator;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Patient {

  @Id private String patientId;

  @Column private String patientName;

  @Column private String patientNameMarathi;

  @Column private String MobileNumber;
  @Column private String Gender;
  @Column private String birthDate;
  @Column private String FirstExaminationDate;

  @Column private String Address;

  @Column private String Status;

  public static final String ACTIVE = "ACTIVE";
  public static final String INACTIVE = "INACTIVE";

  public String getPatientId() {
    return patientId;
  }

  public void setPatientId(String patientId) {
    this.patientId = patientId;
  }

  public String getPatientName() {
    return patientName;
  }

  public void setPatientName(String patientName) {
    this.patientName = patientName;
  }

  public String getPatientNameMarathi() {
    return patientNameMarathi;
  }

  public void setPatientNameMarathi(String patientNameMarathi) {
    this.patientNameMarathi = patientNameMarathi;
  }

  public String getMobileNumber() {
    return MobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    MobileNumber = mobileNumber;
  }

  public String getGender() {
    return Gender;
  }

  public void setGender(String gender) {
    Gender = gender;
  }

  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  public String getFirstExaminationDate() {
    return FirstExaminationDate;
  }

  public void setFirstExaminationDate(String firstExaminationDate) {
    FirstExaminationDate = firstExaminationDate;
  }

  public String getAddress() {
    return Address;
  }

  public void setAddress(String address) {
    Address = address;
  }

  public String getStatus() {
    return Status;
  }

  public void setStatus(String status) {
    Status = status;
  }

  @PrePersist
  private void generateUserId() {
    if (this.patientId == null) {
      this.patientId = CustomIdGenerator.generatePatientId();
    }
  }
}

package org.dnyanyog.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppointmentResponse {

  private String status;
  private String message;

  @Autowired private AppointmentData appointmentData;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public AppointmentData getAppointmentData() {
    return appointmentData;
  }

  public void setAppointmentData(AppointmentData appointmentData) {
    this.appointmentData = appointmentData;
  }
}

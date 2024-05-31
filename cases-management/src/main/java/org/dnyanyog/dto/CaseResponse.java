package org.dnyanyog.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CaseResponse {

  private String message;
  private String status;

  @Autowired private CaseData caseData;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public CaseData getCaseData() {
    return caseData;
  }

  public void setCaseData(CaseData caseData) {
    this.caseData = caseData;
  }
}

package org.dnyanyog.service;

import org.dnyanyog.dto.AddPatientRequest;
import org.dnyanyog.dto.PatientResponse;
import org.dnyanyog.dto.UpdatePatientRequest;
import org.springframework.stereotype.Component;
@Component
public interface PatientService {
	
	public PatientResponse addPatient(AddPatientRequest addRequest) ;
	
	public PatientResponse updatePatient(UpdatePatientRequest updateRequest);
	
	public PatientResponse deletePatient(String patientId);
		
	
}

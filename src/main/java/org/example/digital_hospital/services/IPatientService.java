package org.example.digital_hospital.services;

import org.example.digital_hospital.models.Consultation;
import org.example.digital_hospital.models.Departement;
import org.example.digital_hospital.models.Docteur;
import org.example.digital_hospital.models.Patient;

import java.util.List;

public interface IPatientService {
    void createConsultation(Consultation consultation);
    void updateConsultation(Consultation consultation);
    void annullerConsultation(Consultation consultation);
    List<Consultation> getAllMyConsultations(Patient patient);
    List<Docteur> getDocteursParDepartement(Departement departement);
}

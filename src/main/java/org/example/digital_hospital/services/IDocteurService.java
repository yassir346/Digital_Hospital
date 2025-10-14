package org.example.digital_hospital.services;

import org.example.digital_hospital.models.Consultation;
import org.example.digital_hospital.models.Docteur;
import org.example.digital_hospital.models.Patient;

import java.util.List;

public interface IDocteurService {
    List<Consultation> getConsultations(Docteur docteur);
    void updateConsultation(Consultation consultation, Docteur docteur);
    void creerCompteRendu(String contenu, Consultation consultation);
    List<Consultation> historiquePatient(Patient patient);
}

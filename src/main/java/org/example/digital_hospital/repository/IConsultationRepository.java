package org.example.digital_hospital.repository;

import org.example.digital_hospital.models.Consultation;
import org.example.digital_hospital.models.Docteur;
import org.example.digital_hospital.models.Patient;

import java.util.List;

public interface IConsultationRepository {
    Consultation save(Consultation salle);
    Consultation update(Consultation salle);
    void delete(int id);
    List<Consultation> findAll();
    Consultation findById(int id);
    List<Consultation> findByDocteurs(Docteur docteur);
    List<Consultation> findByPatient(Patient patient);
}

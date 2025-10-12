package org.example.digital_hospital.repository;

import org.example.digital_hospital.models.Docteur;
import org.example.digital_hospital.models.Patient;
import org.example.digital_hospital.models.Salle;

import java.util.List;

public interface IPatientRepository {
    Patient save(Patient patient);
    Patient update(Patient patient);
    void delete(int id);
    List<Patient> findAll();
    Patient findById(int id);
    List<Patient> findByDocteur(Docteur docteur);
}

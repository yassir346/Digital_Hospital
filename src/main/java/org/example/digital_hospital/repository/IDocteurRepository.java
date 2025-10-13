package org.example.digital_hospital.repository;

import org.example.digital_hospital.models.Departement;
import org.example.digital_hospital.models.Docteur;

import java.util.List;

public interface IDocteurRepository {
    Docteur save(Docteur docteur);
    Docteur update(Docteur docteur);
    void delete(int id);
    List<Docteur> findAll();
    Docteur findById(int id);
    Docteur findByEmail(String email);
    List<Docteur> findByDepartement(Departement departement);
}

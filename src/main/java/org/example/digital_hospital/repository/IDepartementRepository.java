package org.example.digital_hospital.repository;

import org.example.digital_hospital.models.Departement;

import java.util.List;

public interface IDepartementRepository {
    Departement save(Departement departement);
    Departement update(Departement departement);
    void delete(int id);
    List<Departement> findAll();
    Departement findById(int id);
}

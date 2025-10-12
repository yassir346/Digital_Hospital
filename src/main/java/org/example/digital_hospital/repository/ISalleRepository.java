package org.example.digital_hospital.repository;

import org.example.digital_hospital.models.Salle;

import java.util.List;

public interface ISalleRepository {
    Salle save(Salle salle);
    Salle update(Salle salle);
    void delete(int id);
    List<Salle> findAll();
    Salle findById(int id);
}

package org.example.digital_hospital.repository;

import org.example.digital_hospital.models.Personne;

public interface IPersonneRepository {
    Personne save(Personne person);

    Personne findByEmailAndPassword(String email, String password);

    Personne findByEmail(String email);

    Personne findById(int id);
}

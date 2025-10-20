package org.example.digital_hospital.services;

import org.example.digital_hospital.models.Personne;

public interface IAuthService {
     Personne login(Personne personne);
     void signUp(Personne personne);
}

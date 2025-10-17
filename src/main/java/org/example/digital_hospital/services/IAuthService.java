package org.example.digital_hospital.services;

import org.example.digital_hospital.models.Patient;
import org.example.digital_hospital.models.Personne;

public interface IAuthService {
     Personne login(Personne personne);
     Personne signUp(Personne personne);
}

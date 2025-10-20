package org.example.digital_hospital.services.Impl;

import org.example.digital_hospital.exceptions.ValidationException;
import org.example.digital_hospital.models.Personne;
import org.example.digital_hospital.repository.IPersonneRepository;
import org.example.digital_hospital.services.IAuthService;

public class AuthServiceImpl implements IAuthService {
    private IPersonneRepository personneRepository;

    public AuthServiceImpl(IPersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }

    @Override
    public Personne login(Personne personne) {
        if(personne.getEmail().isEmpty() || personne.getEmail().isEmpty()){
            throw new ValidationException("Entrez email et mot de passe.");
        }
        Personne personne1 = personneRepository.findByEmailAndPassword(personne.getEmail(), personne.getMotDePasse());
        if (personne1 == null) {
            throw new ValidationException("invalide email ou mot de passe.");
        }

        return personne1;
    }

    @Override
    public void signUp(Personne personne) {
        if (personne.getEmail() == null || personne.getMotDePasse() == null ||
                personne.getEmail().isEmpty() || personne.getMotDePasse().isEmpty()) {
            throw new ValidationException("Email or password cannot be empty");
        }

        if (personneRepository.findByEmail(personne.getEmail()) != null) {
            throw new ValidationException("Email déjà exist.");
        }

        personneRepository.save(personne);
    }
}

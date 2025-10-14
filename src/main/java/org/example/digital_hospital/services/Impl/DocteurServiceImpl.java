package org.example.digital_hospital.services.Impl;

import org.example.digital_hospital.exceptions.ValidationException;
import org.example.digital_hospital.models.Consultation;
import org.example.digital_hospital.models.Docteur;
import org.example.digital_hospital.models.Patient;
import org.example.digital_hospital.repository.IConsultationRepository;
import org.example.digital_hospital.repository.IDocteurRepository;
import org.example.digital_hospital.services.IDocteurService;

import java.util.List;

public class DocteurServiceImpl implements IDocteurService {
    IDocteurRepository docteurRepository;
    IConsultationRepository consultationRepository;

    public DocteurServiceImpl(IDocteurRepository docteurRepository, IConsultationRepository consultationRepository) {
        this.docteurRepository = docteurRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public List<Consultation> getConsultations(Docteur docteur) {
        if (docteur == null) {
            throw new ValidationException("Docteur null");
        }

        return consultationRepository.findByDocteurs(docteur);
    }

    @Override
    public void updateConsultation(Consultation consultation, Docteur docteur) {
        if(consultation.getDocteur() != docteur){
            throw new ValidationException("Docteur ne correspond pas.");
        }
        consultationRepository.update(consultation);
    }

    @Override
    public void creerCompteRendu(String contenu, Consultation consultation) {
        consultation.setCompteRendu(contenu);
        consultationRepository.update(consultation);
    }

    @Override
    public List<Consultation> historiquePatient(Patient patient) {
        if (patient == null) {
            throw new ValidationException("Patient est nul");
        }
        return consultationRepository.findByPatient(patient);
    }
}

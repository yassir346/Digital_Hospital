package org.example.digital_hospital.services.Impl;

import org.example.digital_hospital.exceptions.NotFoundException;
import org.example.digital_hospital.exceptions.ValidationException;
import org.example.digital_hospital.models.*;
import org.example.digital_hospital.repository.IConsultationRepository;
import org.example.digital_hospital.repository.IDocteurRepository;
import org.example.digital_hospital.repository.IPatientRepository;
import org.example.digital_hospital.repository.ISalleRepository;
import org.example.digital_hospital.services.IPatientService;

import java.time.LocalTime;
import java.util.List;

public class PatientServiceImpl implements IPatientService {
    IPatientRepository patientRepository;
    IDocteurRepository docteurRepository;
    IConsultationRepository consultationRepository;
    ISalleRepository salleRepository;

    public PatientServiceImpl(IPatientRepository patientRepository, IDocteurRepository docteurRepository, IConsultationRepository consultationRepository, ISalleRepository salleRepository) {
        this.patientRepository = patientRepository;
        this.docteurRepository = docteurRepository;
        this.consultationRepository = consultationRepository;
        this.salleRepository = salleRepository;
    }

    @Override
    public void createConsultation(Consultation consultation) {
        if (docteurDisponibilite(consultation) == false){
            throw new ValidationException("Docteur n'est pas disponible.");
        }
        consultationRepository.save(consultation);
    }

    @Override
    public void updateConsultation(Consultation consultation) {
        if(consultationRepository.findById(consultation.getId()) == null){
            throw new NotFoundException("Consultation n'est pas trouvée.");
        }
        if (docteurDisponibilite(consultation) == false){
            throw new ValidationException("Docteur n'est pas disponible.");
        }
        consultationRepository.update(consultation);
    }

    @Override
    public void annullerConsultation(Consultation consultation) {
        if(consultationRepository.findById(consultation.getId()) == null){
            throw new NotFoundException("Consultation n'est pas trouvée.");
        }
        consultation.setStatut(Statut.ANNULEE);
        consultationRepository.update(consultation);
    }

    @Override
    public List<Consultation> getAllMyConsultations(Patient patient) {
        if (patient == null) {
            throw new ValidationException("Patient is null");
        }
        if (consultationRepository.findByPatient(patient) == null) {
            throw new ValidationException("No consultation found for patient");
        }

        return consultationRepository.findByPatient(patient);
    }

    @Override
    public List<Docteur> getDocteursParDepartement(Departement departement) {
        if (departement == null) {
            throw new ValidationException("Department is null");
        }
        if (docteurRepository.findByDepartement(departement) == null) {
            throw new ValidationException("No Doctor found for department");
        }
        return docteurRepository.findByDepartement(departement);
    }

    public boolean docteurDisponibilite(Consultation consultation){
        Docteur foundDocteur = docteurRepository.findById(consultation.getDocteur().getId());
        if (foundDocteur == null){
            throw new ValidationException("Docteur n'est pas trouvé.");
        }
        return consultationDisponibilite(consultation, foundDocteur.getConsultations());
    }

    public boolean consultationDisponibilite(Consultation consultation, List<Consultation> consultations){
        LocalTime temps = consultation.getHeureEtDate().toLocalTime();
        int minute = temps.getMinute();
        LocalTime debutService = LocalTime.of(8, 30);
        LocalTime finService = LocalTime.of(4,30);

        if(minute != 0 || minute != 30){
            throw new ValidationException("L'heure' de la consultation doit être à heure:00 minutes ou heure:30 minutes");
        }
        if(temps.isBefore(debutService) || temps.isAfter(finService)){
            throw new ValidationException("L'heure doit être etre 8:30 du matin et 4:30 d'après midi.");
        }

        boolean disponibilite = consultations.stream()
                .noneMatch(c -> c.getHeureEtDate().equals(consultation.getHeureEtDate()));
        return disponibilite;
    }
}

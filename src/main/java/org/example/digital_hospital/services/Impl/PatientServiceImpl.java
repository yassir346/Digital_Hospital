package org.example.digital_hospital.services.Impl;

import org.example.digital_hospital.models.Consultation;
import org.example.digital_hospital.models.Departement;
import org.example.digital_hospital.models.Docteur;
import org.example.digital_hospital.models.Patient;
import org.example.digital_hospital.repository.IConsultationRepository;
import org.example.digital_hospital.repository.IDocteurRepository;
import org.example.digital_hospital.repository.IPatientRepository;
import org.example.digital_hospital.repository.ISalleRepository;
import org.example.digital_hospital.services.IConsultationService;
import org.example.digital_hospital.services.IPatientService;

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
        consultationRepository.save(consultation);
    }

    @Override
    public void updateConsultation(Consultation consultation) {

    }

    @Override
    public void annullerConsultation(Consultation consultation) {

    }

    @Override
    public List<Consultation> getAllMyConsultations(Patient patient) {
        return List.of();
    }

    @Override
    public List<Docteur> getDocteursParDepartement(Departement departement) {
        return List.of();
    }

    public boolean consultationDisponibilite(Consultation consultation){

        return true;
    }
}

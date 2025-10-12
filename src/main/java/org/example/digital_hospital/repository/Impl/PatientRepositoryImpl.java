package org.example.digital_hospital.repository.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.digital_hospital.models.Departement;
import org.example.digital_hospital.models.Docteur;
import org.example.digital_hospital.models.Patient;
import org.example.digital_hospital.repository.IPatientRepository;

import java.util.List;

public class PatientRepositoryImpl implements IPatientRepository {
    private EntityManagerFactory emf;
    public PatientRepositoryImpl(){
        this.emf = Persistence.createEntityManagerFactory("test");
    }
    @Override
    public Patient save(Patient patient) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(patient);
        em.getTransaction().commit();
        em.close();
        return patient;
    }

    @Override
    public Patient update(Patient patient) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(patient);
        em.getTransaction().commit();
        em.close();
        return patient;
    }

    @Override
    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Patient patient = em.find(Patient.class, id);
        em.remove(patient);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Patient> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Patient> patients = em.createQuery("FROM Patient", Patient.class).getResultList();
        em.close();
        return patients;
    }

    @Override
    public Patient findById(int id) {
        EntityManager em = emf.createEntityManager();
        Patient patient = em.find(Patient.class, id);
        em.close();
        return patient;
    }

    @Override
    public List<Patient> findByDocteur(Docteur docteur) {
        return List.of();
    }
}

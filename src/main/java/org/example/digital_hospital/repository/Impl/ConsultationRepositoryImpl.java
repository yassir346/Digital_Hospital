package org.example.digital_hospital.repository.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.example.digital_hospital.models.Consultation;
import org.example.digital_hospital.models.Departement;
import org.example.digital_hospital.models.Docteur;
import org.example.digital_hospital.models.Patient;
import org.example.digital_hospital.repository.IConsultationRepository;

import java.util.List;

public class ConsultationRepositoryImpl implements IConsultationRepository {
    private EntityManagerFactory emf;

    public ConsultationRepositoryImpl(){
        this.emf = Persistence.createEntityManagerFactory("test");
    }

    @Override
    public Consultation save(Consultation Consultation) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(Consultation);
        em.getTransaction().commit();
        em.close();
        return Consultation;
    }

    @Override
    public Consultation update(Consultation consultation) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(consultation);
        em.getTransaction().commit();
        em.close();
        return consultation;
    }

    @Override
    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Consultation consultation = em.find(Consultation.class, id);
        em.remove(consultation);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Consultation> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Consultation> consultations = em.createQuery("FROM Consultation ", Consultation.class).getResultList();
        em.close();
        return consultations;
    }

    @Override
    public Consultation findById(int id) {
        EntityManager em = emf.createEntityManager();
        Consultation consultation = em.find(Consultation.class, id);
        em.close();
        return consultation;
    }

    @Override
    public List<Consultation> findByDocteurs(Docteur docteur) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("FROM Consultation WHERE docteur.id = :id_docteur");
        query.setParameter("id_docteur", docteur.getId());
        List<Consultation> consultations = query.getResultList();
        return consultations;
    }

    @Override
    public List<Consultation> findByPatient(Patient patient) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("FROM Consultation WHERE patient.id = :id_patient");
        query.setParameter("id_patient", patient.getId());
        List<Consultation> consultations = query.getResultList();
        return consultations;
    }
}

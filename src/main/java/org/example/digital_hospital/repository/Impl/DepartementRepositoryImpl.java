package org.example.digital_hospital.repository.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.*;
import org.example.digital_hospital.models.Departement;
import org.example.digital_hospital.repository.IDepartementRepository;

import java.util.List;

public class DepartementRepositoryImpl implements IDepartementRepository {

    private EntityManagerFactory emf;
    public DepartementRepositoryImpl(){
        this.emf = Persistence.createEntityManagerFactory("test");

    }
    @Override
    public Departement save(Departement departement) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(departement);
        em.getTransaction().commit();
        em.close();
        return departement;
    }

    @Override
    public Departement update(Departement departement) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(departement);
        em.getTransaction().commit();
        em.close();
        return departement;
    }

    @Override
    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Departement departement = em.find(Departement.class, id);
        em.remove(departement);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Departement> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Departement> departements = em.createQuery("FROM Departement", Departement.class).getResultList();
        em.close();
        return departements;
    }

    @Override
    public Departement findById(int id) {
        EntityManager em = emf.createEntityManager();
        Departement departement = em.find(Departement.class, id);
        em.close();
        return departement;
    }
}

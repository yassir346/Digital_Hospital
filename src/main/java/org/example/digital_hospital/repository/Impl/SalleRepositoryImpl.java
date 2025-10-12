package org.example.digital_hospital.repository.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.digital_hospital.models.Departement;
import org.example.digital_hospital.models.Salle;
import org.example.digital_hospital.repository.ISalleRepository;

import java.util.List;

public class SalleRepositoryImpl implements ISalleRepository {
    private EntityManagerFactory emf;
    public SalleRepositoryImpl(){
        this.emf = Persistence.createEntityManagerFactory("test");
    }
    @Override
    public Salle save(Salle salle) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(salle);
        em.getTransaction().commit();
        em.close();
        return salle;
    }

    @Override
    public Salle update(Salle salle) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(salle);
        em.getTransaction().commit();
        em.close();
        return salle;
    }

    @Override
    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Salle salle = em.find(Salle.class, id);
        em.remove(salle);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Salle> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Salle> salle = em.createQuery("FROM Salle", Salle.class).getResultList();
        em.close();
        return salle;
    }

    @Override
    public Salle findById(int id) {
        EntityManager em = emf.createEntityManager();
        Salle salle = em.find(Salle.class, id);
        em.close();
        return salle;
    }
}

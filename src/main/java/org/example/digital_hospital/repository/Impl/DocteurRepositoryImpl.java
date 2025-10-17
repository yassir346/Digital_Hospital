package org.example.digital_hospital.repository.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.example.digital_hospital.models.Departement;
import org.example.digital_hospital.models.Docteur;
import org.example.digital_hospital.repository.IDocteurRepository;

import java.util.List;

public class DocteurRepositoryImpl implements IDocteurRepository {
    private EntityManagerFactory emf;
    public DocteurRepositoryImpl(){
        this.emf = Persistence.createEntityManagerFactory("test");
    }
    @Override
    public Docteur save(Docteur docteur) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(docteur);
        em.getTransaction().commit();
        em.close();
        return docteur;
    }

    @Override
    public Docteur update(Docteur docteur) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(docteur);
        em.getTransaction().commit();
        em.close();
        return docteur;
    }

    @Override
    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Docteur docteur = em.find(Docteur.class, id);
        em.remove(docteur);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Docteur> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Docteur> docteurs = em.createQuery("FROM Docteur", Docteur.class).getResultList();
        em.close();
        return docteurs;
    }

    @Override
    public Docteur findById(int id) {
        EntityManager em = emf.createEntityManager();
        Docteur docteur = em.find(Docteur.class, id);
        em.close();
        return docteur;
    }

    @Override
    public Docteur findByEmail(String email) {
        EntityManager em = emf.createEntityManager();
        Docteur docteur;
        Query query = em.createQuery("FROM Docteur WHERE email = :email", Docteur.class);
        query.setParameter("email", email);
        docteur = (Docteur) query.getSingleResult();
        em.close();
        return docteur;
    }

    @Override
    public List<Docteur> findByDepartement(Departement departement) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("FROM Docteur WHERE departement.id = :id_departement", Docteur.class);
        query.setParameter("id_departement", departement.getId());
        List<Docteur> docteurs = query.getResultList();
        em.close();
        return docteurs;
    }
}

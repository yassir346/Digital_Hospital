package org.example.digital_hospital.repository.Impl;

import jakarta.persistence.*;
import org.example.digital_hospital.models.Personne;
import org.example.digital_hospital.repository.IPersonneRepository;

public class PersonneRepository implements IPersonneRepository {
    private EntityManagerFactory emf;
    public PersonneRepository(){
        this.emf = Persistence.createEntityManagerFactory("test");
    }

    public Personne save(Personne personne){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(personne);
        tx.commit();
        em.close();
        return personne;
    }

    @Override
    public Personne findByEmailAndPassword(String email, String password) {

        EntityManager em = emf.createEntityManager();
        TypedQuery<Personne> query = em.createQuery(
                "SELECT p FROM Personne p WHERE p.email = :email AND p.motDePasse = :password",
                Personne.class
        );
        query.setParameter("email", email);
        query.setParameter("password", password);
        Personne personne = query.getResultStream().findFirst().orElse(null);
        em.close();
        return personne;
    }

    @Override
    public Personne findByEmail(String email) {
        return null;
    }

    @Override
    public Personne findById(int id) {
        return null;
    }
}

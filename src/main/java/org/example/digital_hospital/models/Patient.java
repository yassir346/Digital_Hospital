package org.example.digital_hospital.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "patients")
@PrimaryKeyJoinColumn(name = "id_personnes")
public class Patient extends Personne{
    private float poids;
    private float taille;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Consultation> consultations;

    public Patient(String nom, String prenom, String email, String motDePasse, float poids, float taille, List<Consultation> consultations) {
        super(nom, prenom, email, motDePasse);
        this.poids = poids;
        this.taille = taille;
        this.consultations = consultations;
    }

    public Patient(float poids, float taille, List<Consultation> consultations) {
        this.poids = poids;
        this.taille = taille;
        this.consultations = consultations;
    }

    public Patient(){

    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public float getTaille() {
        return taille;
    }

    public void setTaille(float taille) {
        this.taille = taille;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "poids=" + poids +
                ", taille=" + taille +
                ", consultations=" + consultations +
                '}';
    }
}

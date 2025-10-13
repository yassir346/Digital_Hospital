package org.example.digital_hospital.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "docteurs")
@PrimaryKeyJoinColumn(name = "id_personne")
public class Docteur extends Personne{
    private String specialite;
    @OneToMany(mappedBy = "docteur", fetch = FetchType.EAGER)
    private List<Consultation> consultations;
    @ManyToOne
    @JoinColumn(name = "id_departement")
    Departement departement;

    public Docteur(String nom, String prenom, String email, String motDePasse, String specialite, List<Consultation> consultations, Departement departement) {
        super(nom, prenom, email, motDePasse);
        this.specialite = specialite;
        this.consultations = consultations;
        this.departement = departement;
    }

    public Docteur(String specialite, List<Consultation> consultations, Departement departement) {
        this.specialite = specialite;
        this.consultations = consultations;
        this.departement = departement;
    }

    public Docteur(String nom, String prenom, String email, String motDePasse) {
        super(nom, prenom, email, motDePasse);
    }

    public Docteur() {
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    @Override
    public String toString() {
        return "Docteur{" +
                "specialite='" + specialite + '\'' +
                ", consultations=" + (consultations != null ? consultations.size() : 0) +
                ", departement=" + departement +
                '}';
    }
}

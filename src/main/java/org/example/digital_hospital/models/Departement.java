package org.example.digital_hospital.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "departement")
public class Departement {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name="nom", unique = true, length=50, nullable=false)
    private String nom;
    @OneToMany(mappedBy = "departement")
    private List<Docteur> docteurs;
    @OneToMany(mappedBy = "departement")
    private List<Salle> salles;

    public Departement(int id, String nom, List<Docteur> docteurs, List<Salle> salles) {
        this.id = id;
        this.nom = nom;
        this.docteurs = docteurs;
        this.salles = salles;
    }

    public Departement() {
    }

    public List<Salle> getSalles() {
        return salles;
    }

    public void setSalles(List<Salle> salles) {
        this.salles = salles;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Docteur> getDocteurs() {
        return docteurs;
    }

    public void setDocteurs(List<Docteur> docteurs) {
        this.docteurs = docteurs;
    }

    @Override
    public String toString() {
        return "Departement{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}

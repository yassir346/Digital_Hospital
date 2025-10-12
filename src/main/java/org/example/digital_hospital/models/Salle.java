package org.example.digital_hospital.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "salles")
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private int capacite;
    @Temporal(TemporalType.TIMESTAMP)
    private List<LocalDateTime> creneaux;
    @ManyToOne
    @JoinColumn(name = "id_departement")
    private Departement departement;

    public Salle(int id, String nom, int capacite, List<LocalDateTime> creneaux) {
        this.id = id;
        this.nom = nom;
        this.capacite = capacite;
        this.creneaux = creneaux;
    }

    public Salle() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public List<LocalDateTime> getCreneaux() {
        return creneaux;
    }

    public void setCreneaux(List<LocalDateTime> creneaux) {
        this.creneaux = creneaux;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    @Override
    public String toString() {
        return "Salle{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", capacite=" + capacite +
                ", creneaux=" + creneaux +
                '}';
    }
}

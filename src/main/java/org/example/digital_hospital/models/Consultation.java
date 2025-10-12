package org.example.digital_hospital.models;

import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "consultations")
public class Consultation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime heureEtDate;
    @Enumerated(EnumType.STRING)
    private Statut statut;
    private String compteRendu;
    @ManyToOne
    @JoinColumn(name = "id_patient")
    Patient patient;
    @ManyToOne
    @JoinColumn(name = "id_docteur")
    Docteur docteur;

    public Consultation(int id, LocalDateTime heureEtDate, Statut statut, String compteRendu, Patient patient, Docteur docteur) {
        this.id = id;
        this.heureEtDate = heureEtDate;
        this.statut = statut;
        this.compteRendu = compteRendu;
        this.patient = patient;
        this.docteur = docteur;
    }

    public Consultation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getHeureEtDate() {
        return heureEtDate;
    }

    public void setHeureEtDate(LocalDateTime heureEtDate) {
        this.heureEtDate = heureEtDate;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public String getCompteRendu() {
        return compteRendu;
    }

    public void setCompteRendu(String compteRendu) {
        this.compteRendu = compteRendu;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Docteur getDocteur() {
        return docteur;
    }

    public void setDocteur(Docteur docteur) {
        this.docteur = docteur;
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "id=" + id +
                ", heureEtDate=" + heureEtDate +
                ", statut=" + statut +
                ", compteRendu='" + compteRendu + '\'' +
                ", patient=" + patient +
                ", docteur=" + docteur +
                '}';
    }
}

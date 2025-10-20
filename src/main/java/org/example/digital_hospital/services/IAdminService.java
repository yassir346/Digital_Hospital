package org.example.digital_hospital.services;

import org.example.digital_hospital.models.Consultation;
import org.example.digital_hospital.models.Departement;
import org.example.digital_hospital.models.Docteur;
import org.example.digital_hospital.models.Salle;

import java.util.List;

public interface IAdminService {
    void createDocteur(Docteur docteur);
    void updateDocteur(Docteur docteur);
    void deleteDocteur(Docteur docteur);
    List<Docteur> getDoctors();
    Docteur getDocteurById(int id);
    void createDepartement(Departement departement);
    void updateDepartement(Departement departement);
    void deleteDepartement(Departement departement);
    List<Departement> getDepartements();
    Departement getDepartementById(int id);
    void attacherDocteurDepartement(Departement departement, Docteur docteur);
    void createSalle(Salle salle);
    void updateSalle(Salle salle);
    void deleteSalle(Salle salle);
    List<Salle> getSalles();
    Salle getSalleById(int id);
    List<Consultation> getConsultations();
    Consultation getConsultationById(int id);

}

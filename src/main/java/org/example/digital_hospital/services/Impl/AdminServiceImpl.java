package org.example.digital_hospital.services.Impl;

import org.example.digital_hospital.exceptions.NotFoundException;
import org.example.digital_hospital.exceptions.ValidationException;
import org.example.digital_hospital.models.Consultation;
import org.example.digital_hospital.models.Departement;
import org.example.digital_hospital.models.Docteur;
import org.example.digital_hospital.models.Salle;
import org.example.digital_hospital.repository.*;
import org.example.digital_hospital.services.IAdminService;
import org.example.digital_hospital.services.IConsultationService;
import org.example.digital_hospital.services.IDepartementService;

import java.util.List;

public class AdminServiceImpl implements IAdminService {
    IConsultationRepository consultationRepository;
    IDepartementRepository departementRepository;
    IDocteurRepository docteurRepository;
    IPatientRepository patientRepository;
    ISalleRepository salleRepository;

    public AdminServiceImpl(IConsultationRepository consultationRepository, IDepartementRepository departementRepository, IDocteurRepository docteurRepository, IPatientRepository patientRepository, ISalleRepository salleRepository) {
        this.consultationRepository = consultationRepository;
        this.departementRepository = departementRepository;
        this.docteurRepository = docteurRepository;
        this.patientRepository = patientRepository;
        this.salleRepository = salleRepository;
    }

    @Override
    public void createDocteur(Docteur docteur) throws ValidationException{
        validate(docteur);
        docteurRepository.save(docteur);
    }

    @Override
    public void updateDocteur(Docteur docteur) throws ValidationException{
        validate(docteur);
        Docteur foundDocteur = docteurRepository.findById(docteur.getId());
        docteurRepository.update(foundDocteur);
    }

    @Override
    public void deleteDocteur(Docteur docteur) throws ValidationException{
        if(docteur == null){
            throw new ValidationException("Le docteur que vous voulez supprimer n'existe pas.");
        }
    }

    @Override
    public List<Docteur> getDoctors() throws NotFoundException{
        if(docteurRepository.findAll().isEmpty()){
            throw new NotFoundException("Il n'y a auccun docteur.");
        }
        List<Docteur> docteurs = docteurRepository.findAll();
        return docteurs;
    }

    @Override
    public Docteur getDocteurById(int id) throws ValidationException, NotFoundException{
        if(id <= 0){
            throw new ValidationException("L'id nes pas valide, Entrez un id valide");
        }
        if (docteurRepository.findById(id) == null){
            throw new NotFoundException("Le docteur n'est pas trouvé.");
        }
        Docteur docteurTrouve = docteurRepository.findById(id);
        return docteurTrouve;
    }

    @Override
    public void createDepartement(Departement departement) throws ValidationException{
        if (departement == null){
            throw new ValidationException("Departement est nul");
        }
        if(departement.getNom() == null || departement.getNom().isEmpty()){
            throw new ValidationException("Le nom du département est nul ou vide.");
        }
        departementRepository.save(departement);
    }

    @Override
    public void updateDepartement(Departement departement) throws ValidationException{
        if (departement == null){
            throw new ValidationException("Departement est nul");
        }
        if(departement.getNom() == null || departement.getNom().isEmpty()){
            throw new ValidationException("Le département est nul ou vide.");
        }
        if (departementRepository.findById(departement.getId()) == null){
            throw new ValidationException("Département n'est pas trouvé.");
        }
        if (departementRepository.findById(departement.getId()) != null){
            throw new ValidationException("Département existe déja.");
        }
        Departement foundDepartement = departementRepository.findById(departement.getId());
        departementRepository.update(foundDepartement);
    }

    @Override
    public void deleteDepartement(Departement departement) throws ValidationException{
        if(departement == null){
            throw new ValidationException("Departement n'existe pas.");
        }
        departementRepository.delete(departement.getId());
    }

    @Override
    public List<Departement> getDepartements() throws NotFoundException{
        if (departementRepository.findAll().isEmpty()){
            throw new NotFoundException("Auccun departement est trouvé");
        }
        return departementRepository.findAll();
    }

    @Override
    public Departement getDepartementById(int id) throws ValidationException{
        if(id <= 0){
            throw new ValidationException("L'id entré est invalide");
        }
        if(departementRepository.findById(id) == null){
            throw new ValidationException("Id Introuvable");
        }
        return departementRepository.findById(id);
    }

    @Override
    public void attacherDocteurDepartement(Departement departement, Docteur docteur) throws ValidationException{
        if (docteur == null){
            throw new ValidationException("Docteur n'est pas trouvé");
        }
        if (departement == null){
            throw new ValidationException("Département n'est pas trouvé");
        }
        Docteur foundDocteur = docteurRepository.findById(docteur.getId());
        docteur.setDepartement(departement);
        docteurRepository.update(foundDocteur);
    }

    @Override
    public void createSalle(Salle salle) throws ValidationException{
        if (salle == null) {
            throw new ValidationException("Room is null");
        }
        if (salle.getNom() == null || salle.getNom().isEmpty()) {
            throw new ValidationException("nom de la salle n'est pas valide.");
        }
        if (salle.getCapacite() < 0) {
            throw new ValidationException("La capacité de la salle doit être positive");
        }

        if (salle.getCapacite() > 7) {
            throw new ValidationException("La capacité de la salle ne doit pas être supérieure à 7");
        }
        salleRepository.save(salle);
    }

    @Override
    public void updateSalle(Salle salle) throws ValidationException{
        if (salle == null) {
            throw new ValidationException("Room is null");
        }
        if (salle.getNom() == null || salle.getNom().isEmpty()) {
            throw new ValidationException("nom de la salle n'est pas valide.");
        }
        if (salle.getCapacite() < 0) {
            throw new ValidationException("La capacité de la salle doit être positive");
        }

        if (salle.getCapacite() > 7) {
            throw new ValidationException("La capacité de la salle ne doit pas être supérieure à 7");
        }
        Salle foundSalle = salleRepository.findById(salle.getId());
        salleRepository.update(foundSalle);
    }

    @Override
    public void deleteSalle(Salle salle) throws ValidationException{
        if (salle == null){
            throw new ValidationException("La salle est nulle.");
        }
        salleRepository.delete(salle.getId());
    }

    @Override
    public List<Salle> getSalles() throws NotFoundException {
        if (salleRepository.findAll().isEmpty()){
            throw new NotFoundException("Auccune salle est trouvée.");
        }
        return salleRepository.findAll();
    }

    @Override
    public Salle getSalleById(int id) {
        if (id <= 0) {
            throw new ValidationException("Room id is not valid");
        }
        if (salleRepository.findById(id) == null) {
            throw new NotFoundException("Room not found");
        }
        return salleRepository.findById(id);
    }

    @Override
    public void getConsultation() throws ValidationException{
        if (consultationRepository.findAll().isEmpty()){
            throw new ValidationException("Accune consultation est trouvée.");
        }
        consultationRepository.findAll();
    }

    @Override
    public Consultation getConsultationById(int id) {
        if(id <= 0){
            throw new ValidationException("Entrez un id valid");
        }
        if(consultationRepository.findById(id) == null){
            throw new ValidationException("Consultation n'est pas trouvée.");
        }
        return consultationRepository.findById(id);
    }

    public void validate(Docteur docteur){
        if(docteur == null){
            throw new ValidationException("L'objet du docteur est null.");
        }

        if(docteur.getEmail() == null || docteur.getEmail().isEmpty()){
            throw new ValidationException("L'email est nul ou vide.");
        }

        if(docteur.getMotDePasse() == null || docteur.getMotDePasse().isEmpty()){
            throw new ValidationException("Le mot de passe est nul ou vide.");
        }
        if(docteur.getNom() == null || docteur.getNom().isEmpty()){
            throw new ValidationException("Le nom est nul ou vide.");
        }

        if(docteur.getPrenom() == null || docteur.getPrenom().isEmpty()){
            throw new ValidationException("Le prenom est nul ou vide.");
        }

        if(docteur.getRole() == null || docteur.getRole().isEmpty()){
            throw new ValidationException("Le role est nul ou vide.");
        }
        if(docteurRepository.findByEmail(docteur.getEmail()) != null){
            throw new ValidationException("L'email existe déja.");
        }
    }
}

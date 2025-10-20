import org.example.digital_hospital.models.*;
import org.example.digital_hospital.repository.*;
import org.example.digital_hospital.repository.Impl.*;
import org.example.digital_hospital.services.IAdminService;
import org.example.digital_hospital.services.Impl.AdminServiceImpl;
import org.example.digital_hospital.servlets.ConsultationServlet;

import java.time.LocalDateTime;
import java.util.List;

public class App {
    public static void main(String[] args) {
        IDepartementRepository departementRepository = new DepartementRepositoryImpl();
        IPatientRepository patientRepository = new PatientRepositoryImpl();
        IDocteurRepository docteurRepository = new DocteurRepositoryImpl();
        IConsultationRepository consultationRepository = new ConsultationRepositoryImpl();
        ISalleRepository salleRepository = new SalleRepositoryImpl();

        Docteur docteur = new Docteur();
        docteur.setNom("a");
        Patient patient = new Patient();
        Salle salle = new Salle();
        Consultation consultation = new Consultation();

//        patient.setNom("amin");
//        patient.setPrenom("amin");
//        patient.setEmail("email");
//        patient.setMotDePasse("azerty");
//        patient.setPoids(54);
//        patient.setTaille(111);
//        patient.setConsultations(null);
//        patient.setRole("patient");
//        patientRepository.save(patient);

//        docteur.setNom("Anas");
//        docteur.setPrenom("Ami");
//        docteur.setEmail("email_docteur");
//        docteur.setMotDePasse("azerty");
        Departement RH = departementRepository.findById(3);
//        docteur.setDepartement(RH);
//        docteur.setRole("docteur");
//
        Docteur foundDocteur = docteurRepository.findById(5);
//        foundDocteur.setEmail("email_docteur");
//        foundDocteur.setPrenom("bdel");
//        foundDocteur.setSpecialite("Chirurgien");
//        docteurRepository.update(foundDocteur);
//        List<Docteur> docteurs = docteurRepository.findAll();
//        for(Docteur d : docteurs) {
//            System.out.println(docteurs);
//        }

//        consultation.setHeureEtDate(LocalDateTime.now());
//        consultation.setCompteRendu("rendu");
//        Patient foundPatient = patientRepository.findById(1);
//        consultation.setPatient(foundPatient);
//        consultation.setDocteur(foundDocteur);
//        consultation.setStatut(Statut.RESERVEE);
//        consultationRepository.save(consultation);
//
        List<Consultation> consultations = consultationRepository.findAll();
//        for (Consultation c : consultations){
//            System.out.println(c);
//        }

        List<Consultation> consultations1Reservee = consultations.stream().filter(consultation1 -> consultation1.getStatut() == Statut.RESERVEE).toList();

        for (Consultation c : consultations1Reservee){
            System.out.println(consultations1Reservee);
        }

        ConsultationServlet consultationServlet = new ConsultationServlet();
    }

}

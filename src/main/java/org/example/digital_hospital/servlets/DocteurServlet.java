package org.example.digital_hospital.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.digital_hospital.models.Consultation;
import org.example.digital_hospital.models.Docteur;
import org.example.digital_hospital.models.Salle;
import org.example.digital_hospital.repository.*;
import org.example.digital_hospital.repository.Impl.*;
import org.example.digital_hospital.services.IAdminService;
import org.example.digital_hospital.services.Impl.AdminServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet("/docteurs")
public class DocteurServlet extends HttpServlet {
    private IDocteurRepository docteurRepository = new DocteurRepositoryImpl();
    private IConsultationRepository consultationRepository = new ConsultationRepositoryImpl();
    private ISalleRepository salleRepository = new SalleRepositoryImpl();
    private IPatientRepository patientRepository = new PatientRepositoryImpl();
    private IDepartementRepository departementRepository = new DepartementRepositoryImpl();
    private IAdminService adminService = new AdminServiceImpl(consultationRepository, departementRepository, docteurRepository, patientRepository, salleRepository);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "listeDocteurs";
        }
        switch (action){
            case "creer":
                Docteur docteur = new Docteur();
                request.setAttribute("docteur", docteur);
                request.getRequestDispatcher("docteur/formDocteur.jsp").forward(request, response);
                break;

            case "modifier":
                int id = Integer.parseInt(request.getParameter("id"));
                docteur = adminService.getDocteurById(id);
                request.setAttribute("docteur", docteur);
                request.getRequestDispatcher("/docteur/formDocteur.jsp").forward(request, response);

                break;

            case "supprimer":
                break;

            default:
                try {
                    List<Docteur> docteurs = adminService.getDoctors();
                    request.setAttribute("docteurs", docteurs);
                    request.getRequestDispatcher("/docteur/listeDocteurs.jsp").forward(request, response);
                } catch (ServletException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = request.getParameter("id") == null || request.getParameter("id").isEmpty() ? 0 : Integer.parseInt(request.getParameter("id"));

        Docteur docteur = new Docteur();

        if (id == 0){
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String email = request.getParameter("email");
            String motDePasse = request.getParameter("password");
            String specialite = request.getParameter("specialite");
            docteur.setNom(nom);
            docteur.setPrenom(prenom);
            docteur.setEmail(email);
            docteur.setMotDePasse(motDePasse);
            docteur.setSpecialite(specialite);
            docteur.setRole("DOCTEUR");
            try {
                adminService.createDocteur(docteur);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        response.sendRedirect("docteurs");
    }


}
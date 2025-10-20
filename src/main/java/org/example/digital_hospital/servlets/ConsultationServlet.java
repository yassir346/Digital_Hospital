package org.example.digital_hospital.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.digital_hospital.models.Consultation;
import org.example.digital_hospital.models.Docteur;
import org.example.digital_hospital.models.Statut;
import org.example.digital_hospital.repository.*;
import org.example.digital_hospital.repository.Impl.*;
import org.example.digital_hospital.services.IAdminService;
import org.example.digital_hospital.services.IPatientService;
import org.example.digital_hospital.services.Impl.AdminServiceImpl;
import org.example.digital_hospital.services.Impl.PatientServiceImpl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet(name = "ConsultationServlet", value = "/consultations")
public class ConsultationServlet extends HttpServlet {
    IPatientRepository patientRepository = new PatientRepositoryImpl();
    IDocteurRepository docteurRepository = new DocteurRepositoryImpl();
    IConsultationRepository consultationRepository = new ConsultationRepositoryImpl();
    ISalleRepository salleRepository = new SalleRepositoryImpl();
    IDepartementRepository departementRepository = new DepartementRepositoryImpl();
    IPatientService patientService = new PatientServiceImpl(patientRepository, docteurRepository, consultationRepository, salleRepository);
    IAdminService adminService = new AdminServiceImpl(consultationRepository, departementRepository, docteurRepository, patientRepository, salleRepository);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null){
            action = "listeConsultations";
        }
        switch(action) {
            case "creer":
                Consultation consultation = new Consultation();
                request.setAttribute("consultation", consultation);
                request.getRequestDispatcher("/consultation/formConsultation.jsp").forward(request, response);
                break;

            default:
                List<Consultation> consultations = adminService.getConsultations();
                request.setAttribute("consultations", consultations);
                request.getRequestDispatcher("/consultation/listeConsultations.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            int id = request.getParameter("id") == null || request.getParameter("id").isEmpty() ? 0 : Integer.parseInt(request.getParameter("id"));

            if (id == 0){

                String heureEtDate = request.getParameter("heureEtDate");
                Consultation consultation = new Consultation();
                consultation.setHeureEtDate(LocalDateTime.parse(heureEtDate));
                consultation.setStatut(Statut.RESERVEE);
                try{
                    patientService.createConsultation(consultation);
                }catch (Exception e){
                    e.printStackTrace();
                    String errorMassege = e.getMessage();
                    request.setAttribute("errorMassege", errorMassege);
                    request.getRequestDispatcher("/consultation/formConsultation.jsp").forward(request, response);
                }
            }else {
                String statut = request.getParameter("statut");
                Consultation consultationAChanger = adminService.getConsultationById(id);
                consultationAChanger.setStatut(Statut.valueOf(statut));
                patientService.updateConsultation(consultationAChanger);
                List<Consultation> consultations = adminService.getConsultations();
                request.setAttribute("consultations", consultations);
                request.getRequestDispatcher("/consultation/listeConsultations.jsp").forward(request, response);
            }

        response.sendRedirect("consultations");
    }
}
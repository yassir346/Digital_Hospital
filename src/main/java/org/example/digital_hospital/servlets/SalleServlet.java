package org.example.digital_hospital.servlets;

import java.io.*;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.digital_hospital.models.Salle;
import org.example.digital_hospital.repository.*;
import org.example.digital_hospital.repository.Impl.*;
import org.example.digital_hospital.services.IAdminService;
import org.example.digital_hospital.services.Impl.AdminServiceImpl;

@WebServlet(name = "salleServlet", value = "/salles")
public class SalleServlet extends HttpServlet {

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
            action = "list";
        }

        switch(action){
            case "new":
                Salle salle = new Salle();
                request.setAttribute("salle", salle);
                request.getRequestDispatcher("/salle/formSalle.jsp").forward(request, response);
                break;
            case "edit":
                int id = Integer.parseInt(request.getParameter("id"));
                Salle salle1 = adminService.getSalleById(id);
                request.setAttribute("salle", salle1);
                request.getRequestDispatcher("/salle/formSalle.jsp").forward(request, response);
                break;
            case "delete":
                try {
                    Salle salle2 = adminService.getSalleById(Integer.parseInt(request.getParameter("id")));
                    adminService.deleteSalle(salle2);
                    response.sendRedirect(request.getContextPath() + "/salles");
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            default:
                List<Salle> salles = adminService.getSalles();
                request.setAttribute("salles", salles);
                request.getRequestDispatcher(   "/salle/listeSalles.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = request.getParameter("id") == null || request.getParameter("id").isEmpty()
                ? 0 : Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        int capacite = Integer.parseInt(request.getParameter("capacite"));


        if (id == 0){
            try{
                Salle salle = new Salle();
                salle.setNom(nom);
                salle.setCapacite(capacite);
                adminService.createSalle(salle);
            }catch (Exception e){
                e.printStackTrace();
                request.setAttribute("errorMessage", e.getMessage());
                request.getRequestDispatcher("/salle/formSalle.jsp").forward(request, response);
            }
        }else{
            Salle salle;
            salle = adminService.getSalleById(id);
            if(salle != null){
                try {
                    salle.setNom(nom);
                    salle.setCapacite(capacite);
                    adminService.updateSalle(salle);
                }catch (Exception e){
                    e.printStackTrace();
                    request.setAttribute("errorMessage", e.getMessage());
                    request.getRequestDispatcher("/salle/formSalle.jsp").forward(request, response);
                }

            }
        }
        response.sendRedirect("salles");
    }
}
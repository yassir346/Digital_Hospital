package org.example.digital_hospital.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.digital_hospital.models.Departement;
import org.example.digital_hospital.repository.*;
import org.example.digital_hospital.repository.Impl.*;
import org.example.digital_hospital.services.IAdminService;
import org.example.digital_hospital.services.Impl.AdminServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DepartementServlet", value = {"/departements"})
public class DepartementServlet extends HttpServlet {
    IConsultationRepository consultationRepository = new ConsultationRepositoryImpl();
    IPatientRepository patientRepository = new PatientRepositoryImpl();
    IDocteurRepository docteurRepository = new DocteurRepositoryImpl();
    ISalleRepository salleRepository = new SalleRepositoryImpl();
    IDepartementRepository departementRepository = new DepartementRepositoryImpl();

    IAdminService adminService = new AdminServiceImpl(consultationRepository, departementRepository, docteurRepository, patientRepository, salleRepository);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null) action = "listeDepartements";

        switch (action) {
            case "creer":
                Departement departement = new Departement();
                request.setAttribute("departement", departement);
                request.getRequestDispatcher("/departement/formDepartement.jsp").forward(request, response);
                break;

            case "modifier":
                int id = Integer.parseInt(request.getParameter("id"));
                Departement departement1 = adminService.getDepartementById(id);
                request.setAttribute("departement1", departement1);
                request.getRequestDispatcher("/departement/formDepartement.jsp").forward(request, response);
                break;

            case "supprimer":
                try {
                    Departement departement2 = adminService.getDepartementById(Integer.parseInt(request.getParameter("id")));
                    adminService.deleteDepartement(departement2);
                    response.sendRedirect(request.getContextPath() + "/departements");
                }catch(Exception e){
                    e.printStackTrace();
                    request.getRequestDispatcher("/departement/formDepartement.jsp").forward(request, response);
                }
                break;

            default:
                List<Departement> departements = adminService.getDepartements();
                request.setAttribute("departements", departements);
                request.getRequestDispatcher("/departement/listeDepartements.jsp").forward(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = request.getParameter("id") == null || request.getParameter("id").isEmpty() ? 0 : Integer.parseInt(request.getParameter("id"));

        if (id == 0){
            Departement departement = new Departement();
            String nom = request.getParameter("nom");
            departement.setNom(nom);
            try {
                adminService.createDepartement(departement);
            }catch (Exception e){
                e.printStackTrace();
                request.getRequestDispatcher("/departement/listeDepartements.jsp");
            }
        }else{
            Departement departement = adminService.getDepartementById(Integer.parseInt(request.getParameter("id")));
            String nom = request.getParameter("nom");
            departement.setNom(nom);
            try {
                adminService.updateDepartement(departement);
            } catch (Exception e) {
                e.printStackTrace();
                request.getRequestDispatcher("/departement/listeDepartements.jsp");
            }
        }
        response.sendRedirect("departements");
    }
}

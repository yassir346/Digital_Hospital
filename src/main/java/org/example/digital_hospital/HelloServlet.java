package org.example.digital_hospital;

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

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

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
            action = "test";
        }

        switch(action){
            case "new":
                Salle salle = new Salle();
                request.setAttribute("salle", salle);
                request.getRequestDispatcher("/salle/formSalle.jsp").forward(request, response);
                break;

            case "test":
                List<Salle> salles = adminService.getSalles();
                request.setAttribute("salles", salles);
                request.getRequestDispatcher("/tests/test.jsp");
                break;

            default:
                List<Salle> salles2 = adminService.getSalles();
                request.setAttribute("salles", salles2);
                request.getRequestDispatcher("/salle/list.jsp");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
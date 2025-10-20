package org.example.digital_hospital.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.digital_hospital.exceptions.ValidationException;
import org.example.digital_hospital.models.Patient;
import org.example.digital_hospital.repository.IPersonneRepository;
import org.example.digital_hospital.repository.Impl.PersonneRepository;
import org.example.digital_hospital.services.IAuthService;
import org.example.digital_hospital.services.Impl.AuthServiceImpl;

import java.io.IOException;

@WebServlet(name = "Auth", urlPatterns = {"/auth"})
public class RegisterServlet extends HttpServlet {
    private IAuthService authService;

    @Override
    public void init() {
        IPersonneRepository personRepository = new PersonneRepository();
        authService = new AuthServiceImpl(personRepository);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/auth/signUp.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String motDePasse = request.getParameter("motDePasse");
        Patient patient = null;

        try {
            patient = new Patient();
            patient.setEmail(email);
            patient.setPrenom(prenom);
            patient.setNom(nom);
            patient.setMotDePasse(motDePasse);
            patient.setRole("Patient");

            authService.signUp(patient);

            response.sendRedirect(request.getContextPath() + "/auth/logIn.jsp");

        } catch (ValidationException e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.setAttribute("patient", patient);
            request.getRequestDispatcher("/auth/signUp.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred while processing your request.");
            request.setAttribute("patient", patient);
            request.getRequestDispatcher("/auth/signUp.jsp").forward(request, response);
        }
    }
}
package org.example.digital_hospital.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.digital_hospital.exceptions.ValidationException;
import org.example.digital_hospital.models.Patient;
import org.example.digital_hospital.models.Personne;
import org.example.digital_hospital.repository.IPersonneRepository;
import org.example.digital_hospital.repository.Impl.PersonneRepository;
import org.example.digital_hospital.services.IAuthService;
import org.example.digital_hospital.services.Impl.AuthServiceImpl;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private IAuthService authService;

    @Override
    public void init() {
        IPersonneRepository personRepository = new PersonneRepository();
        authService = new AuthServiceImpl(personRepository);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        request.getRequestDispatcher("/auth/logIn.jsp").forward(request, response);
}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String email = request.getParameter("email");
    String motDePasse = request.getParameter("motDePasse");

    try {
        Patient tempPerson = new Patient();
        tempPerson.setEmail(email);
        tempPerson.setMotDePasse(motDePasse);

        Personne loggedInUser = authService.login(tempPerson);

        HttpSession session = request.getSession();
        session.setAttribute("user", loggedInUser);
        session.setAttribute("role", loggedInUser.getRole());

        switch (loggedInUser.getRole().toUpperCase()) {
            case "ADMIN":
                response.sendRedirect(request.getContextPath() + "/admin/dashboard.jsp");
                break;
            case "DOCTEUR":
                response.sendRedirect(request.getContextPath() + "/consultations");
                break;
            case "PATIENT":
                response.sendRedirect(request.getContextPath() + "/formConsultation.jsp");
                break;
            default:
                request.setAttribute("errorMessage", "Unknown role: " + loggedInUser.getRole());
                request.getRequestDispatcher("/auth/logIn.jsp").forward(request, response);
        }

    } catch (ValidationException e) {
        request.setAttribute("errorMessage", e.getMessage());
        request.getRequestDispatcher("/auth/logIn.jsp").forward(request, response);
    } catch (Exception e) {
        e.printStackTrace();
        request.setAttribute("errorMessage", e.getMessage());
        request.getRequestDispatcher("/auth/logIn.jsp").forward(request, response);
    }
}
}
package org.example.digital_hospital;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;


public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body><h1>Something weird in the water</h1></body></html>");
    }
}
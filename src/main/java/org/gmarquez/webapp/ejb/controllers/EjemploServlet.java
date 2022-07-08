package org.gmarquez.webapp.ejb.controllers;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.gmarquez.webapp.ejb.service.ServiceEJB;

import java.io.IOException;


@WebServlet("/index")
public class EjemploServlet extends HttpServlet {

    @EJB // Convierte en EJB y lo inyecta
    private ServiceEJB serviceEJB;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("saludo", this.serviceEJB.saludar("Gustavo"));

        // Redirigiendo la peticion a un archivo jsp
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}

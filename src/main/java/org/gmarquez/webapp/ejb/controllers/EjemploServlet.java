package org.gmarquez.webapp.ejb.controllers;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.gmarquez.webapp.ejb.models.Producto;
import org.gmarquez.webapp.ejb.service.ServiceEJB;
import org.gmarquez.webapp.ejb.service.ServiceEJBLocal;
import org.gmarquez.webapp.ejb.service.ServiceEJBStateful;

import java.io.IOException;


@WebServlet("/index")
public class EjemploServlet extends HttpServlet {

    @EJB // Convierte en EJB y lo inyecta, pero el contexto es Global sesion
    private ServiceEJB serviceEJB;


    @Inject // Para utilizar contexto + EJB se debe usar inject para que reconozca el contexto
    private ServiceEJBStateful serviceEJBStateful;

    @Inject
    private ServiceEJBLocal serviceEJBLocal;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("saludo", this.serviceEJB.saludar("Gustavo"));
        req.setAttribute("saludo2", this.serviceEJBStateful.saludar("Adolfo"));

        Producto productoFull = this.serviceEJBLocal.crear(new Producto("Producto Full"));
        System.out.println("productoFull = " + productoFull);

        req.setAttribute("productos", this.serviceEJBLocal.listar());

        // Redirigiendo la peticion a un archivo jsp
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}

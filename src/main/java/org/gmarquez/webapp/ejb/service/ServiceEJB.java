package org.gmarquez.webapp.ejb.service;

import jakarta.ejb.Stateless;

// Convierte en EJB
@Stateless
public class ServiceEJB {

    public String saludar(String nombre) {
        return "Hello World " + nombre + "!";
    }

}

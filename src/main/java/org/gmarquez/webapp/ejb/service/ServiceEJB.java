package org.gmarquez.webapp.ejb.service;

import jakarta.ejb.Stateless;

// Convierte en EJB, pero sera un unico estado para todas las sesiones
@Stateless
public class ServiceEJB {

    private Long contador = 0L;
    public String saludar(String nombre) {
        System.out.println("Saludando desde instancia Stateless: " + this);
        System.out.println("Contador: " + contador);
        contador++;
        return "Hello World " + nombre + "!";
    }

}

package org.gmarquez.webapp.ejb.service;

import jakarta.ejb.Stateful;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;

import java.io.Serializable;

// Convierte en EJB, pero sera un unico para cada sesion
@Stateful
@SessionScoped // Scope de sesion, necesario el contexto para que sea util Stateful
// @RequestScoped // Scope de peticion
public class ServiceEJBStateful implements Serializable {

    private Long contador = 0L;

    public String saludar(String nombre) {
        System.out.println("Saludando desde instancia Stateful: " + this);
        System.out.println("Contador: " + contador);
        contador++;
        return "Hello World " + nombre + "!";
    }

}

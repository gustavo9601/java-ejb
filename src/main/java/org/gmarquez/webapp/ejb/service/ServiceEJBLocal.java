package org.gmarquez.webapp.ejb.service;

import jakarta.ejb.Local;
import org.gmarquez.webapp.ejb.models.Producto;

import java.util.List;

@Local  // Indica que se usara dentro del mismo proyecto
public interface ServiceEJBLocal {
    String saludar(String nombre);

    List<Producto> listar();

    Producto crear(Producto producto);
}

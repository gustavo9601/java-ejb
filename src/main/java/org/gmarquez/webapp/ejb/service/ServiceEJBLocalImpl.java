package org.gmarquez.webapp.ejb.service;

import jakarta.ejb.Stateful;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.RequestScoped;
import org.gmarquez.webapp.ejb.models.Producto;

import java.util.ArrayList;
import java.util.List;

@Stateful
@RequestScoped
public class ServiceEJBLocalImpl implements ServiceEJBLocal {

    @Override
    public String saludar(String nombre) {
        return "Hello World " + nombre + "!";
    }

    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Producto 1"));
        productos.add(new Producto("Producto 2"));
        return productos;
    }

    @Override
    public Producto crear(Producto producto) {
        Producto nuevoProducto = new Producto();
        nuevoProducto.setNombre(producto.getNombre());
        return nuevoProducto;
    }
}

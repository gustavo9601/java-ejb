package org.gmarquez.webapp.ejb;

import org.gmarquez.webapp.ejb.models.ProductoRemoto;
import org.gmarquez.webapp.ejb.service.ServiceEJBRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        // Invocando service de la dependencia
        ServiceEJBRemote serviceEJBRemote = null;

        // Configuraciones base para relizar la comunicacion remota con el repositorio
        // Se dejaron las variable en /resources/jndi.properties
        // final Properties env = new Properties();

        // env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        // env.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        // env.put("jboss.naming.client.ejb.context", true);

        try {
            // InitialContext remoteContext = new InitialContext(env); se pasa el env, si no tenemos las variables en el jndi.properties
            InitialContext remoteContext = new InitialContext();

            // Pasamos el path que provee widfly en el deploy especificando la ruta de la interfaz remote
            serviceEJBRemote = (ServiceEJBRemote) remoteContext.lookup("ejb:/java-ejb-remote/ServiceEJBRemoteImpl!org.gmarquez.webapp.ejb.service.ServiceEJBRemote?stateful");
        
            
            String saludo = serviceEJBRemote.saludar("Gustavo Remote");
            System.out.println("saludo remote= " + saludo);


            ProductoRemoto productoRemoto = serviceEJBRemote.crear(new ProductoRemoto("Producto Remoto1"));
            System.out.println("producto = " + productoRemoto);

            System.out.println("*".repeat(100));
            serviceEJBRemote.listar()
                    .forEach(producto1 -> System.out.println("producto remote = " + producto1));


        } catch (NamingException e) {
            throw new RuntimeException(e);
        }


    }
}

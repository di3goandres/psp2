package edu.uniandes.ecos.view;

import edu.uniandes.ecos.controller.GestorNegocio;
import edu.uniandes.ecos.model.Simpson;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;


/**
 * Hello world!
 *
 */
public class App extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Simpson datos = new Simpson(0, 0, 0);
        GestorNegocio.showHome(req, resp);
        GestorNegocio.showResults(req, resp, datos);

    }

    public void consoleInput(HttpServletRequest req, HttpServletResponse resp) throws Exception {
       
        Double parameterX = Double.parseDouble(req.getParameter("paraX"));
        Double gradosLibertad = Double.parseDouble(req.getParameter("numGrad"));
        
        GestorNegocio gestorNegocio = new GestorNegocio();
       

        Simpson resultado = gestorNegocio.GestorNegocio( parameterX, gradosLibertad,10);
        gestorNegocio.showResults(req, resp, resultado);
    }

    public static void main(String[] args) throws Exception {
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new App()), "/*");
        server.start();
        server.join();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            GestorNegocio.showHome(req, resp);
            consoleInput(req, resp);
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.controller;

import edu.uniandes.ecos.model.Simpson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* 
* @author Diego Andres Montealegre Garcia
* @version 1.0, 02/22/05
* @since 1.0
*/
public class GestorNegocio {

    /**
     *
     * @param parameterX
     * @param gradosLibertad
     * @param numSegmentos
     * @return
     */
    public Simpson GestorNegocio(double parameterX, double gradosLibertad, double numSegmentos) {
        Simpson calculotIntegral = new Simpson(gradosLibertad, parameterX, numSegmentos);
        return calculotIntegral;
    }

    public static void showHome(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        PrintWriter pw = resp.getWriter();
        pw.write("<html>");
        pw.println("<h1>Taller No 5 - PSP 2</h1>");
        pw.println("<p>ECOS 2015 <br>Diego Andres Montealegre Garcia</p>");
        pw.write("<html>");
        pw.println("<br>los decimales con punto (10.9), no con coma<br>");
        pw.write("<hr>");
        pw.write("<form action=\"calc\" method=\"post\">"
                + "<table>"
                + "<tr><td>Parametro X: </td><td><input type=\"text\" name=\"paraX\"  value=\"\"> </td></tr>"
                + "<tr><td>Grados de libertad(dof): </td><td><input type=\"text\" name=\"numGrad\"  value=\"\"> </td></tr>"
                + "</table> <input type=\"submit\" value=\"realizar calculos\">"
                + "</form> ");
        pw.println("<h2></h2>");
        pw.write("</html>");

    }

    public static void showResults(HttpServletRequest req, HttpServletResponse resp,
            Simpson resultado)
            throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        resp.getWriter().println("<hr>");
        resp.getWriter().println("<h2>Resultados</h2>");
        pw.write("<form action=\"calc\" method=\"post\">"
                + "<table>"
                + "<tr><td>0 to X: </td><td>" + resultado.ObtenerParameterX() + " </td></tr>"
                + "<tr><td>Grados de libertad (dof): </td><td>" + resultado.ObtenerDof() + "</td></tr>"
                + "<tr><td>Integral Definitiva: </td><td>" + resultado.ObtenerP() + "</td></tr>"
                + "</table> "
                + "</form> ");
        resp.getWriter().println("<hr>");

    }

    public static void error(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.getWriter().println("Error!!!");
    }
}

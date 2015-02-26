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
 * @author COCO
 */
public class GestorNegocio {

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
        pw.write("<form action=\"calc\" method=\"post\">"
                + "<table>"
                + "<tr><td>Parametro X: </td><td><input type=\"text\" name=\"paraX\"  value=\"\"> </td></tr>"
                + "<tr><td>Grados de libertad:(dof) </td><td><input type=\"text\" name=\"numGrad\"  value=\"\"> </td></tr>"
                + "</table> <input type=\"submit\" value=\"realizar calculos\">"
                + "</form> ");
        pw.println("<h2></h2>");
        pw.write("</html>");

    }

    public static void showResults(HttpServletRequest req, HttpServletResponse resp,
            Simpson resultado)
            throws ServletException, IOException {
        resp.getWriter().println("<h2>Resultados</h2>");
        resp.getWriter().println("0 to X = " + resultado.ObtenerParameterX() + "<br>");
        resp.getWriter().println("dof: " + resultado.ObtenerDof() + "<br>");
        resp.getWriter().println("Integral Definitiva: " + resultado.ObtenerP() + "<br>");
        resp.getWriter().println("<hr>");

    }

    public static void error(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.getWriter().println("Error!!!");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.cursos.java.ejemplo.web01;

import com.mavha.cursos.java.ejemplo.logica.Conversion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mdominguez
 */
@WebServlet(name = "ListaConversionesServlet", urlPatterns = {"/historial"})
public class ListaConversionesServlet extends HttpServlet {    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesion = request.getSession(true);
        
        List<Conversion> historialLista = (List<Conversion>) sesion.getAttribute("historial");
        if(historialLista == null){
            historialLista = new ArrayList<>();
            sesion.setAttribute("historial", historialLista);
        }
        if(request.getAttribute("valor")!=null && request.getAttribute("resultado")!=null){
            Conversion unaConversion = new Conversion(  Double.valueOf(request.getAttribute("valor").toString()),
                                                request.getAttribute("tipoIngreso").toString(),
                                                Double.valueOf(request.getAttribute("resultado").toString()),
                                                request.getAttribute("tipoResultado").toString());
            historialLista.add(unaConversion);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<table border=\"1\">");
            sb.append("<tr>");
            sb.append("<td>FECHA</td>"
                    + "<td>Valor Ingresado</td>"
                    + "<td> Escala </td>"
                    + "<td>Valor Salida</td>"
                    + "<td>Escala</td>");
            sb.append("</td>");
            sb.append("<tr>");            
        for(Conversion aux : historialLista){
            sb.append("<tr>");
            sb.append("<td>"+aux.getFecha()+"</td>"
                    + "<td>"+aux.getValorIngreso()+"</td>"
                    + "<td>"+aux.getTipoValorIngreso()+"</td>"
                    + "<td>"+aux.getValorSalida()+"</td>"
                    + "<td>"+aux.getTipoValorSalida()+"</td>");
            sb.append("</td>");
            sb.append("<tr>");            
        }
        sb.append("</table>");
        PrintWriter salida = response.getWriter();
        salida.write(sb.toString());        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    

}

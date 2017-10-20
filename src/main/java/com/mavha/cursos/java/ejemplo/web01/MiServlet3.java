/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.cursos.java.ejemplo.web01;

import com.mavha.cursos.java.ejemplo.logica.Conversor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mdominguez
 */
@WebServlet(name = "MiServlet3", urlPatterns = {"/conversorAjax"})
public class MiServlet3 extends HttpServlet {

   private Conversor conversor;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); //To change body of generated methods, choose Tools | Templates.
        conversor = new Conversor();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {        
       try {
           PrintWriter out = resp.getWriter();
           StringBuilder resultado = new StringBuilder();
           resultado.append("<html><head><title>Conversor</title></head><body>");
           resultado.append("<h1>aplicacion conversion temperatura</h2>");
           resultado.append(formulario());
           out.write(resultado.toString());
           // agregado
           RequestDispatcher dispatcher = req.getRequestDispatcher("/historial");
           dispatcher.include(req, resp);
           
           String resultado2 = "</body></html>";                    
           out.write(resultado2);
       } catch (ServletException ex) {
           Logger.getLogger(MiServlet3.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    
    private String formulario(){
        StringBuilder form = new StringBuilder();
        form.append("<form method=\"POST\" action=\"./conversor2\" >");
        form.append("<p>Valor a convertir:<input type=\"number\" name=\"valor\"/></p>");
        form.append("<p>");
        form.append("<input type=\"submit\" value=\"c2f\" name=\"metodo\" />");
        form.append("<input type=\"submit\" value=\"f2c\" name=\"metodo\" />");
        form.append("</p>");
        form.append("</form>");
        return form.toString();
    }
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {              
            String tipoIngreso="";
            String tipoResultado="";
            String metodo = req.getParameter("metodo");
            String valor = req.getParameter("valor");
            PrintWriter out = resp.getWriter();
            StringBuilder resultado = new StringBuilder();
            try{
                // parsea el valor
                Double temperatura = Double.parseDouble(valor);
                Double conversion = 0.0;
                
                if(metodo.equalsIgnoreCase("c2f")) {
                    tipoIngreso ="C°";
                    tipoResultado ="F°";
                    conversion = conversor.celciusToFarenheit(temperatura);
                }
                if(metodo.equalsIgnoreCase("f2c")) {
                    tipoIngreso ="F°";
                    tipoResultado ="C°";
                    conversion = conversor.farenheitToCelcius(temperatura);
                }
                resultado.append(valor+";"+tipoIngreso+";"+conversion+";"+tipoResultado);
                req.setAttribute("valor", temperatura);
                req.setAttribute("resultado", conversion);
                req.setAttribute("tipoIngreso", tipoIngreso);
                req.setAttribute("tipoResultado", tipoResultado);
                
            }catch(NumberFormatException e){
                resultado.append("<p> Error: "+e.getMessage()+"</p>");
            }
            out.write(resultado.toString());
    }
    
}

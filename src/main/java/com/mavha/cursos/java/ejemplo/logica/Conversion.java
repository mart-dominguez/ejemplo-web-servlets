/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.cursos.java.ejemplo.logica;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author mdominguez
 */
public class Conversion {
    
    private SimpleDateFormat sdf;
    private Date fecha;
    private Double valorIngreso;
    private String tipoValorIngreso;
    private Double valorSalida;
    private String tipoValorSalida;

    
    
    public Conversion(Double valorIngreso, String tipoValorIngreso, Double valorSalida, String tipoValorSalida) {
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.fecha = new Date();
        this.valorIngreso = valorIngreso;
        this.tipoValorIngreso = tipoValorIngreso;
        this.valorSalida = valorSalida;
        this.tipoValorSalida = tipoValorSalida;
    }

    public String getFecha() {
        return sdf.format(this.fecha);
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    

    public Double getValorIngreso() {
        return valorIngreso;
    }

    public void setValorIngreso(Double valorIngreso) {
        this.valorIngreso = valorIngreso;
    }

    public String getTipoValorIngreso() {
        return tipoValorIngreso;
    }

    public void setTipoValorIngreso(String tipoValorIngreso) {
        this.tipoValorIngreso = tipoValorIngreso;
    }

    public Double getValorSalida() {
        return valorSalida;
    }

    public void setValorSalida(Double valorSalida) {
        this.valorSalida = valorSalida;
    }

    public String getTipoValorSalida() {
        return tipoValorSalida;
    }

    public void setTipoValorSalida(String tipoValorSalida) {
        this.tipoValorSalida = tipoValorSalida;
    }
    
    
    
    
}

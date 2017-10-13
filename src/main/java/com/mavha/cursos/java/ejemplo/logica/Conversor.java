/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.cursos.java.ejemplo.logica;

/**
 *
 * @author mdominguez
 */
public class Conversor {
    public Double farenheitToCelcius(Double farenheit){
        // De F° a C° T(°C) = (T(°F) - 32) / (9/5)
        return (farenheit-32)/(9/5);
    }
    
    public Double celciusToFarenheit(Double celcius){
        // De C° a F° T(°F) = T(°C) × 9/5 + 32
        return (celcius *  9 / 5  )+ 32;
    }

}

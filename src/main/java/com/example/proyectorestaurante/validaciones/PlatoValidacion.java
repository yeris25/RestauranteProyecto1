package com.example.proyectorestaurante.validaciones;


import com.example.proyectorestaurante.entidad.Plato;
import org.springframework.stereotype.Component;

@Component
public class PlatoValidacion {

    public static boolean validarObligatorios(Plato plato) {
        return  plato.getPrecio() == null || plato.getPrecio() < 0 ||
                plato.getDescripcion() == null || plato.getDescripcion().isEmpty() ||
                plato.getSede() == null || plato.getSede().isEmpty();
    }


}
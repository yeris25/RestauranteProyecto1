package com.example.proyectorestaurante.validaciones;

import com.example.proyectorestaurante.entidad.Pedido;

public class PedidoValidacion {

    public  static Boolean validarPresenicaSede(Pedido pedido){
        return  pedido.getSede() == null || pedido.getSede().isEmpty() ||
                pedido.getDetalles() == null || pedido.getDetalles().isEmpty();
    }

}

package com.example.proyectorestaurante.dto;

import com.example.proyectorestaurante.Utiles.EstadoPedido;
import com.example.proyectorestaurante.entidad.Pedido;

import java.util.List;

public class PedidoRespuestaDTO extends PedidoDTO{


    private Long id;
    private String sede;
    private EstadoPedido estado;
    private List<DetallePedidoDTO> detalles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public List<DetallePedidoDTO> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePedidoDTO> detalles) {
        this.detalles = detalles;
    }
}

package com.example.proyectorestaurante.dto;

public class PlatoErrorDTO extends PlatoDTO {
    private String mensajeError;

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
}

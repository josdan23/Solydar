package com.solydarteam.solydar_server.pedido;

public class EspecificacionDePedido {
    private String descripcion;

    public EspecificacionDePedido(String descripcion) {
        this.descripcion = descripcion;
    }

    //<editor-fold desc="GETTERS AND SETTERS">
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    //</editor-fold>

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n\tDescripcion: ");
        builder.append(getDescripcion());
        return builder.toString();
    }
}

package com.solydarteam.solydar_server.donacion;

import com.solydarteam.solydar_server.pedido.EspecificacionDePedido;

public class DetalleDonacion {
    private EspecificacionDePedido donativoEntregado;
    private int cantidadDonada;

    public DetalleDonacion(EspecificacionDePedido donativoEntregado, int cantidadDonada) {
        this.cantidadDonada = cantidadDonada;
        this.donativoEntregado = donativoEntregado;
    }

    //<editor-fold desc="SOLO GETTERS">
    public int getCantidadDonada() {
        return cantidadDonada;
    }

    public EspecificacionDePedido getDonativoEntregado() {
        return donativoEntregado;
    }

    //</editor-fold>

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n\tLo que dona: ");
        builder.append(getDonativoEntregado());
        builder.append("\n\tCantidad donada: ");
        builder.append(getCantidadDonada());

        return builder.toString();
    }
}

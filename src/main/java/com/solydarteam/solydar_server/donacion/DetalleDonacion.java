package com.solydarteam.solydar_server.donacion;

import com.solydarteam.solydar_server.pedido.ItemSolicitado;

/*
    FUTURO: agregar un campo de observación, esto le permitiria al donante
    explicar algo relativo al objeto donado. Por ejemplo: modo de uso,
    estado del objeto, horarios de atención, etc.
 */


public class DetalleDonacion {
    private ItemSolicitado itemDonado;
    private int cantidadDonada;

    public DetalleDonacion(ItemSolicitado itemDonado, int cantidadDonada) {
        this.cantidadDonada = cantidadDonada;
        this.itemDonado = itemDonado;
    }

    //<editor-fold desc="SOLO GETTERS">
    public int getCantidadDonada() {
        return cantidadDonada;
    }

    public ItemSolicitado getItemDonado() {
        return itemDonado;
    }

    //</editor-fold>

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n\tLo que dona: ");
        builder.append(getItemDonado());
        builder.append("\n\tCantidad donada: ");
        builder.append(getCantidadDonada());

        return builder.toString();
    }
}

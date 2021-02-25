package com.solydarteam.solydar_server.donacion;

import com.solydarteam.solydar_server.evento.Evento;

import java.util.List;

public class Donante implements Donador {
    private String nombre = "Daniel";

    @Override
    public String toString() {
        return String.format("Donante: %s", nombre);
    }


    //LISTA DE DONACIÓN ES UN ARRAYLIST
    @Override
    public void donar(Evento evento, List<DetalleDonacion> listaDeDonativos) {

        try {
            if (evento.getPedidoSolicitado().esListaDeDonacionesConfirmada(listaDeDonativos)) {

                Donacion nuevaDonacion = new Donacion(this);
                nuevaDonacion.setListaDonativos(listaDeDonativos);
                evento.registrarDonacion(nuevaDonacion);

            }
            else
                System.out.println("Hay donaciones que no corresponden a lo que se pide");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

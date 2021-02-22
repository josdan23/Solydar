package com.solydarteam.solydar_server.services;

import com.solydarteam.solydar_server.donacion.Donacion;
import com.solydarteam.solydar_server.donacion.Donante;
import com.solydarteam.solydar_server.evento.Evento;
import com.solydarteam.solydar_server.pedido.EspecificacionDePedido;

public class DonacionServices {

    private Donacion donacion;

    public void iniciarDonacion(Donante donador){
        donacion = donador.crearDonacion();
        System.out.println(donacion);
    }

    public void agregarDonativo(EspecificacionDePedido donativo, int cantidad){
        donacion.agregarDonativo(donativo, cantidad);
    }

    public void confirmarDonacion(Evento evento){
        evento.donar(donacion);
    }

}

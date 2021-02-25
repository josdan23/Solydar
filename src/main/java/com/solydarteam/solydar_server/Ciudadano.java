package com.solydarteam.solydar_server;

import com.solydarteam.solydar_server.donacion.DetalleDonacion;
import com.solydarteam.solydar_server.donacion.Donacion;
import com.solydarteam.solydar_server.donacion.Donador;
import com.solydarteam.solydar_server.evento.Evento;

import java.util.List;

public class Ciudadano implements Donador {

    private String nombre;

    public Ciudadano(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return String.format("Ciudadano: %s", getNombre());
    }

    @Override
    public void donar(Evento evento, List<DetalleDonacion> listaDeDonativos) {

        try {
            if (evento.getPedidoSolicitado().esListaDeDonacionesValida(listaDeDonativos)){
                Donacion donacion = new Donacion(this);
                donacion.setListaDonativos(listaDeDonativos);
                evento.registrarDonacion(donacion);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

package com.solydarteam.solydar_server;

import com.solydarteam.solydar_server.donacion.DetalleDonacion;
import com.solydarteam.solydar_server.donacion.Donacion;
import com.solydarteam.solydar_server.donacion.Donador;
import com.solydarteam.solydar_server.evento.Evento;

import java.util.List;

public class Responsable implements Donador {
    private String nombre;

    public Responsable(String nombre){
        this.nombre = nombre;
    }

    //<editor-fold desc="GETTERS AND SETTERS">
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nobre) {
        this.nombre = nobre;
    }
    //</editor-fold>

    @Override
    public String toString() {
        return String.format("\tNombre del responsable: %s", getNombre());
    }

    public static void main(String[] args){
        Responsable responsable = new Responsable("DANIEL");
        System.out.println(responsable);
    }

    @Override
    public void donar(Evento evento, List<DetalleDonacion> listaDeDonativos) {
        try {
            if (evento.getPedidoSolicitado().esListaDeDonacionesValida(listaDeDonativos)){
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

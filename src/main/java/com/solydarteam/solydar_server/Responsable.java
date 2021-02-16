package com.solydarteam.solydar_server;

import com.solydarteam.solydar_server.evento.CategoriaEvento;
import com.solydarteam.solydar_server.evento.Evento;

import java.util.Date;

public class Responsable {
    private String nombre;

    public Responsable(String nombre){
        this.nombre = nombre;
    }

    //<editor-fold desc="GETTERS AND SETTERS">
    public String getNobre() {
        return nombre;
    }

    public void setNobre(String nobre) {
        this.nombre = nobre;
    }
    //</editor-fold>

    @Override
    public String toString() {
        return String.format("\n\tNombre: %s", getNobre());
    }

    public Evento crearNuevoEvento(
            String titulo,
            String descripcion,
            String aQuienAyuda,
            CategoriaEvento categoria,
            Date fechaDeRealizacion
    ){
        return new Evento(
                titulo,
                descripcion,
                aQuienAyuda,
                categoria,
                fechaDeRealizacion,
                this
        );
    }

    public static void main(String[] args){
        Responsable responsable = new Responsable("DANIEL");
        System.out.println(responsable);
    }
}

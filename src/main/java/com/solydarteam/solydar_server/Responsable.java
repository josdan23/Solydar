package com.solydarteam.solydar_server;

import com.solydarteam.solydar_server.evento.Evento;

import java.sql.SQLOutput;
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
        return String.format("Nombre: %s", getNobre());
    }




    public static void main(String[] args){
        Responsable responsable = new Responsable("DANIEL");
        System.out.println(responsable);
    }
}

package com.solydarteam.solydar_server;

public class Ciudadano {

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
}

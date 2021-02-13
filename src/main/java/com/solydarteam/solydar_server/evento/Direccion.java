package com.solydarteam.solydar_server.evento;

public class Direccion {
    private String calle;

    public Direccion(String calle) {
        this.calle = calle;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    @Override
    public String toString() {
        return String.format("Calle: %s", getCalle());
    }
}

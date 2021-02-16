package com.solydarteam.solydar_server;

public class Responsable {
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
}

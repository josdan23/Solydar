package com.solydarteam.solydar_server.donacion;

public class Donante {
    private String nombre = "Daniel es el donante";

    @Override
    public String toString() {
        return String.format("Donante: %s", nombre);
    }

    public Donacion crearDonacion(){
        Donacion nuevaDonacion = new Donacion();
        nuevaDonacion.setDonante(this);

        System.out.println(String.format("El donante: %s ha creado una donación", this.nombre));
        return nuevaDonacion;
    }

}

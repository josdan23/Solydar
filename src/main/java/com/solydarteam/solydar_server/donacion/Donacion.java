package com.solydarteam.solydar_server.donacion;

import com.solydarteam.solydar_server.pedido.EspecificacionDePedido;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Donacion {
    private int idDonacion;
    private Date fechaCreacion;
    private EstadoDonacion estado;
    private Date fechaEntrega;
    private Donante donante;
    private List<DetalleDonacion> listaDonativos;


    public Donacion(){
        fechaCreacion = Calendar.getInstance().getTime();
        estado = EstadoDonacion.DONACION_EN_ESPERA;
        listaDonativos = new ArrayList<>();
    }

    //<editor-fold desc="GETTERS AND SETTERS">
    public int getIdDonacion() {
        return idDonacion;
    }

    public void setIdDonacion(int idDonacion) {
        this.idDonacion = idDonacion;
    }

    public Date getfechaCreacion() {
        return fechaCreacion;
    }

    public void setfechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public EstadoDonacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoDonacion estado) {
        this.estado = estado;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Donante getDonante() {
        return donante;
    }

    public void setDonante(Donante donante) {
        this.donante = donante;
    }

    public List<DetalleDonacion> getListaDonativos() {
        return listaDonativos;
    }

    public void setListaDonativos(List<DetalleDonacion> listaDonativos) {
        this.listaDonativos = listaDonativos;
    }
    //</editor-fold>

    public void agregarDonativo(EspecificacionDePedido donativo, int cantidadDonada) {
        listaDonativos.add(new DetalleDonacion(donativo, cantidadDonada));
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n------->DETALLE DE DONACIÓN<-------");
        builder.append("\n\tId Donación: ");
        builder.append(getIdDonacion());
        builder.append("\n\tFecha de creación: ");
        builder.append(getfechaCreacion());
        builder.append("\n\tEstado de la donación: ");
        builder.append(getEstado());
        builder.append("\n\tFecha de entrega: ");
        builder.append(getFechaEntrega());
        builder.append("\n\tDonante: ");
        builder.append(getDonante());

        builder.append("\n\n\tListado de donativos:");
        builder.append("\n\t---------------------");

        for(int i = 0; i < listaDonativos.size(); i++){
            builder.append("\n\n\t" + i + ")");
            builder.append(listaDonativos.get(i));
        }

        builder.append("\n\n------->FIN DETALLE DE DONACIÓN<-------");
        return builder.toString();
    }


    public static void main(String[] args){
        EspecificacionDePedido producto = new EspecificacionDePedido("Alimentos");
        Donacion donacion = new Donacion();
        donacion.setIdDonacion(2);
        donacion.setfechaCreacion(Calendar.getInstance().getTime());
        donacion.setEstado(EstadoDonacion.DONACION_CONFIRMADA);
        donacion.setFechaEntrega(Calendar.getInstance().getTime());


        for (int i = 0; i < 10; ++i){
            donacion.agregarDonativo(producto, i);
        }

        System.out.println(donacion);
    }
}

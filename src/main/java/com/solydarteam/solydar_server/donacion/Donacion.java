package com.solydarteam.solydar_server.donacion;

import com.solydarteam.solydar_server.pedido.ItemSolicitado;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Donacion {
    private int idDonacion;
    //todo: agregar código de donación
    private Date fechaCreacion;
    private EstadoDonacion estado;
    private Date fechaEntrega;
    private Donante donante;
    private List<DetalleDonacion> listaDonativos;

    protected Donacion(){
        fechaCreacion = Calendar.getInstance().getTime();
        estado = EstadoDonacion.DONACION_EN_ESPERA;
        listaDonativos = new ArrayList<>();
    }

    protected Donacion(Donante donante) throws Exception {
        this();
        setDonante(donante);
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

    public void setDonante(Donante donante) throws Exception {
        if (donante != null)
            this.donante = donante;
        else
            throw new Exception("El Donante no es valido");
    }

    public List<DetalleDonacion> getListaDonativos() {
        return listaDonativos;
    }

    public void setListaDonativos(List<DetalleDonacion> listaDonativos) throws Exception {
        if (listaDonativos != null)
            this.listaDonativos = listaDonativos;
        else
            throw new Exception("La lista de donativos es null");
    }
    //</editor-fold>

    public void agregarDonativo(ItemSolicitado donativo, int cantidadDonada) throws Exception {
        if (donativo == null)
            throw new Exception("El Donativo no es valido");
        else if(cantidadDonada < 1 )
            throw new Exception("Cantidad donada insuficiente: cantida menor a 1");
        else
            listaDonativos.add(new DetalleDonacion(donativo, cantidadDonada));
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n\t------->DETALLE DE DONACIÓN<-------");
        builder.append("\n\t| Id Donación: ");
        builder.append(getIdDonacion());
        builder.append("\n\t| Fecha de creación: ");
        builder.append(getfechaCreacion());
        builder.append("\n\t| Estado de la donación: ");
        builder.append(getEstado());
        builder.append("\n\t| Fecha de entrega: ");
        builder.append(getFechaEntrega());
        builder.append("\n\t| Donante: ");
        builder.append(getDonante());

        builder.append("\n\n\t| Listado de donativos:");
        builder.append("\n\t| ---------------------");

        for(int i = 0; i < listaDonativos.size(); i++){
            builder.append("\n\n\t| " + i + ")");
            builder.append(listaDonativos.get(i));
        }

        builder.append("\n\n\t|------->FIN DETALLE DE DONACIÓN<-------");
        return builder.toString();
    }

    /*public static void main(String[] args){
       EspecificacionDePedido producto = new EspecificacionDePedido("Alimentos");
        Donacion donacion = new Donacion();
        donacion.setIdDonacion(2);
        donacion.setFechaEntrega(Calendar.getInstance().getTime());


        for (int i = 0; i < 10; ++i){
            try {
                donacion.agregarDonativo(null, i);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(donacion);

        try {
            Donacion donacion = new Donacion(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }*/
}

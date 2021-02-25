package com.solydarteam.solydar_server.pedido;

import com.solydarteam.solydar_server.donacion.DetalleDonacion;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Pedido {
    private int idPedido;
    private long codigoPedido;
    private EstadoPedido estadoPedido;
    private Date fechaDelPedido;

    private List<DetallePedido> listaPedidos;

    public Pedido(){
        listaPedidos = new ArrayList<>();
        fechaDelPedido = Calendar.getInstance().getTime();
        setEstadoPedido(EstadoPedido.PEDIDO_NO_CONCRETADO);
    }

    //<editor-fold desc="GETTERS AND SETTERS">
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public long getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(long codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public Date getfechaDelPedido() {
        return fechaDelPedido;
    }

    public List<DetallePedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<DetallePedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

//</editor-fold>

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("\n\n\t------->DETALLE DE PEDIDO<--------");

        builder.append("\n\tId Pedido: ");
        builder.append(getIdPedido());

        builder.append("\n\tCódigo: ");
        builder.append(getCodigoPedido());

        builder.append("\n\tEstado: ");
        builder.append(getEstadoPedido());

        builder.append("\n\tFecha del pedido: ");
        builder.append(getfechaDelPedido());

        builder.append("\n\n\tListado de pedidos:");
        builder.append("\n\t---------------------");

        for(int i = 0; i < listaPedidos.size(); i++){
            builder.append("\n\n\t" + i + ")");
            builder.append(listaPedidos.get(i));
        }
        builder.append("\n\n\t------->FIN DETALLE DE PEDIDO<-------");
        return builder.toString();
    }


    public void agregarItemAlPedido(String descripcion, int cantidad, TipoPedido tipo, String urlImagen){

        //todo: falta agregar el la imagen al detalle
        DetallePedido detallePedido = new DetallePedido(descripcion, cantidad, tipo, urlImagen);
        listaPedidos.add(detallePedido);
    }

    public boolean estaItemEnListaDePedidos(ItemSolicitado item){
        for(DetallePedido unaLineaDelDetalle : listaPedidos){
            if (item == unaLineaDelDetalle.getItemSolicitado())
                return true;
        }
        return false;
    }

    public boolean esListaDeDonacionesValida(List<DetalleDonacion> listaDeDonaciones){
        for(DetalleDonacion unItemDonado : listaDeDonaciones){
            if(!estaItemEnListaDePedidos(unItemDonado.getItemDonado()))
                return false;
        }
        return true;
    }


    public static void main(String[] args){
        Pedido pedido = new Pedido();
        pedido.setIdPedido(2);
        pedido.setCodigoPedido(290309201029L);
        pedido.setEstadoPedido(EstadoPedido.PEDIDO_NO_CONCRETADO);

        ItemSolicitado itemSolicitado = new ItemSolicitado("Ropa para niños");

        for(int i = 0; i < 10; i++){
            pedido.agregarItemAlPedido("Ropa para niños", i + 10, TipoPedido.TIPO_PRODUCTO, "http://urls");
        }

        System.out.println(pedido);

    }
}



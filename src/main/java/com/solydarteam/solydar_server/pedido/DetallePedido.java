package com.solydarteam.solydar_server.pedido;

public class DetallePedido {
    private EspecificacionDePedido pedidoSolicitado;
    private int cantidadSolicitada;
    private TipoPedido tipoPedido;
    private String urlImagen;

    private int cantidadEntregada;


    public DetallePedido() {
        urlImagen = "";
    }

    public DetallePedido(String descripcion, int cantidadSolicitada, TipoPedido tipo) {
        this();
        setpedidoSolicitado(new EspecificacionDePedido(descripcion));
        setCantidadSolicitada(cantidadSolicitada);
        setTipoPedido(tipo);
    }

    public DetallePedido(String descripcion, int cantidadSolicitada, TipoPedido tipo, String urlImagen) {
        this(descripcion, cantidadSolicitada, tipo);
        setUrlImagen(urlImagen);
    }

    public void agregarCantidadEntregada(int cantidadEntregada){
        this.cantidadEntregada += cantidadEntregada;
    }

    public int getCantidadEntregada(){
        return cantidadEntregada;
    }

    public int getCantidadFaltante(){
        int aux =  cantidadSolicitada - cantidadEntregada;

        if (aux <= 0)
            return 0;
        return aux;
    }

    //<editor-fold desc="GETTERS AND SETTERS">
    public EspecificacionDePedido getpedidoSolicitado() {
        return pedidoSolicitado;
    }

    public void setpedidoSolicitado(EspecificacionDePedido pedidoSolicitado) {
        this.pedidoSolicitado = pedidoSolicitado;
    }

    public int getCantidadSolicitada() {
        return cantidadSolicitada;
    }

    public void setCantidadSolicitada(int cantidadSolicitada) {
        this.cantidadSolicitada = cantidadSolicitada;
    }

    public TipoPedido getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(TipoPedido tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    //</editor-fold>

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n\tNecesita: ");
        builder.append(getpedidoSolicitado());

        builder.append("\n\tTipo de pedido: ");
        builder.append(getTipoPedido());

        builder.append("\n\tUrl imagen: ");
        builder.append(getUrlImagen());


        builder.append("\n\tCantidad solicitada: ");
        builder.append(getCantidadSolicitada());

        builder.append("\n\tCantidad entregada: ");
        builder.append(getCantidadEntregada());

        builder.append("\n\tCantidad faltante: ");
        builder.append(getCantidadFaltante());


        return builder.toString();
    }

}

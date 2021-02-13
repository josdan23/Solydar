package com.solydarteam.solydar_server.pedido;

public class DetallePedido {
    private EspecificacionDePedido pedidoSolicitado;
    private int cantidadSolicitada;
    private TipoPedido tipoPedido;
    private String urlImagen;

    public DetallePedido() {
        urlImagen = "";
    }
    public DetallePedido(EspecificacionDePedido pedidoSolicitado, int cantidadSolicitada, TipoPedido tipo) {
        this();
        setpedidoSolicitado(pedidoSolicitado);
        setCantidadSolicitada(cantidadSolicitada);
        setTipoPedido(tipo);
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

        builder.append("\n\tCantidad solicitada: ");
        builder.append(getCantidadSolicitada());

        builder.append("\n\tTipo de pedido: ");
        builder.append(getTipoPedido());

        builder.append("\n\tUrl imagen: ");
        builder.append(getUrlImagen());

        return builder.toString();
    }



}

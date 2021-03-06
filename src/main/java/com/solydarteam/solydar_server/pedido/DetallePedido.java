package com.solydarteam.solydar_server.pedido;

public class DetallePedido {
    private ItemSolicitado itemSolicitado;
    private TipoPedido tipoPedido;
    private String urlImagen;

    private int cantidadSolicitada;
    private int cantidadEntregada;


    public DetallePedido() {
        urlImagen = "";
    }

    public DetallePedido(String descripcion, int cantidadSolicitada, TipoPedido tipo) {
        this();
        setItemSolicitado(new ItemSolicitado(descripcion));
        setCantidadSolicitada(cantidadSolicitada);
        setTipoPedido(tipo);
    }

    public DetallePedido(String descripcion, int cantidadSolicitada, TipoPedido tipo, String urlImagen) {
        this(descripcion, cantidadSolicitada, tipo);
        setUrlImagen(urlImagen);
    }

    //<editor-fold desc="GETTERS AND SETTERS">
    public ItemSolicitado getItemSolicitado() {
        return itemSolicitado;
    }

    public void setItemSolicitado(ItemSolicitado itemSolicitado) {
        this.itemSolicitado = itemSolicitado;
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

    public void setCantidadEntregada(int cantidadEntregada) {
        this.cantidadEntregada = cantidadEntregada;
    }

    public int getCantidadEntregada(){
        return cantidadEntregada;
    }

//</editor-fold>

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n\tNecesita: ");
        builder.append(getItemSolicitado());

        builder.append("\n\tTipo de pedido: ");
        builder.append(getTipoPedido());

        builder.append("\n\tUrl imagen: ");
        builder.append(getUrlImagen());


        builder.append("\n\tCantidad solicitada: ");
        builder.append(getCantidadSolicitada());

        builder.append("\n\tCantidad entregada: ");
        builder.append(getCantidadEntregada());

        builder.append("\n\tCantidad faltante: ");
        builder.append(calcularCantidadFaltante());


        return builder.toString();
    }


    public void sumarCantidadEntregada(int cantidadEntregada){
        this.cantidadEntregada += cantidadEntregada;
    }

    public int calcularCantidadFaltante(){
        int cantFaltante =  cantidadSolicitada - cantidadEntregada;

        if (cantFaltante <= 0)
            return 0;
        return cantFaltante;
    }

}

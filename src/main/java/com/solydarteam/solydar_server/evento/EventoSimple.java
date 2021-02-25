package com.solydarteam.solydar_server.evento;

import com.solydarteam.solydar_server.Responsable;
import com.solydarteam.solydar_server.donacion.DetalleDonacion;
import com.solydarteam.solydar_server.donacion.Donacion;
import com.solydarteam.solydar_server.donacion.EstadoDonacion;
import com.solydarteam.solydar_server.pedido.DetallePedido;
import com.solydarteam.solydar_server.pedido.EstadoPedido;
import com.solydarteam.solydar_server.pedido.Pedido;
import com.solydarteam.solydar_server.pedido.TipoPedido;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class EventoSimple {
    private int idEvento;
    private String titulo;
    private String descripcion;
    private Responsable responsable;
    private String urlImagen;
    private String aquienAyuda;
    private CategoriaEvento categoriaEvento;
    private Date fechaDeRealizacion;
    private EstadoEvento estadoEvento;
    private Direccion direccion;

    private List<String> telefonos;
    private Date fechaCreacion;

    private Pedido pedidoSolicitado;
    private List<Donacion> donacionesRecibidas;

    public EventoSimple(){
        fechaCreacion = Calendar.getInstance().getTime();
        this.telefonos = new ArrayList<>();
        this.donacionesRecibidas = new ArrayList<>();
        this.pedidoSolicitado = new Pedido();
        this.estadoEvento = EstadoEvento.ESTADO_EVENTO_ACTIVO;
    }

    //<editor-fold desc="GETTERS AND SETTERS">
    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getAquienAyuda() {
        return aquienAyuda;
    }

    public void setAquienAyuda(String aquienAyuda) {
        this.aquienAyuda = aquienAyuda;
    }

    public CategoriaEvento getCategoriaEvento() {
        return categoriaEvento;
    }

    public void setCategoriaEvento(CategoriaEvento categoriaEvento) {
        this.categoriaEvento = categoriaEvento;
    }

    public Date getFechaDeRealizacion() {
        return fechaDeRealizacion;
    }

    public void setFechaDeRealizacion(Date fechaDeRealizacion) {
        this.fechaDeRealizacion = fechaDeRealizacion;
    }

    public EstadoEvento getEstadoEvento() {
        return estadoEvento;
    }

    public void setEstadoEvento(EstadoEvento estadoEvento) {
        this.estadoEvento = estadoEvento;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Pedido getPedidoSolicitado() {
        return pedidoSolicitado;
    }

    public void setPedidoSolicitado(Pedido pedidoSolicitado) {
        this.pedidoSolicitado = pedidoSolicitado;
    }

    public List<Donacion> getDonacionesRecibidas() {
        return donacionesRecibidas;
    }

    public void setDonacionesRecibidas(List<Donacion> donacionesRecibidas) {
        this.donacionesRecibidas = donacionesRecibidas;
    }
    //</editor-fold>

    public void agregarTelefono(String telefono) {
        telefonos.add(telefono);
    }

    public void registrarDonacion(Donacion donacion){
        donacion.setEstado(EstadoDonacion.DONACION_EN_ESPERA);
        getDonacionesRecibidas().add(donacion);
        System.out.println("DONACIÓN REGISTRADA EN EL EVENTO");
        //todo: notificar a los responsables para aprobar donacion

        //calcular lo que falta
        calcularDonacionesFaltantes(donacion);

        //verificar si el pedido del evento esta completo
        verificarPedidoConcreto();

    }

    private void verificarPedidoConcreto(){
        if (esPedidoCompleto())
        {
            pedidoSolicitado.setEstadoPedido(EstadoPedido.PEDIDO_CONCRETADO);
            setEstadoEvento(EstadoEvento.ESTADO_EVENTO_FINALIZADO);
        }
    }

    private void calcularDonacionesFaltantes(Donacion donacion){
        for (DetallePedido detallePedido : getPedidoSolicitado().getListaPedidos()){
            for (DetalleDonacion detalleDonacion : donacion.getListaDonativos()){
                if (detallePedido.getItemSolicitado() == detalleDonacion.getItemDonado()){
                    detallePedido.sumarCantidadEntregada(detalleDonacion.getCantidadDonada());
                }
            }
        }
    }

    public boolean esPedidoCompleto(){
        for (DetallePedido detallePedido : pedidoSolicitado.getListaPedidos()) {
            if(detallePedido.calcularCantidadFaltante() != 0){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("\n++++++++++>INFO DEL EVENTO<+++++++++");

        builder.append("\n\tId evento: ");
        builder.append(getIdEvento());

        builder.append("\n\tTitulo: ");
        builder.append(getTitulo());

        builder.append("\n\tDescripción: ");
        builder.append(getDescripcion());

        builder.append("\n\tResponsable: ");
        builder.append(getResponsable());

        builder.append("\n\tA quien ayuda: ");
        builder.append(getAquienAyuda());

        builder.append("\n\tCategoria: ");
        builder.append(getCategoriaEvento());

        builder.append("\n\tFecha De realización: ");
        builder.append(getFechaDeRealizacion());

        builder.append("\n\tEstado: ");
        builder.append(getEstadoEvento());

        builder.append("\n\tDirección: ");
        builder.append(getDireccion());

        builder.append("\n\tFecha de creación: ");
        builder.append(getFechaCreacion());

        builder.append("\n\t*PEDIDO SOLICITADO: ");
        builder.append(getPedidoSolicitado());

        builder.append("\n\n\tListado de donaciones realizadas:");


        for(int i = 0; i < donacionesRecibidas.size(); i++){
            //builder.append("\n\n\t" + i + ")");
            builder.append(donacionesRecibidas.get(i));
        }

        builder.append("\n+++++++++++>FIN DEL EVENTO<++++++++++++");
        return builder.toString();
    }

    public static void main(String args[]){
        EventoSimple evento = new EventoSimple();
        evento.setIdEvento(2);
        evento.setTitulo("sol para los niños");
        evento.setDescripcion("Evento para conseguir alimentos, ropa y jueguets para los niños");
        evento.setUrlImagen("jasdfljasdklf.com/jalksdjf");
        evento.setAquienAyuda("Niños y adolescentes");
        evento.setCategoriaEvento(CategoriaEvento.CATEGORIA_EVENTO_1);
        evento.setFechaDeRealizacion(Calendar.getInstance().getTime());
        evento.setDireccion(new Direccion("san martin 233"));
        evento.agregarTelefono("2342342");
        evento.agregarTelefono("234982349");


        Pedido pedido = new Pedido();
        pedido.setEstadoPedido(EstadoPedido.PEDIDO_NO_CONCRETADO);
        pedido.setIdPedido(3);
        pedido.setCodigoPedido(234234L);

        //EspecificacionDePedido especificacionDePedido = new EspecificacionDePedido("alimentos");

        for(int i = 0; i < 10; i++){
            pedido.agregarItemAlPedido(
                    "alimentos",
                    i+3,
                    TipoPedido.TIPO_PRODUCTO,
                    "imagenurl");
        }

        evento.setPedidoSolicitado(pedido);

        System.out.println(evento);
    }

}

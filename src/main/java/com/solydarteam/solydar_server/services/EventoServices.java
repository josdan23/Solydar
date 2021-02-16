package com.solydarteam.solydar_server.services;

import com.solydarteam.solydar_server.Organizacion;
import com.solydarteam.solydar_server.Responsable;
import com.solydarteam.solydar_server.evento.CategoriaEvento;
import com.solydarteam.solydar_server.evento.Evento;
import com.solydarteam.solydar_server.pedido.TipoPedido;

import java.util.Date;

public class EventoServices {

    private Evento nuevoEvento;
    private final Organizacion organizacion;
    private final Responsable responsable;

    public EventoServices(Organizacion organizacion, Responsable responsable){
        this.organizacion = organizacion;
        this.responsable = responsable;
    }

    public void crearEvento(
            String titulo,
            String descripcion,
            String aQuienAyuda,
            CategoriaEvento categoriaEvento,
            Date fechaDeRealizacion
    ){
        nuevoEvento = responsable.crearNuevoEvento(
                titulo,
                descripcion,
                aQuienAyuda,
                categoriaEvento,
                fechaDeRealizacion);
    }

    public void agregarItem(String descripcion, int cantidad, TipoPedido tipoPedido, String urlImagen){
        nuevoEvento.getPedidoSolicitado().agregarItem(
                descripcion,
                cantidad,
                tipoPedido,
                urlImagen
        );
    }

    public void publicarEvento(){
        try {
            organizacion.registrarEvento(nuevoEvento);
            System.out.println("SE REGISTRO UN EVENTO EN LA ORGANIZACION");
            System.out.println(nuevoEvento.toString());;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

package com.solydarteam.solydar_server.probar;

import com.solydarteam.solydar_server.CategoriaOrganizacion;
import com.solydarteam.solydar_server.Organizacion;
import com.solydarteam.solydar_server.Responsable;
import com.solydarteam.solydar_server.evento.CategoriaEvento;
import com.solydarteam.solydar_server.pedido.TipoPedido;
import com.solydarteam.solydar_server.services.EventoServices;

import java.util.Calendar;

public class ProbarEventos {

    public static void main(String args[]) {

        Organizacion organizacion = new Organizacion();
        organizacion.setNombre("Solidarios en red");
        organizacion.setCategoria(CategoriaOrganizacion.CATEGORIA_ORGANIZACION_1);

        Responsable responsable = new Responsable("Daniel Yapura");
        organizacion.agregarAdministrador(responsable);

        EventoServices eventoServices = new EventoServices(organizacion, responsable);
        try {
            eventoServices.crearEvento(
                    "Un sol para los niños",
                    "Evento a destinado a recolectar alimentos, ropa, juguetes para los niños",
                    "Niños y adolescentes",
                    CategoriaEvento.CATEGORIA_EVENTO_1,
                    Calendar.getInstance().getTime(),
                    responsable);

            eventoServices.agregarItemAlPedido("alintos", 2, TipoPedido.TIPO_PRODUCTO, null);
            eventoServices.agregarItemAlPedido("ropa", 100, TipoPedido.TIPO_PRODUCTO, "sin especificar");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        eventoServices.publicarEvento();

    }
}

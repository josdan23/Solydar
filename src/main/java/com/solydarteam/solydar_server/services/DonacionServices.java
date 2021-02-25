package com.solydarteam.solydar_server.services;

import com.solydarteam.solydar_server.donacion.DetalleDonacion;
import com.solydarteam.solydar_server.donacion.Donacion;
import com.solydarteam.solydar_server.donacion.Donador;
import com.solydarteam.solydar_server.donacion.Donante;
import com.solydarteam.solydar_server.evento.Evento;
import com.solydarteam.solydar_server.pedido.ItemSolicitado;

import java.util.HashMap;
import java.util.List;

public class DonacionServices {

    /*private Donacion donacion;

    public void iniciarDonacion(Donante donador){
        donacion = donador.crearDonacion();
        System.out.println(donacion);
    }

    public void agregarDonativo(ItemSolicitado donativo, int cantidad){
        //donacion.agregarDonativo(donativo, cantidad);
    }

    public void confirmarDonacion(Evento evento){
        evento.registrarDonacion(donacion);
    }*/

/*
    //Todo: el donante lo debería recuperar de la sesion actual
    public void donarAEvento(Donador donante,
                             HashMap<ItemSolicitado, Integer> listaDeDonativos,
                             Evento evento){

        donante.donar(evento, listaDeDonativos);
    }
*/

    public void donarAEvento(Donador donante,
                             List<DetalleDonacion> listaDeDonativos,
                             Evento evento) {
        donante.donar(evento, listaDeDonativos);
    }

    public void donarAEvento(HashMap<Integer, Integer> listaDeDonativos, Integer idEvento) {
        //Todo: implementar (cuando tenga base de datos)
        /*
        tener en cuenta que al evento lo debo recuperar, junto con sus pedidos
        debo verificar que los items de la donación corresponden con lo que se pide,
        y el donante es el que crea la donación, lo debo recuperar de la sesion actual.
         */

        //Donante donante = usuarioLogeado();
        //Evento eventoElegido = EventoRepositorio.recuperarPorId(idEvento);
        //donante.donar(eventoElegido, listaDeDonativos);
    }

}

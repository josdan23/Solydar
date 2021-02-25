package com.solydarteam.solydar_server.services;

import com.solydarteam.solydar_server.donacion.DetalleDonacion;
import com.solydarteam.solydar_server.donacion.Donador;
import com.solydarteam.solydar_server.evento.Evento;

import java.util.List;

public class DonacionServices {

    //Todo: El donanate lo debería recuperar de la sesion actual, es el usuario logeado
    //Todo: Debería buscar el evento por id, (implementar cuando meta DB)
    
    public void donarAEvento(Donador donante,
                             List<DetalleDonacion> listaDeDonativos,
                             Evento evento) {

        donante.donar(evento, listaDeDonativos);

    }

}

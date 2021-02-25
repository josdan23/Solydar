package com.solydarteam.solydar_server.donacion;

import com.solydarteam.solydar_server.evento.Evento;

import java.util.List;

public interface Donador {

    void donar(Evento evento, List<DetalleDonacion> listaDeDonativos);

}

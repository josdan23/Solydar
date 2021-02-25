package com.solydarteam.solydar_server.donacion;

import com.solydarteam.solydar_server.evento.EventoSimple;

import java.util.List;

public interface Donador {

    void donar(EventoSimple evento, List<DetalleDonacion> listaDeDonativos);

}

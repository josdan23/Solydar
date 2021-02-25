package com.solydarteam.solydar_server;

import ch.qos.logback.core.joran.spi.ElementSelector;
import com.solydarteam.solydar_server.donacion.GeneradorCodigos;

public class GeneradorCodigosAleatorios implements GeneradorCodigos {

    public static GeneradorCodigos INSTANCE;
    
    public static GeneradorCodigos getInstance() {
        if (INSTANCE != null)
            return INSTANCE;
        return new GeneradorCodigosAleatorios();
    }

    @Override
    public long generarCodigo() {
        return (long) (Math.random()*1000000 + 1) ;
    }
    
}

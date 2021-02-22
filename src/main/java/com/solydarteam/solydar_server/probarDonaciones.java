package com.solydarteam.solydar_server;

import com.solydarteam.solydar_server.donacion.Donante;
import com.solydarteam.solydar_server.evento.Evento;
import com.solydarteam.solydar_server.pedido.DetallePedido;
import com.solydarteam.solydar_server.pedido.Pedido;
import com.solydarteam.solydar_server.pedido.TipoPedido;
import com.solydarteam.solydar_server.services.DonacionServices;

public class probarDonaciones {

    public static void main(String args[]) {

        DonacionServices services = new DonacionServices();

        Donante donante = new Donante();
        services.iniciarDonacion(donante);

        Evento evento = new Evento();
        Pedido pedido = new Pedido();
        pedido.agregarItem("alimentos", 2, TipoPedido.TIPO_PRODUCTO, null);
        pedido.agregarItem("ropa", 2, TipoPedido.TIPO_PRODUCTO, null);
        pedido.agregarItem("muebles", 2, TipoPedido.TIPO_PRODUCTO, null);
        evento.setPedidoSolicitado(pedido);
        System.out.println(evento);


        for (DetallePedido detallePedido : evento.getPedidoSolicitado().getListaPedidos() ){
            services.agregarDonativo(detallePedido.getpedidoSolicitado(), 1);
        }

        services.confirmarDonacion(evento);
        System.out.println(evento);


        Donante donante2 = new Donante();
        services.iniciarDonacion(donante2);


        for (DetallePedido detallePedido : evento.getPedidoSolicitado().getListaPedidos() ){
            services.agregarDonativo(detallePedido.getpedidoSolicitado(), 3);
        }

        services.confirmarDonacion(evento);
        System.out.println(evento);
    }

}

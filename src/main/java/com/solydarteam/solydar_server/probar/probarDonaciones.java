package com.solydarteam.solydar_server.probar;

import com.solydarteam.solydar_server.donacion.Donante;
import com.solydarteam.solydar_server.evento.Evento;
import com.solydarteam.solydar_server.pedido.DetallePedido;
import com.solydarteam.solydar_server.pedido.ItemSolicitado;
import com.solydarteam.solydar_server.pedido.Pedido;
import com.solydarteam.solydar_server.pedido.TipoPedido;
import com.solydarteam.solydar_server.services.DonacionServices;

import java.util.HashMap;

public class probarDonaciones {

    public static void main(String args[]) {

        DonacionServices services = new DonacionServices();

        Donante donante = new Donante();

        Evento evento = new Evento();
        Pedido pedido = new Pedido();
        pedido.agregarItem("alimentos", 2, TipoPedido.TIPO_PRODUCTO, null);
        pedido.agregarItem("ropa", 2, TipoPedido.TIPO_PRODUCTO, null);
        pedido.agregarItem("muebles", 2, TipoPedido.TIPO_PRODUCTO, null);
        evento.setPedidoSolicitado(pedido);
        System.out.println(evento);


        HashMap<ItemSolicitado, Integer> listaDeDonativos = new HashMap<>();

        for(DetallePedido detallePedido : pedido.getListaPedidos()){
            listaDeDonativos.put(detallePedido.getItemSolicitado(), 2);
        }

        services.donarAEvento(donante, listaDeDonativos, evento);
        System.out.println(evento);

        HashMap<ItemSolicitado, Integer> listaDeDonativos2 = new HashMap<>();
        listaDeDonativos2.put(pedido.getListaPedidos().get(0).getItemSolicitado(), 2);
        services.donarAEvento(donante,listaDeDonativos2, evento);
        System.out.println(evento);

     /*

        services.iniciarDonacion(donante);

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
        System.out.println(evento);*/
    }

}

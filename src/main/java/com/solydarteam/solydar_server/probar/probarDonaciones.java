package com.solydarteam.solydar_server.probar;

import com.solydarteam.solydar_server.Ciudadano;
import com.solydarteam.solydar_server.donacion.DetalleDonacion;
import com.solydarteam.solydar_server.donacion.Donador;
import com.solydarteam.solydar_server.donacion.Donante;
import com.solydarteam.solydar_server.evento.Evento;
import com.solydarteam.solydar_server.pedido.DetallePedido;
import com.solydarteam.solydar_server.pedido.ItemSolicitado;
import com.solydarteam.solydar_server.pedido.Pedido;
import com.solydarteam.solydar_server.pedido.TipoPedido;
import com.solydarteam.solydar_server.services.DonacionServices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class probarDonaciones {

    public static void main(String args[]) {

        DonacionServices services = new DonacionServices();

        //Donador donante = new Donante();

        Ciudadano donante = new Ciudadano("Daniel");


        Evento evento = new Evento();
        Pedido pedido = new Pedido();
        pedido.agregarItemAlPedido("alimentos", 2, TipoPedido.TIPO_PRODUCTO, null);
        pedido.agregarItemAlPedido("ropa", 2, TipoPedido.TIPO_PRODUCTO, null);
        pedido.agregarItemAlPedido("muebles", 2, TipoPedido.TIPO_PRODUCTO, null);
        evento.setPedidoSolicitado(pedido);
        System.out.println(evento);


        List<DetalleDonacion> listaDeDonativos = new ArrayList<>();
        for(DetallePedido detallePedido : pedido.getListaPedidos()){
            listaDeDonativos.add(new DetalleDonacion(detallePedido.getItemSolicitado(), 2));
        }


        services.donarAEvento(donante, listaDeDonativos, evento);
        System.out.println(evento);

        HashMap<ItemSolicitado, Integer> listaDeDonativos2 = new HashMap<>();
        listaDeDonativos2.put(pedido.getListaPedidos().get(0).getItemSolicitado(), 2);
        services.donarAEvento(donante,listaDeDonativos, evento);
        System.out.println(evento);

    }

}

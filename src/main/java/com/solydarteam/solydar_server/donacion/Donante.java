package com.solydarteam.solydar_server.donacion;

import com.solydarteam.solydar_server.evento.Evento;
import com.solydarteam.solydar_server.pedido.ItemSolicitado;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Donante {
    private String nombre = "Daniel es el donante";

    @Override
    public String toString() {
        return String.format("Donante: %s", nombre);
    }

/*    public Donacion crearDonacion(){
        Donacion nuevaDonacion = null;
        try {
            nuevaDonacion = new Donacion(this);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //nuevaDonacion.setDonante(this);

        System.out.println(String.format("El donante: %s ha creado una donación", this.nombre));
        return nuevaDonacion;
    }*/

    public void donar(Evento evento, HashMap<ItemSolicitado, Integer> listaDeDonativos){

        /*
            Crea una donación, agrega la lista de donativos confirmada y luego
            registra las donaciones en el evento.
         */
        try {
            Donacion donacion = new Donacion(this);

            List<DetalleDonacion> listaDeDonativosConfirmada =
                    getListaDeDonativosConfirmada(evento, listaDeDonativos);

            donacion.setListaDonativos(listaDeDonativosConfirmada);

            evento.registrarDonacion(donacion);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private List<DetalleDonacion> getListaDeDonativosConfirmada(Evento evento, HashMap<ItemSolicitado, Integer> listaDeDonativos) {
        List<DetalleDonacion> detalleDonacionsList = new ArrayList<>();

        //Recorrer cada item de la lista de donativos
        for(Map.Entry<ItemSolicitado, Integer> unItemDeLaListaDonada : listaDeDonativos.entrySet()) {

            if (evento.getPedidoSolicitado().estaEnLaLista(unItemDeLaListaDonada.getKey())){
                detalleDonacionsList.add(new DetalleDonacion(unItemDeLaListaDonada.getKey(), unItemDeLaListaDonada.getValue()));
            }
        }
        return detalleDonacionsList;
    }

}

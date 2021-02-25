package com.solydarteam.solydar_server.donacion;

import com.solydarteam.solydar_server.evento.Evento;

import java.util.List;

public class Donante implements Donador {
    private String nombre = "Daniel es el donante";

    @Override
    public String toString() {
        return String.format("Donante: %s", nombre);
    }

    //LISTA DE DONACIÓN ES UN HASHMAP
   /* public void donar(Evento evento, HashMap<ItemSolicitado, Integer> listaDeDonativos){

        *//*
            Crea una donación, agrega la lista de donativos confirmada y luego
            registra las donaciones en el evento.
         *//*
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
*/
    //LISTA DE DONACIÓN ES UN ARRAYLIST
    @Override
    public void donar(Evento evento, List<DetalleDonacion> listaDeDonativos) {

        if (evento.getPedidoSolicitado().esListaDeDonacionesConfirmada(listaDeDonativos)){
            try {
                Donacion nuevaDonacion = new Donacion(this);
                nuevaDonacion.setListaDonativos(listaDeDonativos);
                evento.registrarDonacion(nuevaDonacion);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        else
            System.out.println("Hay donaciones que no corresponden a lo que se pide");
    }

   /* private List<DetalleDonacion> getListaDeDonativosConfirmada(Evento evento, HashMap<ItemSolicitado, Integer> listaDeDonativos) {
        List<DetalleDonacion> detalleDonacionsList = new ArrayList<>();

        //Recorrer cada item de la lista de donativos
        for(Map.Entry<ItemSolicitado, Integer> unItemDeLaListaDonada : listaDeDonativos.entrySet()) {

            if (evento.getPedidoSolicitado().estaEnLaLista(unItemDeLaListaDonada.getKey())){
                detalleDonacionsList.add(new DetalleDonacion(unItemDeLaListaDonada.getKey(), unItemDeLaListaDonada.getValue()));
            }
        }
        return detalleDonacionsList;
    }*/

}

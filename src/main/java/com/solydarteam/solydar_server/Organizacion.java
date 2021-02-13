package com.solydarteam.solydar_server;

import com.solydarteam.solydar_server.evento.Evento;
import com.solydarteam.solydar_server.pedido.Pedido;

import java.util.ArrayList;
import java.util.List;

public class Organizacion {
    private String nombre;
    private CategoriaOrganizacion categoria;

    private List<Evento> misEventos;
    private List<Responsable> administradores;


    public Organizacion(){
        this.misEventos = new ArrayList<>();
        this.administradores = new ArrayList<>();
    }

    //<editor-fold desc="GETTERS AND SETTERS">
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CategoriaOrganizacion getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaOrganizacion categoria) {
        this.categoria = categoria;
    }

    public List<Evento> getMisEventos() {
        return misEventos;
    }

    public void setMisEventos(List<Evento> misEventos) {
        this.misEventos = misEventos;
    }

    public List<Responsable> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(List<Responsable> administradores) {
        this.administradores = administradores;
    }
    //</editor-fold>

    public void agregarAdministrador(Responsable unAdmin){
        administradores.add(unAdmin);
    }

    public void publicarEvento(Evento evento) {

    }
}

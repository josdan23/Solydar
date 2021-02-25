package com.solydarteam.solydar_server;

import com.solydarteam.solydar_server.evento.CategoriaEvento;
import com.solydarteam.solydar_server.evento.EventoSimple;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Organizacion {
    private String nombre;
    private CategoriaOrganizacion categoria;

    private List<EventoSimple> misEventos;
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

    public List<EventoSimple> getMisEventos() {
        return misEventos;
    }

    public void setMisEventos(List<EventoSimple> misEventos) {
        this.misEventos = misEventos;
    }

    public List<Responsable> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(List<Responsable> administradores) {
        this.administradores = administradores;
    }
    //</editor-fold>

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n\tNombre: ");
        builder.append(getNombre());
        builder.append("\n\tCategoria: ");
        builder.append(getCategoria());

        builder.append("\n\tLista de administradores");
        for (int i = 0; i < administradores.size(); i++){
            builder.append("\n\n\t" + i + ")");
            builder.append(administradores.get(i));
        }
        builder.append("\n\t*Mis eventos*");

        for (int i = 0; i < misEventos.size(); i++){
            builder.append("\n\n\t" + i + ")");
            builder.append(misEventos.get(i));
        }


        return builder.toString();
    }

    public void agregarAdministrador(Responsable unAdmin){
        administradores.add(unAdmin);
    }

    public EventoSimple crearNuevoEvento(String titulo,
                                         String descripcion,
                                         String aQuienAyuda,
                                         CategoriaEvento categoriaEvento,
                                         Date fechaDeRealizacion,
                                         Responsable responsable) throws Exception {


        if (isAdmin(responsable)){
            EventoSimple nuevoEvento = new EventoSimple();
            nuevoEvento.setTitulo(titulo);
            nuevoEvento.setDescripcion(descripcion);
            nuevoEvento.setAquienAyuda(aQuienAyuda);
            nuevoEvento.setCategoriaEvento(categoriaEvento);
            nuevoEvento.setFechaDeRealizacion(fechaDeRealizacion);
            nuevoEvento.setResponsable(responsable);

            return nuevoEvento;
        }
        throw new Exception("No es responsable de la organización");
    }

    public void registrarEnMisEventos(EventoSimple evento) throws Exception {
        if (isAdmin(evento.getResponsable()))
            misEventos.add(evento);
        else
            throw new Exception("El Responsable del evento no pertenece a la organización");
    }

    public boolean isAdmin(Responsable responsable){
        for (Responsable admin :
                administradores) {

            if (admin == responsable)
                return true;
        }
        return false;
    }
}

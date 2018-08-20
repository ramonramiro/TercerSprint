package com.principa.subnetting.easy.Entities;

import java.util.Map;

public class MessageSend extends Message {
    private Map time;

    public MessageSend()  {
    }


    public MessageSend(String message, String urlPhoto, String name, String profilePictur, String typeMessage, Map time) {
        super(message, urlPhoto, name, profilePictur, typeMessage);
        this.time = time;
    }

    public MessageSend(String mensaje, String nombre, String fotoPerfil, String type_mensaje, Map time) {
        super(mensaje, nombre, fotoPerfil, type_mensaje);
        this.time = time;
    }

    public MessageSend(Map time) {
        this.time = time;
    }

    public Map getHora() {
        return time;
    }

    public void setHora(Map time) {
        this.time = time;
    }
}

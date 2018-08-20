package com.principa.subnetting.easy.Entities;

public class Message {
    private String message;
    private String urlPhoto;
    private String name;
    private String profilePictur;
    private String typeMessage;

    public Message(String message, String urlPhoto, String name, String profilePictur, String typeMessage) {
        this.message = message;
        this.urlPhoto = urlPhoto;
        this.name = name;
        this.profilePictur = profilePictur;
        this.typeMessage = typeMessage;
    }

    public Message(String mensaje, String nombre, String fotoPerfil, String type_mensaje) {
        this.message = mensaje;
        this.name = nombre;
        this.profilePictur = fotoPerfil;
        this.typeMessage = type_mensaje;
    }

    public Message() {
    }

    public String getMensaje() {
        return message;
    }

    public void setMensaje(String mensaje) {
        this.message = mensaje;
    }

    public String getUrlFoto() {
        return urlPhoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlPhoto = urlFoto;
    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String nombre) {
        this.name = nombre;
    }

    public String getFotoPerfil() {
        return profilePictur;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.profilePictur = fotoPerfil;
    }

    public String getType_mensaje() {
        return typeMessage;
    }

    public void setType_mensaje(String type_mensaje) {
        this.typeMessage = type_mensaje;
    }
}


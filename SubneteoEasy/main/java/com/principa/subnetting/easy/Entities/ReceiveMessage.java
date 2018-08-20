package com.principa.subnetting.easy.Entities;

public class ReceiveMessage extends  Message {
    private Long time;

    public ReceiveMessage() {
    }

    public ReceiveMessage(Long time) {
        this.time = time;
    }


    public ReceiveMessage(String message, String urlPhoto, String name, String profilePictur, String typeMessage, Long time) {
        super(message, urlPhoto, name, profilePictur, typeMessage);
        this.time = time;
    }

    public Long getHora() {
        return time;
    }

    public void setHora(Long time) {
        this.time = time;
    }
}

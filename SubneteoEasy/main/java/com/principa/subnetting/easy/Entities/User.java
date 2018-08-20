package com.principa.subnetting.easy.Entities;

public class User {
    private String name;
    private String email;

    public User() {
    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String name) {
        this.name = name;
    }

    public String getCorreo() {
        return email;
    }

    public void setCorreo(String email) {
        this.email = email;
    }
}

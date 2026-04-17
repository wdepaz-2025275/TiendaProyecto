package com.wilfreddepaz.tienda.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Login")
public class LoginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_login")
    private Integer codigoLogin;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public Integer getCodigoLogin() {
        return codigoLogin;
    }

    public void setCodigoLogin(Integer codigoLogin) {
        this.codigoLogin = codigoLogin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

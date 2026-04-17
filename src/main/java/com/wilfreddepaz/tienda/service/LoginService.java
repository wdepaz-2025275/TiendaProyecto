package com.wilfreddepaz.tienda.service;

import com.wilfreddepaz.tienda.entity.LoginEntity;

import java.util.List;

public interface LoginService {
    LoginEntity registrar(String username, String password);
    LoginEntity login(String username, String password);
    List<LoginEntity> listar();
    void eliminar(Integer id);
}
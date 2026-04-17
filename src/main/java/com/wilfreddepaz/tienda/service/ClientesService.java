package com.wilfreddepaz.tienda.service;

import com.wilfreddepaz.tienda.entity.Clientes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientesService {
    List<Clientes> getAllClientes();
    Clientes getClientesById(Integer id);
    Clientes saveClientes (Clientes clientes) throws RuntimeException;
    Clientes updateClientes(Integer id, Clientes clientes);
    void deleteClientes(Integer id);
}
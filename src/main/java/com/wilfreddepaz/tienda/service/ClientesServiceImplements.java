package com.wilfreddepaz.tienda.service;

import com.wilfreddepaz.tienda.entity.Clientes;
import com.wilfreddepaz.tienda.repository.ClientesRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientesServiceImplements implements ClientesService {

    private final ClientesRepository clientesRepository;

    public ClientesServiceImplements(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    @Override
    public List<Clientes> getAllClientes() {
        return clientesRepository.findAll();
    }

    @Override
    public Clientes getClientesById(Integer id) {
        return clientesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    @Override
    public Clientes saveClientes(Clientes cliente) throws RuntimeException {
        try {
            if (clientesRepository.existsByNombreClienteAndApellidoClienteAndDireccionAndEstado(
                    cliente.getNombreCliente(),
                    cliente.getApellidoCliente(),
                    cliente.getDireccion(),
                    cliente.getEstado())) {
                throw new RuntimeException("Ya existe un cliente con estos datos");
            }
            return clientesRepository.save(cliente);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Clientes updateClientes(Integer id, Clientes cliente) {
        Clientes existingCliente = clientesRepository.findById(id).orElseThrow(() -> new RuntimeException("El cliente no existe"));

        if (clientesRepository.existsByNombreClienteAndApellidoClienteAndDireccionAndEstado(
                cliente.getNombreCliente(),
                cliente.getApellidoCliente(),
                cliente.getDireccion(),
                cliente.getEstado())) {
            throw new RuntimeException("Ya existe un cliente con estos datos");
        }

        existingCliente.setNombreCliente(cliente.getNombreCliente());
        existingCliente.setApellidoCliente(cliente.getApellidoCliente());
        existingCliente.setDireccion(cliente.getDireccion());
        existingCliente.setEstado(cliente.getEstado());

        return clientesRepository.save(existingCliente);
    }

    @Override
    public void deleteClientes(Integer id) {
        if (!clientesRepository.existsById(id)) {
            throw new RuntimeException("Este id no existe");
        }
        clientesRepository.deleteById(id);
    }
}
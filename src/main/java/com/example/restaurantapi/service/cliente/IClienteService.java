package com.example.restaurantapi.service.cliente;

import com.example.restaurantapi.model.Cliente;

import java.util.List;

public interface IClienteService {
    public List<Cliente> getAll();
    public Cliente getById(long id);
    public Cliente saveClient(Cliente cliente);
    public Cliente updateClient(Cliente cliente);
    public void deleteClient(long id);
}

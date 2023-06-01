package com.example.restaurantapi.service.cliente;

import com.example.restaurantapi.model.Cliente;
import com.example.restaurantapi.repo.IClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService{
    @Autowired
    private IClienteRepo clienteRepo;

    @Override
    public List<Cliente> getAll() {
        return clienteRepo.findAll();
    }

    @Override
    public Cliente getById(long id) {
        return clienteRepo.findById(id).get();
    }

    @Override
    public Cliente saveClient(Cliente cliente) {
        return clienteRepo.save(cliente);
    }

    @Override
    public Cliente updateClient(Cliente cliente) {
        return clienteRepo.save(cliente);
    }

    @Override
    public void deleteClient(long id) {
        clienteRepo.deleteById(id);
    }


}

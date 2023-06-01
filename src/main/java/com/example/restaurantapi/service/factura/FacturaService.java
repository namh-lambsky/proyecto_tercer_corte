package com.example.restaurantapi.service.factura;

import com.example.restaurantapi.model.Factura;
import com.example.restaurantapi.repo.IFacturaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaService implements IFacturaService {

    @Autowired
    private IFacturaRepo repo;
    @Override
    public List<Factura> getAllFacturas() {
        return repo.findAll();
    }

    @Override
    public Factura getById(long id) {
        return null;
    }

    @Override
    public Factura saveClient(Factura factura) {
        return null;
    }

    @Override
    public Factura updateClient(Factura factura) {
        return null;
    }

    @Override
    public void deleteClient(long id) {

    }
}

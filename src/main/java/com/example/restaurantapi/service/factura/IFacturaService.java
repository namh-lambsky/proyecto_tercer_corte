package com.example.restaurantapi.service.factura;


import com.example.restaurantapi.model.Factura;

import java.util.List;

public interface IFacturaService {
    public List<Factura> getAllFacturas();
    public Factura getById(long id);
    public Factura saveClient(Factura factura);
    public Factura updateClient(Factura factura);
    public void deleteClient(long id);
}

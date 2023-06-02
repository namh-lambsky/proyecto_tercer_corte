package com.example.restaurantapi.service.factura;


import com.example.restaurantapi.model.Factura;

import java.util.List;

public interface IFacturaService {
    public List<Factura> getAllFacturas();
    public Factura getById(long id);
    public Factura saveFactura(Factura factura);
    public Factura updateFactura(Factura factura);
    public void deleteFactura(long id);
}

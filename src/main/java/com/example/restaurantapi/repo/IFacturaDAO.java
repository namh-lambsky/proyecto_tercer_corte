package com.example.restaurantapi.repo;

import com.example.restaurantapi.model.Factura;
import org.springframework.data.repository.CrudRepository;

public interface IFacturaDAO extends CrudRepository<Factura,Long> {
}

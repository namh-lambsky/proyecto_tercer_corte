package com.example.restaurantapi.repo;

import com.example.restaurantapi.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacturaRepo extends JpaRepository<Factura, Long> {
}

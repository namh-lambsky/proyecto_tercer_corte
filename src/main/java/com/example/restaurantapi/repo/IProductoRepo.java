package com.example.restaurantapi.repo;

import com.example.restaurantapi.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepo extends JpaRepository<Producto, Long> {
}

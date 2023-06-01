package com.example.restaurantapi.repo;

import com.example.restaurantapi.model.ItemFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IItemFacturaRepo extends JpaRepository<ItemFactura, Long> {
}

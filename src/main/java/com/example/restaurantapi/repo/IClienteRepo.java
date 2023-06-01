package com.example.restaurantapi.repo;

import com.example.restaurantapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepo extends JpaRepository<Cliente, Long> {
}

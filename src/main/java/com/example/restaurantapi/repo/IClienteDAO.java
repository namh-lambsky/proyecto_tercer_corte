package com.example.restaurantapi.repo;

import com.example.restaurantapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteDAO extends JpaRepository<Cliente,Long> {

}

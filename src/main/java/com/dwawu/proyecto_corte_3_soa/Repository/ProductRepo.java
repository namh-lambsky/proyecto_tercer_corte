package com.dwawu.proyecto_corte_3_soa.Repository;

import com.dwawu.proyecto_corte_3_soa.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {
}

package com.dwawu.proyecto_corte_3_soa.Service;

import com.dwawu.proyecto_corte_3_soa.Model.Product;
import com.dwawu.proyecto_corte_3_soa.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    @Transactional(readOnly = true)
    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    @Transactional(readOnly = true)
    public Product getProductById(long id) {
        return productRepo.findById(id).orElse(null);
    }

    @Transactional
    public Product saveProduct(Product Product){
        return productRepo.save(Product);
    }

    @Transactional
    public void deleteProductById(long id){
        productRepo.deleteById(id);
    }

}

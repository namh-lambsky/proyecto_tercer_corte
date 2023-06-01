package com.example.restaurantapi.service.producto;

import com.example.restaurantapi.model.Producto;
import com.example.restaurantapi.repo.IProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private  IProductoRepo productoRepo;

    @Override
    public List<Producto> getAllProducts() {
        return productoRepo.findAll();
    }

    @Override
    public Producto getProductById(long id) {

        return productoRepo.findById(id).get();
    }

    @Override
    public Producto saveProduct(Producto producto) {
        return productoRepo.save(producto);
    }

    @Override
    public Producto updateProduct(Producto producto) {
        return productoRepo.save(producto);
    }

    @Override
    public void deleteProduct(long id) {
        productoRepo.deleteById(id);
    }


}

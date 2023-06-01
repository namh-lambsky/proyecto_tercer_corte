package com.example.restaurantapi.service.producto;
import com.example.restaurantapi.model.Producto;

import java.util.List;

public interface IProductoService {
    public List<Producto> getAllProducts();
    public Producto getProductById(long id);
    public Producto saveProduct(Producto producto);
    public Producto updateProduct(Producto producto);
    public void deleteProduct(long id);
}

package com.example.restaurantapi.controller;

import com.example.restaurantapi.model.Producto;
import com.example.restaurantapi.service.producto.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping("/productos")
    public String showAll(Model model) {
        model.addAttribute("productos", productoService.getAllProducts());
        return "productos";
    }
    @GetMapping("/productos/agregar")
    public String showForm(Model model) {
        Producto producto = new Producto();
        model.addAttribute("productos", producto);
        return "agregarProductos";
    }
    @PostMapping("/productos")
    public String save(@ModelAttribute("producto") Producto producto) {
        productoService.saveProduct(producto);
        return "redirect:/productos";
    }

    @GetMapping("/productos/editar/{id}")
    public String showEditForm(@PathVariable long id, Model model){
        model.addAttribute("productos",productoService.getProductById(id));
        return "editar_producto";
    }

    @PostMapping("/productos/{id}")
    public String updateProduct(@PathVariable long id, @ModelAttribute Producto producto, Model model){
        Producto productoExistente = productoService.getProductById(id);
        productoExistente.setId(id);
        productoExistente.setNombre(producto.getNombre());
        productoExistente.setDescripcion(producto.getDescripcion());
        productoExistente.setCantidad(producto.getCantidad());
        productoExistente.setPrecio_unitario(producto.getPrecio_unitario());
        productoService.updateProduct(productoExistente);
        return "redirect:/productos";
    }

    @GetMapping("/productos/{id}")
    public  String deleteClient(@PathVariable long id){
        productoService.deleteProduct(id);
        return "redirect:/productos";
    }
}

package com.example.restaurantapi.controller;


import com.example.restaurantapi.model.Factura;
import com.example.restaurantapi.model.Producto;
import com.example.restaurantapi.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "*"})
@RestController
@RequestMapping("/api")
public class FacturaController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/facturas/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Factura show(@PathVariable Long id) {
        return clienteService.findFacturaById(id);
    }

    @DeleteMapping("/facturas/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        System.out.println("FacturaRestController delete");
        clienteService.deleteFacturaById(id);
    }

    @GetMapping("/facturas/filtrar-productos/{term}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Producto> filtrarProductos(@PathVariable String term) {
        return clienteService.findProductoByNombre(term);
    }

    @PostMapping("/facturas")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Factura crear(@RequestBody Factura factura) {
        return clienteService.saveFactura(factura);
    }


}

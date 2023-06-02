package com.example.restaurantapi.controller;

import com.example.restaurantapi.model.Cliente;
import com.example.restaurantapi.model.Factura;
import com.example.restaurantapi.model.Producto;
import com.example.restaurantapi.service.factura.FacturaService;
import com.example.restaurantapi.service.factura.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FacturaController {

    @Autowired
    private IFacturaService facturaService;

    @GetMapping("/facturas")
    public String listarFacturas(Model modelo){
        modelo.addAttribute("facturas",facturaService.getAllFacturas());
        return "facturas";
    }
    @GetMapping("/facturas/nueva")
    public String showForm(Model modelo) {
        Factura factura = new Factura();
        modelo.addAttribute("factura", factura);
        return "nueva_factura";
    }
    @PostMapping("/factura")
    public String save(@ModelAttribute("factura") Factura factura) {
        facturaService.saveFactura(factura);
        return "redirect:/clientes";
    }
}


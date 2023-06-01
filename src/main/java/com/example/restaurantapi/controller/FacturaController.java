package com.example.restaurantapi.controller;

import com.example.restaurantapi.service.factura.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FacturaController {

    @Autowired
    private IFacturaService service;

    @GetMapping("/facturas")
    public String listarFacturas(Model modelo){
        modelo.addAttribute("facturas",service.getAllFacturas());
        return "facturas";
    }
}

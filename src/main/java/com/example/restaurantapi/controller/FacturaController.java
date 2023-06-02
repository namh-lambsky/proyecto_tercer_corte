package com.example.restaurantapi.controller;

import com.example.restaurantapi.model.Factura;
import com.example.restaurantapi.service.factura.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        return "redirect:/facturas";
    }
    @GetMapping("/facturas/editar/{id}")
    public String showEditForm(@PathVariable long id, Model model){
        model.addAttribute("factura",facturaService.getById(id));
        return "editar_factura";
    }
    @PostMapping("/facturas/{id}")
    public String updateFactura(@PathVariable long id, @ModelAttribute Factura factura, Model model){
        Factura facturaExistente = facturaService.getById(id);
        facturaExistente.setId(id);
        facturaExistente.setCliente(factura.getCliente());
        facturaExistente.setItems(factura.getItems());
        facturaExistente.setTotal(factura.getTotal());
        facturaExistente.setFecha_creacion(factura.getFecha_creacion());
        facturaService.updateFactura(facturaExistente);
        return "redirect:/facturas";
    }
    @GetMapping("/facturas/{id}")
    public  String deleteFactura(@PathVariable long id){
        facturaService.deleteFactura(id);
        return "redirect:/facturas";
    }
}


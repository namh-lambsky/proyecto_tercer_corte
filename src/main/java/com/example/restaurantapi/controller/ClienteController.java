package com.example.restaurantapi.controller;

import com.example.restaurantapi.model.Cliente;
import com.example.restaurantapi.service.cliente.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClienteController {
    @Autowired
    private IClienteService clienteService;

    @GetMapping("/clientes")
    public String showAll(Model model) {
        model.addAttribute("clientes", clienteService.getAll());
        return "clientes";
    }

    @GetMapping("/clientes/nuevo")
    public String showForm(Model model) {
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        return "nuevo_cliente";
    }

    @PostMapping("/clientes")
    public String save(@ModelAttribute("cliente") Cliente cliente) {
        clienteService.saveClient(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/editar/{id}")
    public String showEditForm(@PathVariable long id, Model model){
        model.addAttribute("cliente",clienteService.getById(id));
        return "editar_cliente";
    }

    @PostMapping("/clientes/{id}")
    public String updateClient(@PathVariable long id, @ModelAttribute Cliente cliente, Model model){
        Cliente clienteExistente = clienteService.getById(id);
        clienteExistente.setId(id);
        clienteExistente.setNombre(cliente.getNombre());
        clienteExistente.setApellido(cliente.getApellido());
        clienteExistente.setEmail(cliente.getEmail());
        clienteExistente.setTelefono(cliente.getTelefono());
        clienteService.updateClient(clienteExistente);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/{id}")
    public  String deleteClient(@PathVariable long id){
        clienteService.deleteClient(id);
        return "redirect:/clientes";
    }
}

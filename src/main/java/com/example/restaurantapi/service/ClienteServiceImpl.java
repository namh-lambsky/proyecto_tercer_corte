package com.example.restaurantapi.service;

import com.example.restaurantapi.model.Cliente;
import com.example.restaurantapi.model.Factura;
import com.example.restaurantapi.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.restaurantapi.repo.IClienteDAO;
import com.example.restaurantapi.repo.IFacturaDAO;
import com.example.restaurantapi.repo.IProductoDAO;


import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService{
    @Autowired
    private IClienteDAO clienteDao;

    @Autowired
    private IFacturaDAO facturaDao;

    @Autowired
    private IProductoDAO productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {

        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Cliente> findAll(Pageable pageable) {
        return clienteDao.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id) {

        return clienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {

        return clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Long id) {

        clienteDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Factura findFacturaById(Long id) {
        return facturaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Factura saveFactura(Factura factura) {
        return facturaDao.save(factura);
    }

    @Override
    @Transactional
    public void deleteFacturaById(Long id) {
        facturaDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findProductoByNombre(String term) {
        return productoDao.findByNombreContainingIgnoreCase(term);
    }


}

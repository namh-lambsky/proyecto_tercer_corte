package com.dwawu.proyecto_corte_3_soa.Controller;

import com.dwawu.proyecto_corte_3_soa.Model.Product;
import com.dwawu.proyecto_corte_3_soa.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getProducts() {
        return this.productService.getProducts();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProductById(@PathVariable long id) {
        return this.productService.getProductById(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Product saveProduct(@RequestBody Product Product) {
        return this.productService.saveProduct(Product);
    }

    @PutMapping(path = "/update-{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Product updateProduct(@RequestBody Product request, @PathVariable long id) {
        Product product = productService.getProductById(id);
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setQuantity(request.getQuantity());
        product.setPackage_type(request.getPackage_type());
        product.setUnitary_price(request.getUnitary_price());
        product.setProductDetailList(request.getProductDetailList());
        product.setIva(request.isIva());

        return this.productService.saveProduct(product);
    }

    @DeleteMapping(path = "/delete-{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable long id) {
        this.productService.deleteProductById(id);
    }

}

package com.dwawu.proyecto_corte_3_soa.Controller;


import com.dwawu.proyecto_corte_3_soa.Model.ProductDetail;
import com.dwawu.proyecto_corte_3_soa.Service.ProductDetailService;
import com.dwawu.proyecto_corte_3_soa.Service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/product_details")
public class ProductDetailController {
    @Autowired
    ProductDetailService productDetailService;

    @Autowired
    ReceiptService receiptService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDetail> getProductDetails() {
        return this.productDetailService.getProductDetails();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDetail getProductDetailById(@PathVariable long id) {
        return this.productDetailService.getProductDetailById(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDetail saveProductDetail(@RequestBody ProductDetail ProductDetail) {
        return this.productDetailService.saveProductDetail(ProductDetail);
    }

    @PutMapping(path = "/update-{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDetail updateProductDetail(@RequestBody ProductDetail request, @PathVariable long id) {
        ProductDetail pd = productDetailService.getProductDetailById(id);
        pd.setProduct(request.getProduct());
        pd.setQuantity(request.getQuantity());
        pd.setReceipt(receiptService.getReceiptById(request.getReceipt().getId()));
        return this.productDetailService.saveProductDetail(pd);
    }

    @DeleteMapping(path = "/delete-{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProductDetail(@PathVariable long id) {
        this.productDetailService.deleteProductDetailById(id);
    }

}

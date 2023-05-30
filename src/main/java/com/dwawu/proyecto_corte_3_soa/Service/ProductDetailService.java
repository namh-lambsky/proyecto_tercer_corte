package com.dwawu.proyecto_corte_3_soa.Service;

import com.dwawu.proyecto_corte_3_soa.Model.Product;
import com.dwawu.proyecto_corte_3_soa.Model.ProductDetail;
import com.dwawu.proyecto_corte_3_soa.Repository.ProductDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductDetailService {
    @Autowired
    ProductDetailRepo productDetailRepo;

    ProductService productService;

    @Transactional(readOnly = true)
    public List<ProductDetail> getProductDetails() {
        return productDetailRepo.findAll();
    }

    @Transactional(readOnly = true)
    public ProductDetail getProductDetailById(long id) {
        return productDetailRepo.findById(id).orElse(null);
    }

    @Transactional
    public ProductDetail saveProductDetail(ProductDetail productDetail) {
        return productDetailRepo.save(productDetail);
    }

    public void update_quantity(long id,long quantity){
        Product ptemp = productService.getProductById(id);
        if(!ptemp.no_quantity()){
            ptemp.update_quantity(quantity);
        }
        productService.saveProduct(ptemp);
    }

    @Transactional
    public void deleteProductDetailById(long id) {
        productDetailRepo.deleteById(id);
    }

}

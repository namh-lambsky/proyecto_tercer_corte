package com.dwawu.proyecto_corte_3_soa.Service;

import com.dwawu.proyecto_corte_3_soa.Model.ProductDetail;
import com.dwawu.proyecto_corte_3_soa.Model.Receipt;
import com.dwawu.proyecto_corte_3_soa.Repository.ReceiptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReceiptService {
    @Autowired
    ReceiptRepo receiptRepo;

    @Autowired
    ProductDetailService productDetailService;

    @Transactional(readOnly = true)
    public List<Receipt> getReceipts() {
        return receiptRepo.findAll();
    }

    @Transactional(readOnly = true)
    public Receipt getReceiptById(long id) {
        return receiptRepo.findById(id).orElse(null);
    }

    @Transactional
    public Receipt saveReceipt(Receipt receipt) {
        for (ProductDetail pd:receipt.getProductDetailList()) {
            productDetailService.update_quantity(pd.getProduct().getId(), pd.getQuantity());
        }
        return receiptRepo.save(receipt);
    }

    @Transactional
    public void deleteReceiptById(long id) {
        receiptRepo.deleteById(id);
    }

}

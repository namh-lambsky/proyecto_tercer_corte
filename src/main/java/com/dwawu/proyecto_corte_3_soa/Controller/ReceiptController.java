package com.dwawu.proyecto_corte_3_soa.Controller;

import com.dwawu.proyecto_corte_3_soa.Model.Receipt;
import com.dwawu.proyecto_corte_3_soa.Service.ReceiptService;
import com.dwawu.proyecto_corte_3_soa.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/receipts")
public class ReceiptController {
    @Autowired
    ReceiptService receiptService;

    @Autowired
    UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Receipt> getReceipts() {
        return this.receiptService.getReceipts();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Receipt getReceiptById(@PathVariable long id) {
        return this.receiptService.getReceiptById(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Receipt saveReceipt(@RequestBody Receipt receipt) {
        System.out.println(receipt);
        return this.receiptService.saveReceipt(receipt);
    }

    @PutMapping(path = "/update-{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Receipt updateReceipt(@RequestBody Receipt request, @PathVariable long id) {
        System.out.println(request.getUser().getId());
        Receipt receipt = receiptService.getReceiptById(id);
        if (request.getUser()!=null){
            receipt.setUser(userService.getUserById(request.getUser().getId()));
        }
        if(request.getProductDetailList()!=null && !request.getProductDetailList().isEmpty()) {
            receipt.setProductDetailList(request.getProductDetailList());
        }
        receipt.setTotal(request.getTotal());
        receipt.setDate(request.getDate());
        return this.receiptService.saveReceipt(receipt);
    }

    @DeleteMapping(path = "/delete-{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteReceipt(@PathVariable long id) {
        this.receiptService.deleteReceiptById(id);
    }

}

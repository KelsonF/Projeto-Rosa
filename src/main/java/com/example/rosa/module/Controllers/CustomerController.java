package com.example.rosa.module.Controllers;

import com.example.rosa.module.DTOs.InvestmentProductDTO;
import com.example.rosa.module.Entities.InvestimentProduct;
import com.example.rosa.module.Services.InvestmentProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    private final InvestmentProductService investmentProductService;

    @Autowired
    public CustomerController(InvestmentProductService investmentProductService){
        this.investmentProductService = investmentProductService;
    }

    @GetMapping("/customers")
    public List<InvestimentProduct> customersList(){
        return investmentProductService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public InvestimentProduct getCustomById(@PathVariable String id){
        return investmentProductService.getCustomerById(id);
    }

    @PostMapping("/customer/create")
    public void createNewCustomer(@ModelAttribute(value = "investmentProduct") InvestmentProductDTO investmentProduct){
        investmentProductService.createNewCustomer(investmentProduct);
    }

    @GetMapping("/customers/updateStatus/{id}")
    public void updateStatus(@PathVariable String id){
        investmentProductService.changeProductStatus(id);
    }

    @DeleteMapping("/customer/delete/{id}")
    public void deleteCustomer( @PathVariable String id){
        InvestimentProduct customer = investmentProductService.getCustomerById(id);
        investmentProductService.deleteCustomer(customer);
    }
}

package com.example.rosa.module.Controllers;

import com.example.rosa.module.DTOs.InvestmentProductDTO;
import com.example.rosa.module.Entities.InvestimentProduct;
import com.example.rosa.module.Services.InvestmentProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CustomerController {
    private final InvestmentProductService investmentProductService;

    @Autowired
    public CustomerController(InvestmentProductService investmentProductService){
        this.investmentProductService = investmentProductService;
    }

    @GetMapping(value = "/customers", produces = "application/json")
    public List<InvestimentProduct> customersList(){
        return investmentProductService.getAllCustomers();
    }

    @GetMapping(value = "/customers/{id}", produces = "application/json")
    public InvestimentProduct getCustomById(@PathVariable String id){
        return investmentProductService.getCustomerById(id);
    }

    @PostMapping("/customer/create")
    public void createNewCustomer(@Validated @ModelAttribute(value = "investmentProduct") InvestmentProductDTO investmentProduct){
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

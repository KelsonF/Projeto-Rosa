package com.example.rosa.module.Controllers;

import com.example.rosa.module.DTOs.InvestmentProductDTO;
import com.example.rosa.module.Entities.InvestimentProduct;
import com.example.rosa.module.Services.InvestmentProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@Controller
public class CustomerController {
    private final InvestmentProductService investmentProductService;

    @Autowired
    public CustomerController(InvestmentProductService investmentProductService){
        this.investmentProductService = investmentProductService;
    }

    @GetMapping("/customers")
    public String customersList(Model model){
        final var investmentProductList = investmentProductService.getAllCustomers();
        model.addAttribute("investmentProductList", investmentProductList);

        return "customers";
    }

    @GetMapping("/customer/create")
    public String showForm(Model model){
        InvestmentProductDTO investimentProduct = new InvestmentProductDTO();
        model.addAttribute("investmentProduct", investimentProduct);

        return "form";
    }

    @PostMapping("/customer/create")
    public String createNewCustomer(@ModelAttribute(value = "investmentProduct") InvestmentProductDTO investmentProduct){
        investmentProductService.createNewCustomer(investmentProduct);
        return "redirect:/";
    }

    @DeleteMapping("/customer/delete/{id}")
    public void deleteCustomer( @PathVariable String id){
        InvestimentProduct customer = investmentProductService.getCustomerById(id);
        investmentProductService.deleteCustomer(customer);
    }
}

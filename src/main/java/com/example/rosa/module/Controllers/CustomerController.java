package com.example.rosa.module.Controllers;

import com.example.rosa.module.DTOs.InvestmentProductDTO;
import com.example.rosa.module.Entities.InvestimentProduct;
import com.example.rosa.module.Services.InvestmentProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final InvestmentProductService investmentProductService;

    @Autowired
    public CustomerController(InvestmentProductService investmentProductService){
        this.investmentProductService = investmentProductService;
    }

    @GetMapping("/")
    public String customersList(Model model){
        final var investmentProductList = investmentProductService.getAllCustomers();
        model.addAttribute("investmentProductList", investmentProductList);

        return "customers";
    }

    @GetMapping("/create")
    public String showForm(Model model){
        InvestmentProductDTO investimentProduct = new InvestmentProductDTO();
        model.addAttribute("investmentProduct", investimentProduct);

        return "form";
    }

    @PostMapping("/create")
    public String createNewCustomer(@ModelAttribute(value = "customer") InvestmentProductDTO customer){
        investmentProductService.createNewCustomer(customer);
        return "redirect:/customers/";
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer( @PathVariable String id){
        InvestimentProduct customer = investmentProductService.getCustomerById(id);
        investmentProductService.deleteCustomer(customer);
    }
}

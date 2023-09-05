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

    @GetMapping("/customer/create")
    public String showForm(Model model){
        InvestmentProductDTO investimentProduct = new InvestmentProductDTO();
        model.addAttribute("investmentProduct", investimentProduct);

        return "form";
    }

    @PostMapping("/customer/create")
    public String createNewCustomer(@ModelAttribute(value = "investmentProduct") InvestmentProductDTO investmentProduct){
        investmentProductService.createNewCustomer(investmentProduct);

        return "redirect:/customers";
    }

    @GetMapping("/customers/updateStatus/{id}")
    public String updateStatus(@PathVariable String id){
        investmentProductService.changeProductStatus(id);

        return "redirect:/customers";
    }

    @DeleteMapping("/customer/delete/{id}")
    public String deleteCustomer( @PathVariable String id){
        InvestimentProduct customer = investmentProductService.getCustomerById(id);
        investmentProductService.deleteCustomer(customer);

        return "redirect:/customers";
    }
}

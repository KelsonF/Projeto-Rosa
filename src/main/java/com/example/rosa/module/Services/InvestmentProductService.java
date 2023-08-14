package com.example.rosa.module.Services;

import com.example.rosa.module.DTOs.InvestmentProductDTO;
import com.example.rosa.module.Entities.InvestimentProduct;
import com.example.rosa.module.Enums.InvestimentProductStatus;
import com.example.rosa.module.Repositories.InvestimentProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestmentProductService {

    private final InvestimentProductRepository customerRepository;

    @Autowired
    public InvestmentProductService(InvestimentProductRepository customerRepository) { this.customerRepository = customerRepository; }

    public void createNewCustomer(InvestmentProductDTO customerData){
        final var customer = new InvestimentProduct();
        customer.setName(customerData.getName());
        customer.setStatus(InvestimentProductStatus.AVAILABLE);
        customer.setDestination(customerData.getDestination());
        customer.setProfitabilityRate(customerData.getProfitabilityRate());
        customer.setTerm(customerData.getTerm());
        customer.setAdministrationTax(customer.getAdministrationTax());
        customerRepository.save(customer);
    }

    public List<InvestimentProduct> getAllCustomers(){
        return  customerRepository.findAll();
    }

    public InvestimentProduct getCustomerById(String Id){
        return customerRepository.getReferenceById(Id);
    }

    public void deleteCustomer(InvestimentProduct customer){
        customerRepository.delete(customer);
    }
}

package com.example.rosa.module.Services;

import com.example.rosa.module.DTOs.InvestmentProductDTO;
import com.example.rosa.module.Entities.InvestimentProduct;
import com.example.rosa.module.Enums.InvestimentProductStatus;
import com.example.rosa.module.Repositories.InvestimentProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InvestmentProductService {

    private final InvestimentProductRepository customerRepository;

    @Autowired
    public InvestmentProductService(InvestimentProductRepository customerRepository) { this.customerRepository = customerRepository; }

    public void createNewCustomer(InvestmentProductDTO customerData){
        final var customer = new InvestimentProduct();
        customer.setId(UUID.randomUUID().toString().replace("-", ""));
        customer.setName(customerData.getName());
        customer.setStatus(InvestimentProductStatus.AVAILABLE);
        customer.setDestination(customerData.getDestination());
        customer.setProfitabilityRate(customerData.getProfitabilityRate());
        customer.setTerm(customerData.getTerm());
        customer.setAdministrationTax(customerData.getAdministrationTax());
        customer.setExpired(customerData.getExpired());
        customerRepository.save(customer);
    }

    public List<InvestimentProduct> getAllCustomers(){
        return  customerRepository.findAll();
    }

    public InvestimentProduct getCustomerById(String id){
        return customerRepository.getReferenceById(id);
    }

    public void changeProductStatus(String id){
        InvestimentProduct investimentProduct = customerRepository.getReferenceById(id);

        if (investimentProduct.getStatus() == InvestimentProductStatus.AVAILABLE) {
            investimentProduct.setStatus(InvestimentProductStatus.UNAVAILABLE);
        } else {
            investimentProduct.setStatus(InvestimentProductStatus.AVAILABLE);
        }

        customerRepository.save(investimentProduct);
    }


    public void deleteCustomer(InvestimentProduct customer){
        customerRepository.delete(customer);
    }
}

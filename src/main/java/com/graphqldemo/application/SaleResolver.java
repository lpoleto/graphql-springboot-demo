package com.graphqldemo.application;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.graphqldemo.domain.Customer;
import com.graphqldemo.domain.Product;
import com.graphqldemo.domain.Sale;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SaleResolver implements GraphQLResolver<Sale> {
    private CustomerService customerService;
    private ProductService productService;

    public String status(Sale sale) {
        return "Test: " + sale.getStatus();
    }

    public Customer customer(Sale sale) {
        return customerService.findById(sale.getCustomer().getId());
    }

    public Product product(Sale sale) {
        return productService.findById(sale.getProduct().getId());
    }
}

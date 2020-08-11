package com.graphqldemo.application;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.graphqldemo.domain.Customer;
import com.graphqldemo.domain.Sale;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CustomerResolver implements GraphQLResolver<Customer> {
    private SaleService saleService;

    public List<Sale> sales (Customer customer) {
        return saleService.findAllByCustomer(customer);
    }
}

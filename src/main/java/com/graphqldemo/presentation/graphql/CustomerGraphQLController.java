package com.graphqldemo.presentation.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphqldemo.domain.Customer;
import com.graphqldemo.domain.CustomerInput;
import com.graphqldemo.application.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CustomerGraphQLController implements GraphQLQueryResolver, GraphQLMutationResolver {
    private CustomerService customerService;

    public Customer customer(Long id) {
        return customerService.findById(id);
    }

    public List<Customer> customers() {
        return customerService.findAll();
    }

    public Customer saveCustomer(CustomerInput customerInput) {
        Customer customer = new Customer(customerInput.getId(), customerInput.getName(), customerInput.getEmail());
        return customerService.save(customer);
    }

    public Long deleteCustomer(Long id) {
        return customerService.deleteById(id);
    }
}

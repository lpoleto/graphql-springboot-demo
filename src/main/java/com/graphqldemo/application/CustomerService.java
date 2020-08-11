package com.graphqldemo.application;

import com.graphqldemo.domain.Customer;
import com.graphqldemo.domain.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;

    public Customer findById(Long id) {
        return customerRepository.findById(id)
                .orElse(null);
    }

//    @Cacheable("customers")
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Transactional
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Transactional
    public Long deleteById(Long id) {
        customerRepository.deleteById(id);

        return id;
    }

}

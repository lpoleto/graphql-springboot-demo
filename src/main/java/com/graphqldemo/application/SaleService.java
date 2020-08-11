package com.graphqldemo.application;

import com.graphqldemo.domain.Customer;
import com.graphqldemo.domain.Sale;
import com.graphqldemo.domain.SaleRepository;
import com.graphqldemo.utils.exception.DomainException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class SaleService {
    private SaleRepository saleRepository;

    public Sale findById(Long id) {
        return saleRepository.findById(id)
                .orElse(null);
    }

    public List<Sale> findAll(Pageable pageable) {
        return saleRepository.findAll(pageable).getContent() ;
    }

    @Transactional
//    @CacheEvict(value = "SalesByCustomer", key = "#sale.customer.id")
    public Sale save(Sale sale) {
        if (sale.getQty() > 100) {
            throw new DomainException("Too many products.");
        }

        return saleRepository.save(sale);
    }

    @Transactional
    public Long deleteById(Long id) {
        saleRepository.deleteById(id);

        return id;
    }

//    @Cacheable(value = "SalesByCustomer", key = "#customer.id")
    public List<Sale> findAllByCustomer(Customer customer) {
        return saleRepository.findAllByCustomer(customer);
    }
}

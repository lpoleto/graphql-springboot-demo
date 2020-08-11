package com.graphqldemo.application;

import com.graphqldemo.domain.Product;
import com.graphqldemo.domain.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElse(null);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Transactional
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    public Long deleteById(Long id) {
        productRepository.deleteById(id);

        return id;
    }

}

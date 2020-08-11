package com.graphqldemo.presentation.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphqldemo.domain.Product;
import com.graphqldemo.application.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ProductGraphQLController implements GraphQLQueryResolver, GraphQLMutationResolver {
    private ProductService productService;

    public Product product(Long id) {
        return productService.findById(id);
    }

    public List<Product> products() {
        return productService.findAll();
    }

    public Product saveProduct(Long id, String name, Double amount) {
        Product  product = new  Product(id, name, amount);
        return productService.save(product);
    }

    public Long deleteProduct(Long id) {
        return productService.deleteById(id);
    }
}

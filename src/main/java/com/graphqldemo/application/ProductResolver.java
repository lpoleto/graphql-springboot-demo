package com.graphqldemo.application;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.graphqldemo.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductResolver implements GraphQLResolver<Product> {
    public String usdAmount(Product product) {
        return "$" + product.getAmount();
    }
}

package com.graphqldemo.presentation.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphqldemo.domain.Sale;
import com.graphqldemo.domain.SaleInput;
import com.graphqldemo.application.CustomerService;
import com.graphqldemo.application.ProductService;
import com.graphqldemo.application.SaleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class SaleGraphQLController implements GraphQLQueryResolver, GraphQLMutationResolver {
    private SaleService saleApplicationService;
    private CustomerService customerService;
    private ProductService productService;

    public Sale sale(Long id) {
        return saleApplicationService.findById(id);
    }

    public List<Sale> sales(int page, int size) {
        return saleApplicationService.findAll(PageRequest.of(page, size));
    }

    public Sale saveSale(SaleInput saleInput) {
        Sale  sale = Sale.builder()
                .id(saleInput.getId())
                .qty(saleInput.getQty())
                .status(saleInput.getStatus())
                .customer(customerService.findById(saleInput.getCustomerId()))
                .product(productService.findById(saleInput.getProductId()))
                .build();

        return saleApplicationService.save(sale);
    }

    public Long deleteSale(Long id) {
        return saleApplicationService.deleteById(id);
    }
}

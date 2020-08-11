package com.graphqldemo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleInput {
    private Long id;
    private Integer qty;
    private String status;
    private Long customerId;
    private Long productId;

}

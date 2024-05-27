package io.matheusvictor.product_query_service.dto;

import io.matheusvictor.product_query_service.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEvent {

    private String eventType;

    private Product product;
}

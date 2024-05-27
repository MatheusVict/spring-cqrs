package io.matheusvictor.product_command_service.controller;

import io.matheusvictor.product_command_service.dto.ProductEvent;
import io.matheusvictor.product_command_service.entity.Product;
import io.matheusvictor.product_command_service.service.ProductCommandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductCommandService service;


    public ProductController(ProductCommandService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductEvent product) {
        Product response = this.service.create(product);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable long id, @RequestBody ProductEvent product) {
        Product response = this.service.update(id, product);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        this.service.delete(id);

        return ResponseEntity.noContent().build();
    }
}

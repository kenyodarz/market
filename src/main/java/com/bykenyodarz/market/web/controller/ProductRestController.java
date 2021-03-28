package com.bykenyodarz.market.web.controller;

import com.bykenyodarz.market.domain.services.apis.ProductServiceAPI;
import com.bykenyodarz.market.domain.viewmodel.Product;
import com.bykenyodarz.market.shared.generated.GenericRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/products")
public class ProductRestController extends GenericRestController<Product, Integer> {

    private final ProductServiceAPI serviceAPI;

    public ProductRestController(ProductServiceAPI serviceAPI) {
        super(serviceAPI);
        this.serviceAPI = serviceAPI;
    }


    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("id") int categoryId) {
        return serviceAPI.getByCategory(categoryId).map(
                products -> ResponseEntity.ok().body(products)
        ).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/scarse/{id}")
    public ResponseEntity<List<Product>> getScarseProducts(@PathVariable("id") int quantity) {
        return serviceAPI.getScarseProducts(quantity).map(
                products -> ResponseEntity.ok().body(products)
        ).orElse(ResponseEntity.notFound().build());
    }


}

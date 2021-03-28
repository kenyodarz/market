package com.bykenyodarz.market.web.controller;

import com.bykenyodarz.market.domain.services.apis.ProductServiceAPI;
import com.bykenyodarz.market.domain.viewmodel.Product;
import com.bykenyodarz.market.shared.generated.GenericRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/products")
@Api(tags = "Products")
public class ProductRestController extends GenericRestController<Product, Integer> {

    private final ProductServiceAPI serviceAPI;

    public ProductRestController(ProductServiceAPI serviceAPI) {
        super(serviceAPI);
        this.serviceAPI = serviceAPI;
    }


    @GetMapping("/category/{id}")
    @ApiOperation(value = "Obtiene todos los productos por Categoría",
            notes = "Servicio para listar todos los productos por categoría")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Entidad listada correctamente"),
            @ApiResponse(code = 401, message = "Usuario No Autorizado"),
            @ApiResponse(code = 403, message = "Solicitud prohibida por el servidor"),
            @ApiResponse(code = 404, message = "Entidad no encontrada")})
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

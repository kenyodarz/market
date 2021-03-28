package com.bykenyodarz.market.web.controller;

import com.bykenyodarz.market.domain.services.apis.PurchaseServiceAPI;
import com.bykenyodarz.market.domain.viewmodel.Purchase;
import com.bykenyodarz.market.shared.generated.GenericRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/purchases")
public class PurchaseRestController extends GenericRestController<Purchase, Integer> {

    private final PurchaseServiceAPI serviceAPI;

    public PurchaseRestController(PurchaseServiceAPI serviceAPI) {
        super(serviceAPI);
        this.serviceAPI = serviceAPI;
    }

    @GetMapping("/byClient/{id}")
    public ResponseEntity<List<Purchase>> getByClient(@PathVariable("id") String clientId) {
        return serviceAPI.getByClient(clientId)
                .map(purchases -> ResponseEntity.ok().body(purchases))
                .orElse(ResponseEntity.notFound().build());
    }


}

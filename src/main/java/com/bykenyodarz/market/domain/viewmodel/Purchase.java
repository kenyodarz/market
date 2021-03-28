package com.bykenyodarz.market.domain.viewmodel;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Purchase {

    private int purchaseId;
    private String ClientId;
    private LocalDateTime date;
    private String paymentMethod;
    private String comment;
    private String state;
    private List<PurchaseItem> items;

}

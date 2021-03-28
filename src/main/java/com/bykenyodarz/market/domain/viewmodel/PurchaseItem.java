package com.bykenyodarz.market.domain.viewmodel;

import lombok.Data;

@Data
public class PurchaseItem {
    private int productId;
    private int quantity;
    private double total;
    private boolean active;

}

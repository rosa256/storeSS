package com.julkamtonosi.storeSS.models;

import java.math.BigDecimal;
import java.util.List;

public class SoppingCart {
    private OrderStatus status;
    private BigDecimal totalPrice;
    private PaymentMethod paymentMethod;
    private List<ProductOrder> productOrders;
}

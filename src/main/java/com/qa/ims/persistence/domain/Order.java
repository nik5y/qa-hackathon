package com.qa.ims.persistence.domain;

public class Order {

    private Long orderId;
    private Long customerId;
    private Long productId;
    private String productName;
    private Double productValue;


    public Order(Long orderId, String productName, Double productValue) {
        this.orderId=orderId;
        this.productName=productName;
        this.productValue=productValue;
    }




}

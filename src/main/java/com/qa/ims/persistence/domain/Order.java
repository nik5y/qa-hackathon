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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductValue() {
        return productValue;
    }

    public void setProductValue(Double productValue) {
        this.productValue = productValue;
    }










}

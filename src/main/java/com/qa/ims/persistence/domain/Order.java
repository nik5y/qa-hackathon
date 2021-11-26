package com.qa.ims.persistence.domain;

public class Order {

    private Long orderId;
    private int customerId;

    public Order(Long orderId, int customerId ) {
        this.setOrderId(orderId);
        this.setCustomerId(customerId);
    }

    public Order(int customerId) {
        this.setCustomerId(customerId);
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }


    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                '}';
    }


}

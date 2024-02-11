package br.com.jtech.springbootapisql.models.enums;

public enum OrderStatus {
    WAITING_PAYMENT(0),
    PAID(1), 
    SHIPPED(2),
    DELIVERED(3),
    CANCELLED(4);

    private int status;

    private OrderStatus() {

    }

    private OrderStatus(int status) {
        this.status = status;
    }

    public Integer getValue() {
        return this.status;
    }

    public static OrderStatus valueOf(int code) {
        for (OrderStatus value : OrderStatus.values()) {
            if (value.getValue() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }
}

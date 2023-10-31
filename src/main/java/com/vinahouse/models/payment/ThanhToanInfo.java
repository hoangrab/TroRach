package com.vinahouse.models.payment;

public class ThanhToanInfo {
    private String orderInfo;
    private String payDate;
    private Long amount;
    private String statusCode;

    public ThanhToanInfo(String orderInfo, String payDate, Long amount, String statusCode) {
        this.orderInfo = orderInfo;
        this.payDate = payDate;
        this.amount = amount;
        this.statusCode = statusCode;
    }

    public ThanhToanInfo() {
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}

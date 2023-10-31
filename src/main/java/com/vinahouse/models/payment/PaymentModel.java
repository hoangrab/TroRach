package com.vinahouse.models.payment;

public class PaymentModel {
    private long sotien;
    private String noidung;

    public PaymentModel(long sotien, String noidung) {
        this.sotien = sotien;
        this.noidung = noidung;
    }

    public PaymentModel() {

    }

    public long getSotien() {
        return sotien;
    }

    public void setSotien(long sotien) {
        this.sotien = sotien;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }
}

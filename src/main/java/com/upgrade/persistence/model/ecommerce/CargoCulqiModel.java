package com.upgrade.persistence.model.ecommerce;

public class CargoCulqiModel {

    public String amount;
    public String currency_code;
    public String email;
    public String source_id;

    public CargoCulqiModel() {
    }


    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSource_id() {
        return source_id;
    }

    public void setSource_id(String source_id) {
        this.source_id = source_id;
    }

    @Override
    public String toString() {
        return "CargoCulqiModel{" +
                "amount='" + amount + '\'' +
                ", currency_code='" + currency_code + '\'' +
                ", email='" + email + '\'' +
                ", source_id='" + source_id + '\'' +
                '}';
    }
}

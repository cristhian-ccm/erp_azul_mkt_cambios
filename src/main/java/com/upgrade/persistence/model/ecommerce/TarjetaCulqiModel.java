package com.upgrade.persistence.model.ecommerce;

public class TarjetaCulqiModel {

    public String card_number;
    public String cvv;
    public String expiration_month;
    public String expiration_year;
    public String email;
    public String titular;

    public TarjetaCulqiModel() {
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExpiration_month() {
        return expiration_month;
    }

    public void setExpiration_month(String expiration_month) {
        this.expiration_month = expiration_month;
    }

    public String getExpiration_year() {
        return expiration_year;
    }

    public void setExpiration_year(String expiration_year) {
        this.expiration_year = expiration_year;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "TarjetaCulqiModel{" +
                "card_number='" + card_number + '\'' +
                ", cvv='" + cvv + '\'' +
                ", expiration_month='" + expiration_month + '\'' +
                ", expiration_year='" + expiration_year + '\'' +
                ", email='" + email + '\'' +
                ", titular='" + titular + '\'' +
                '}';
    }
}

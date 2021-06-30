package com.upgrade.persistence.model.ecommerce;

import java.math.BigDecimal;

public class ProductoEcModel {

    public String id;
    public String cantidad;
    public BigDecimal pventa;
    public BigDecimal total;

    public ProductoEcModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPventa() {
        return pventa;
    }

    public void setPventa(BigDecimal pventa) {
        this.pventa = pventa;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ProductoEcModel{" +
                "id='" + id + '\'' +
                ", cantidad='" + cantidad + '\'' +
                ", pventa=" + pventa +
                '}';
    }
}

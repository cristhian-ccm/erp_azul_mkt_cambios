package com.upgrade.persistence.model.ecommerce;

import java.math.BigDecimal;
import java.util.List;

public class CartUpdate {

    public Integer usuario_old;
    public Integer usuario_new;
    public List<Cart> carts;

    public CartUpdate() {
    }

    public Integer getUsuario_old() {
        return usuario_old;
    }

    public void setUsuario_old(Integer usuario_old) {
        this.usuario_old = usuario_old;
    }

    public Integer getUsuario_new() {
        return usuario_new;
    }

    public void setUsuario_new(Integer usuario_new) {
        this.usuario_new = usuario_new;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }
}

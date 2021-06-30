package com.upgrade.persistence.model.ecommerce;

public class DetalleVentaEcomModel {

    public TarjetaCulqiModel tarjetaCq;
    public CargoCulqiModel cargoCq;

    public DetalleVentaEcomModel() {
    }

    public TarjetaCulqiModel getTarjetaCq() {
        return tarjetaCq;
    }

    public void setTarjetaCq(TarjetaCulqiModel tarjetaCq) {
        this.tarjetaCq = tarjetaCq;
    }

    public CargoCulqiModel getCargoCq() {
        return cargoCq;
    }

    public void setCargoCq(CargoCulqiModel cargoCq) {
        this.cargoCq = cargoCq;
    }
}

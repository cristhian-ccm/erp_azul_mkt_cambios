package com.upgrade.persistence.model.ecommerce;

import com.upgrade.persistence.model.extcs.Producto;

import java.util.Date;
import java.util.List;

public class PostCheckoutModel {

    public String metodoEntrega;
    public ComprobanteModel comprobanteModel;
    public DirEntrega dirEntrega;
    public TarjetaCulqiModel tarjetaCulqiModel;
    public List<ProductoEcModel> productoEcModelList;
    public String tokenTarjeta;
    public String tokenCargo;
    public String precioVentaTotal;
    public String precioDelivery;
    public String precioProductos;
    public Integer usuariow_id;
    public Date fecha_entrega;
    public Cupones cupon;
    public String metodoPago;//tarjeta-deposito
    public Integer direccion_id;

    public PostCheckoutModel() {
    }

    public String getPrecioProductos() {
        return precioProductos;
    }

    public void setPrecioProductos(String precioProductos) {
        this.precioProductos = precioProductos;
    }

    public String getPrecioDelivery() {
        return precioDelivery;
    }

    public void setPrecioDelivery(String precioDelivery) {
        this.precioDelivery = precioDelivery;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public Integer getUsuariow_id() {
        return usuariow_id;
    }

    public void setUsuariow_id(Integer usuariow_id) {
        this.usuariow_id = usuariow_id;
    }

    public String getMetodoEntrega() {
        return metodoEntrega;
    }

    public void setMetodoEntrega(String metodoEntrega) {
        this.metodoEntrega = metodoEntrega;
    }

    public ComprobanteModel getComprobanteModel() {
        return comprobanteModel;
    }

    public void setComprobanteModel(ComprobanteModel comprobanteModel) {
        this.comprobanteModel = comprobanteModel;
    }

    public DirEntrega getDirEntrega() {
        return dirEntrega;
    }

    public void setDirEntrega(DirEntrega dirEntrega) {
        this.dirEntrega = dirEntrega;
    }

    public TarjetaCulqiModel getTarjetaCulqiModel() {
        return tarjetaCulqiModel;
    }

    public void setTarjetaCulqiModel(TarjetaCulqiModel tarjetaCulqiModel) {
        this.tarjetaCulqiModel = tarjetaCulqiModel;
    }

    public List<ProductoEcModel> getProductoEcModelList() {
        return productoEcModelList;
    }

    public void setProductoEcModelList(List<ProductoEcModel> productoEcModelList) {
        this.productoEcModelList = productoEcModelList;
    }

    public String getTokenTarjeta() {
        return tokenTarjeta;
    }

    public void setTokenTarjeta(String tokenTarjeta) {
        this.tokenTarjeta = tokenTarjeta;
    }

    public String getTokenCargo() {
        return tokenCargo;
    }

    public void setTokenCargo(String tokenCargo) {
        this.tokenCargo = tokenCargo;
    }

    public String getPrecioVentaTotal() {
        return precioVentaTotal;
    }

    public void setPrecioVentaTotal(String precioVentaTotal) {
        this.precioVentaTotal = precioVentaTotal;
    }

    public Cupones getCupon() {
        return cupon;
    }

    public void setCupon(Cupones cupon) {
        this.cupon = cupon;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Integer getDireccion_id() {
        return direccion_id;
    }

    public void setDireccion_id(Integer direccion_id) {
        this.direccion_id = direccion_id;
    }

    @Override
    public String toString() {
        return "PostCheckoutModel{" +
                "metodoEntrega='" + metodoEntrega + '\'' +
                ", comprobanteModel=" + comprobanteModel +
                ", dirEntrega=" + dirEntrega +
                ", tarjetaCulqiModel=" + tarjetaCulqiModel +
                ", productoEcModelList=" + productoEcModelList +
                ", tokenTarjeta='" + tokenTarjeta + '\'' +
                ", tokenCargo='" + tokenCargo + '\'' +
                ", precioVentaTotal='" + precioVentaTotal + '\'' +
                ", precioDelivery='" + precioDelivery + '\'' +
                ", precioProductos='" + precioProductos + '\'' +
                ", usuariow_id=" + usuariow_id +
                ", fecha_entrega=" + fecha_entrega +
                ", cupon=" + cupon +
                ", meotodpago=" + metodoPago +
                ", DIRECCION_ID=" + direccion_id +
                '}';
    }
}

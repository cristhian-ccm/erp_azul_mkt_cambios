/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.cmrlz;

import com.upgrade.persistence.model.Moneda;
import com.upgrade.persistence.model.extcs.Almacen;
import com.upgrade.persistence.model.tcros.Direccion;
import com.upgrade.persistence.model.tcros.Persona;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author JCARLOS TIPO
 */
//@TableDB(name	="cmrlz.notas_pedido_det", 
//sequence="cmrlz.notas_pedido_det_id_seq")

@TableDB(name = "cmrlz.cotizacion_ventas_cab" , sequence = "cmrlz.cotizacion_ventas_cab_id_seq")
public class CotizacionVentasCab implements Serializable{
    
    @FieldDB(value = "id")
    public Integer id;
        
    @FieldDB(value = "numero")
    public Integer numero;
    
    @FieldDB(value = "almacen_id")
    public Almacen almacen;
    
    @FieldDB(value = "fecha")
    public Date fecha;
    
    @FieldDB(value = "direccion_cliente_id")
    public Direccion direccionCliente;
    
    @FieldDB(value = "vendedor_id")
    public Persona vendedor;
    
    @FieldDB(value = "moneda_id")
    public Moneda moneda;
    
    @FieldDB(value = "nota_pedido_id")
    public NotaPedidoCab notaPedido;
    
    @FieldDB(value = "total")
    public BigDecimal total;
    
    @FieldDB(value = "observaciones")
    public String observaciones;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Direccion getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(Direccion direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public Persona getVendedor() {
        return vendedor;
    }

    public void setVendedor(Persona vendedor) {
        this.vendedor = vendedor;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public NotaPedidoCab getNotaPedido() {
        return notaPedido;
    }

    public void setNotaPedido(NotaPedidoCab notaPedido) {
        this.notaPedido = notaPedido;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getObservaciones() {
        return observaciones;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CotizacionVentasCab other = (CotizacionVentasCab) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
   

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.extcs;

import com.upgrade.persistence.model.Impuesto;
import com.upgrade.persistence.model.Moneda;
import com.upgrade.persistence.model.Percepcion;
import com.upgrade.persistence.model.emprs.Empresa;
import com.upgrade.persistence.model.tcros.Persona;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author Evander
 */
@TableDB(name	="extcs.productos_det",
sequence="extcs.productos_det_id_seq")
public class ProductoDet implements Serializable {
    
    @FieldDB(value = "creado_por")
    public Persona creadoPor;
    
    @FieldDB(value = "editado_por")
    public Persona editadoPor;
    
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "inactivo")
    public Boolean inactivo;
    
    @FieldDB(value = "producto_id")
    public Producto producto;
    
    @FieldDB(value = "empresa_id")
    public Empresa empresa;
    
    @FieldDB(value = "regalo")
    public Boolean regalo;
    
    @FieldDB(value = "moneda_id")
    public Moneda moneda;
    
    @FieldDB(value = "costo")
    public BigDecimal costo;
    
    @FieldDB(value = "impuesto_id")
    public Impuesto impuesto;
    
    @FieldDB(value = "utilidad")
    public BigDecimal utilidad;
    
    @FieldDB(value = "percepcion_id")
    public Percepcion percepcion;
    
    @FieldDB(value = "garantizable")
    public Boolean garantizable;
    
    @FieldDB(value = "garantia_duracion")
    public Integer garantiaDuracion;
    
    @FieldDB(value = "promocion")
    public Boolean promocion;

    public Persona getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(Persona creadoPor) {
        this.creadoPor = creadoPor;
    }

    public Persona getEditadoPor() {
        return editadoPor;
    }

    public void setEditadoPor(Persona editadoPor) {
        this.editadoPor = editadoPor;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getInactivo() {
        return inactivo;
    }

    public void setInactivo(Boolean inactivo) {
        this.inactivo = inactivo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Boolean getRegalo() {
        return regalo;
    }

    public void setRegalo(Boolean regalo) {
        this.regalo = regalo;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public Impuesto getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Impuesto impuesto) {
        this.impuesto = impuesto;
    }

    public BigDecimal getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(BigDecimal utilidad) {
        this.utilidad = utilidad;
    }

    public Percepcion getPercepcion() {
        return percepcion;
    }

    public void setPercepcion(Percepcion percepcion) {
        this.percepcion = percepcion;
    }

    public Boolean getGarantizable() {
        return garantizable;
    }

    public void setGarantizable(Boolean garantizable) {
        this.garantizable = garantizable;
    }

    public Integer getGarantiaDuracion() {
        return garantiaDuracion;
    }

    public void setGarantiaDuracion(Integer garantiaDuracion) {
        this.garantiaDuracion = garantiaDuracion;
    }

    public Boolean getPromocion() {
        return promocion;
    }

    public void setPromocion(Boolean promocion) {
        this.promocion = promocion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProductoDet other = (ProductoDet) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    } 

    @Override
    public String toString() {
        return producto.codigo;
    }
    
    
    
}

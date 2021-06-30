/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.fnnzs;

import com.upgrade.persistence.model.Moneda;
import com.upgrade.persistence.model.extcs.Almacen;
import com.upgrade.persistence.model.tcros.Persona;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author evander
 */
@TableDB(name = "fnnzs.cheques_cliente_cab", sequence = "fnnzs.cheques_cliente_cab_id_seq")
public class ChequeClienteCab implements Serializable {

    public ChequeClienteCab() {
        //super.tableName = "fnnzs.cheques_cliente_cab";
        //super.sequenceName = "fnnzs.cheques_cliente_cab_id_seq";
    }
    
    @FieldDB(value = "creado_por")
    public Persona creado;
    
    @FieldDB(value = "editado_por")
    public Persona editado;
    
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "banco_id")
    public Banco banco;
    
    @FieldDB(value = "numero")
    public String numero;
    
    @FieldDB(value = "fecha")
    public Date fecha;
    
    @FieldDB(value = "fecha_diferida")
    public Date fecha_diferida;
    
    @FieldDB(value = "moneda_id")
    public Moneda moneda;
    
    @FieldDB(value = "cliente_id")
    public Persona cliente;
    
    @FieldDB(value = "almacen_id")
    public Almacen almacen;

    @FieldDB(value = "total")
    public BigDecimal total;
    
    @FieldDB(value = "aprobado")
    public Boolean aprobado;
    
    @FieldDB(value = "aprobado_por")
    public Persona aprobadoPor;

    public Persona getCreado() {
        return creado;
    }

    public void setCreado(Persona creado) {
        this.creado = creado;
    }

    public Persona getEditado() {
        return editado;
    }

    public void setEditado(Persona editado) {
        this.editado = editado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha_diferida() {
        return fecha_diferida;
    }

    public void setFecha_diferida(Date fecha_diferida) {
        this.fecha_diferida = fecha_diferida;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Boolean getAprobado() {
        return aprobado;
    }

    public void setAprobado(Boolean aprobado) {
        this.aprobado = aprobado;
    }

    public Persona getAprobadoPor() {
        return aprobadoPor;
    }

    public void setAprobadoPor(Persona aprobadoPor) {
        this.aprobadoPor = aprobadoPor;
    }

    
    public String toString() {
        return numero;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final ChequeClienteCab other = (ChequeClienteCab) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
    
    
}

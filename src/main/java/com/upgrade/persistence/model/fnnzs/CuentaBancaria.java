/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.fnnzs;

import com.upgrade.persistence.model.Moneda;
import com.upgrade.persistence.model.emprs.Empresa;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author USER
 */
@TableDB(name = "fnnzs.cuentas_bancarias", sequence = "fnnzs.cuentas_bancarias_id_seq")
public class CuentaBancaria implements Serializable{
    
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "inactivo")
    public Boolean inactivo;
    
    @FieldDB(value = "empresa_id")
    public Empresa empresa;
    
    @FieldDB(value = "banco_id")
    public Banco banco;
    
    @FieldDB(value = "moneda_id")
    public Moneda moneda;
    
    @FieldDB(value = "cuentas_bancarias_tipo_id")
    public CuentaBancariaTipo cuentaBancariaTipo;
    
    @FieldDB(value = "nombre")
    public String nombre;
    
    @FieldDB(value = "codigo")
    public String codigo;
    
    @FieldDB(value = "numero")
    public String numero;

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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public CuentaBancariaTipo getCuentaBancariaTipo() {
        return cuentaBancariaTipo;
    }

    public void setCuentaBancariaTipo(CuentaBancariaTipo cuentaBancariaTipo) {
        this.cuentaBancariaTipo = cuentaBancariaTipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }


    public CuentaBancaria() {
        
        //super.tableName = "fnnzs.cuentas_bancarias";
        //super.sequenceName = "fnnz.cuentas_bancarias_id_seq";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final CuentaBancaria other = (CuentaBancaria) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre + " - [ " + numero + " ]";
    }
    
    
    
}

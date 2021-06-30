/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.ventas;

import com.upgrade.persistence.model.fnnzs.Caja;
import com.upgrade.persistence.model.usros.Usuario;
import ts.com.service.util.db.client.FieldDB;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author evander
 */
public class ArqueoCaja implements Serializable {

    public ArqueoCaja() {
        //super.tableName = "venta.arqueo_caja";
        //super.sequenceName = "venta.arqueo_caja_id_seq";
    }
    
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "caja")
    public Caja caja;
    
    @FieldDB(value = "fecha")
    public Date fecha;
    
    @FieldDB(value = "saldo_inicial")
    public BigDecimal saldoInicial;
    
    @FieldDB(value = "efectivo")
    public BigDecimal efectivo;
    
    @FieldDB(value = "cheque_normal")
    public BigDecimal chequeNormal;
    
    @FieldDB(value = "cheque_diferido")
    public BigDecimal chequeDiferido;
    
    @FieldDB(value = "abono_bancario")
    public BigDecimal abonoBancario;
    
    @FieldDB(value = "deposito")
    public BigDecimal deposito;
    
    @FieldDB(value = "saldo_final")
    public BigDecimal saldoFinal;
    
    @FieldDB(value = "estado")
    public Character estado;
    
    @FieldDB(value = "usuario_creador")
    public Usuario usuarioCreador;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final ArqueoCaja other = (ArqueoCaja) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}

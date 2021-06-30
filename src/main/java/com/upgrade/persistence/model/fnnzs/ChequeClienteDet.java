/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.fnnzs;

import com.upgrade.persistence.model.cmrlz.NotaPedidoCab;
import com.upgrade.persistence.model.cmrlz.VentaCab;
import com.upgrade.persistence.model.tcros.Persona;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author Admin
 */
@TableDB(name = "fnnzs.cheques_cliente_det", sequence = "fnnzs.cheques_cliente_det_id_seq")
public class ChequeClienteDet implements Serializable {
        
    @FieldDB(value = "creado_por")
    public Persona creado;
    
    @FieldDB(value = "editado_por")
    public Persona editado;
    
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "cheque_cliente_id")
    public ChequeClienteCab cheque;
    
    @FieldDB(value = "tipo")
    public String tipo;
    
    @FieldDB(value = "documento_id")
    public Integer documento_id;
    
    @FieldDB(value = "monto")
    public BigDecimal monto;
    
    @FieldDB(value = "monto_documento")
    public BigDecimal monto_documento;
    
    @FieldDB(value = "venta_id")
    public VentaCab venta;
    
    @FieldDB(value = "letra_cliente_id")
    public LetrasClienteDet letra;
    
    @FieldDB(value = "nota_pedido_id")
    public NotaPedidoCab notaPedido;

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

    public ChequeClienteCab getCheque() {
        return cheque;
    }

    public void setCheque(ChequeClienteCab cheque) {
        this.cheque = cheque;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDocumento_id() {
        return documento_id;
    }

    public void setDocumento_id(Integer documento_id) {
        this.documento_id = documento_id;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getMonto_documento() {
        return monto_documento;
    }

    public void setMonto_documento(BigDecimal monto_documento) {
        this.monto_documento = monto_documento;
    }

    public VentaCab getVenta() {
        return venta;
    }

    public void setVenta(VentaCab venta) {
        this.venta = venta;
    }

    public LetrasClienteDet getLetra() {
        return letra;
    }

    public void setLetra(LetrasClienteDet letra) {
        this.letra = letra;
    }

    public NotaPedidoCab getNotaPedido() {
        return notaPedido;
    }

    public void setNotaPedido(NotaPedidoCab notaPedido) {
        this.notaPedido = notaPedido;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final ChequeClienteDet other = (ChequeClienteDet) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}

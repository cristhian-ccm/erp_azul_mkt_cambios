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
 * @author evanl
 */
@TableDB(name = "fnnzs.letras_cliente_documentos",sequence="fnnzs.letras_cliente_documentos_id_seq")
public class LetrasClienteDocumentos implements Serializable{
    
    @FieldDB(value="creado_por")
    public Persona creadoPor;
    
    @FieldDB(value="editado_por")
    public Persona editadPor;
    
    public Integer id;
    
    @FieldDB(value="letra_id")
    public LetrasClienteCab letra;
    
    public Character tipo;
    
    @FieldDB(value="monto_letra")
    public BigDecimal montoLetra;
    
    @FieldDB(value="monto_documento")
    public BigDecimal montoDocumento;
    
    @FieldDB(value="venta_id")
    public VentaCab venta;
    
    @FieldDB(value="nota_pedido_id")
    public NotaPedidoCab notaPedido;

    public Persona getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(Persona creadoPor) {
        this.creadoPor = creadoPor;
    }

    public Persona getEditadPor() {
        return editadPor;
    }

    public void setEditadPor(Persona editadPor) {
        this.editadPor = editadPor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LetrasClienteCab getLetra() {
        return letra;
    }

    public void setLetra(LetrasClienteCab letra) {
        this.letra = letra;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getMontoLetra() {
        return montoLetra;
    }

    public void setMontoLetra(BigDecimal montoLetra) {
        this.montoLetra = montoLetra;
    }

    public BigDecimal getMontoDocumento() {
        return montoDocumento;
    }

    public void setMontoDocumento(BigDecimal montoDocumento) {
        this.montoDocumento = montoDocumento;
    }

    public VentaCab getVenta() {
        return venta;
    }

    public void setVenta(VentaCab venta) {
        this.venta = venta;
    }

    public NotaPedidoCab getNotaPedido() {
        return notaPedido;
    }

    public void setNotaPedido(NotaPedidoCab notaPedido) {
        this.notaPedido = notaPedido;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final LetrasClienteDocumentos other = (LetrasClienteDocumentos) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}

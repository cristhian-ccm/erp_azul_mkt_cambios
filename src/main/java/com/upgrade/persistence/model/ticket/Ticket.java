/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.ticket;

import com.upgrade.persistence.model.cmrlz.NotaPedidoCab;
import com.upgrade.persistence.model.extcs.Almacen;
import com.upgrade.persistence.model.tcros.Direccion;
import com.upgrade.persistence.model.tcros.Persona;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author user
 */
@TableDB(name = "ticket.ticket", sequence = "ticket.ticket_id_seq")
public class Ticket implements  Serializable{

    @FieldDB(value = "id")
    public Integer id;

    @FieldDB(value = "usuario_creador")
    public Persona usuarioCreador;

    @FieldDB(value = "estado")
    public Character estado;
    
    @FieldDB(value = "proyecto")
    public String proyecto;

    @FieldDB(value = "descripcion")
    public String descripcion;

    public Date inicio;

    public Date fin;
    
    @FieldDB(value = "editado_por")
    public Persona editadoPor;
    
    public Almacen almacen;
    public Direccion direccionCliente;
     @FieldDB(value = "nota_pedido_id")
    public NotaPedidoCab notaPedidoId;

   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Ticket other = (Ticket) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    

    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.ticket;

import com.upgrade.persistence.model.tcros.Persona;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author upgrade
 */
@TableDB(name = "ticket.ticket_encargado",sequence = "ticket.ticket_encargado_id_seq")
public class TicketEncargados implements Serializable{
    
    public Integer id;
    @FieldDB(value = "ticket_id")
    public Ticket ticket;
    @FieldDB(value = "encargado_id")
    public Persona persona;
    public Boolean encargado;

    

    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final TicketEncargados other = (TicketEncargados) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
    

    
}

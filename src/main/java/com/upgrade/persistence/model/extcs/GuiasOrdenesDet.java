/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.extcs;

import com.upgrade.persistence.model.cmrlz.NotaPedidoDet;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Evander
 */
@TableDB(name	="extcs.guias_ordenes_det", sequence="extcs.guias_ordenes_det_id_seq")
public class GuiasOrdenesDet implements Serializable { 

    public Integer id;
    
    @FieldDB(value = "guia_det_id")
    public GuiaDet guiaDet;
    @FieldDB(value = "nota_pedido_det_id")
    public NotaPedidoDet notaPedidoDet;
    public BigDecimal cantidad;
    
    
    public GuiasOrdenesDet() {
        //super.tableName = "extcs.guias_ordenes_det";
        //super.sequenceName = "extcs.guias_ordenes_det_id_seq";
    }
    
    
    
}

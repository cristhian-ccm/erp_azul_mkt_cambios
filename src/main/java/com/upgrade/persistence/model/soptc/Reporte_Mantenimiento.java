/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.soptc;

import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;

/**
 *
 * @author evander
 */
@TableDB(name = "soptc.reporte_mantenimiento",sequence = "soptc.reporte_mantenimiento_id_seq")
public class Reporte_Mantenimiento implements Serializable {
    
    public Integer id;
    public ReporteServicioTecnico reporte;
    public Mantenimiento mantenimiento;
    
    public Reporte_Mantenimiento() {
    }
    
    
}

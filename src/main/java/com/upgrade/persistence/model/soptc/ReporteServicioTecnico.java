/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.soptc;

import com.upgrade.persistence.model.cmrlz.NotaPedidoCab;
import com.upgrade.persistence.model.extcs.Almacen;
import com.upgrade.persistence.model.extcs.Articulo;
import com.upgrade.persistence.model.tcros.Direccion;
import com.upgrade.persistence.model.tcros.Persona;
import com.upgrade.persistence.model.usros.Usuario;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author evander
 */
@TableDB(name = "soptc.reporte_serviciotecnico",sequence = "soptc.reporte_serviciotecnico_id_seq")
public class ReporteServicioTecnico implements Serializable {
    
    public Integer id;
    @FieldDB(value = "usuariocreador")
    
    public Usuario usuarioCreador;
    public Character estado;
    public Almacen almacen;
    public Integer serie;
    public Integer numero;
    public Date fecha;
    public Character tipoMantenimiento;
    public Boolean articuloNuestro;
    public Articulo articulo;
    public String articuloParticular;
    public String deja;
    public Direccion direccionCliente;
    public Date horaInicio;
    public Date horaEstimada;
    public Date horaFin;
    public Persona encargado;
    public String falla;
    public SistemaOperativo sistemaOperativo;
    public String pruebasResultados;
    
    @FieldDB(value = "nota_pedido_id")
    public NotaPedidoCab notaPedidoId;
    
    public ReporteServicioTecnico() {
    }
    
}

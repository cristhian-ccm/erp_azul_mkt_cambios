/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.auxiliar;

import com.upgrade.persistence.model.cmrlz.NotaPedidoCab;
import com.upgrade.persistence.model.extcs.Almacen;
import com.upgrade.persistence.model.extcs.Articulo;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class DetallesSalidaArticuloModel {
    public NotaPedidoCab notaPedido;
    public Articulo articulo;
    public Almacen almacen;  
    public Date fechaDescarga;
}

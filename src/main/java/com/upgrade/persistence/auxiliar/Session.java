package com.upgrade.persistence.auxiliar;

import com.upgrade.persistence.model.emprs.Empresa;
import com.upgrade.persistence.model.emprs.Sucursal;
import com.upgrade.persistence.model.extcs.Almacen;
import com.upgrade.persistence.model.fnnzs.Caja;
import com.upgrade.persistence.model.usros.Permiso;
import com.upgrade.persistence.model.usros.Rol;
import com.upgrade.persistence.model.usros.RolPermiso;
import com.upgrade.persistence.model.usros.Usuario;
import com.upgrade.persistence.model.usros.UsuarioRol;
import java.io.Serializable;
import java.util.List;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Session implements Serializable {
	
    public Empresa empresa;
    public Sucursal sucursal;
    public Almacen almacen;
    public Usuario usuario;
    public List<Almacen> almacenes;
    public List<Caja> caja;
    public List<Empresa> empresas;
    public List<Rol> roles;
    public List<Permiso> permisos;
    public List<UsuarioRol> usuarioRol;
    public List<RolPermiso> rolPermiso;
    //private List<Rol> roles;
    //private List<Permiso> permisos;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public List<Caja> getCaja() {
        return caja;
    }

    public void setCaja(List<Caja> caja) {
        this.caja = caja;
    }
    
    public List<Almacen> getAlmacenes() {
        return almacenes;
    }

    public void setAlmacenes(List<Almacen> almacenes) {
        this.almacenes = almacenes;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public List<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<Permiso> permisos) {
        this.permisos = permisos;
    }

    public List<UsuarioRol> getUsuarioRol() {
        return usuarioRol;
    }

    public void setUsuarioRol(List<UsuarioRol> usuarioRol) {
        this.usuarioRol = usuarioRol;
    }

    public List<RolPermiso> getRolPermiso() {
        return rolPermiso;
    }

    public void setRolPermiso(List<RolPermiso> rolPermiso) {
        this.rolPermiso = rolPermiso;
    }
}

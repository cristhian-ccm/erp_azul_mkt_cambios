/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.fnnzs;

import com.upgrade.persistence.model.tcros.Persona;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Admin
 */
@TableDB(name = "fnnzs.bancos_movimientos", sequence = "fnnzs.bancos_movimientos_id_seq")
public class BancosMovimiento implements Serializable{
    
    @FieldDB(value = "creado_por")
    public Persona creadoPor;
    
    @FieldDB(value = "editado_por")
    public Persona editadoPor;
    
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "anulada")
    public Boolean anulada;
    
    @FieldDB(value = "cuenta_bancaria_id")
    public CuentaBancaria cuentaBancaria;
    
    @FieldDB(value = "fecha")
    public Date fecha;
    
    @FieldDB(value = "operacion")
    public String operacion;
    
    @FieldDB(value = "observaciones")
    public String observaciones;
    
    @FieldDB(value = "monto")
    public BigDecimal monto;
    
    @FieldDB(value = "monto_entrada")
    public BigDecimal montoEntrada;
    
    @FieldDB(value = "monto_salida")
    public BigDecimal montoSalida;
    
    @FieldDB(value = "concepto_tipo_id")
    public RecibosDetTipos conceptoTipo;
    
    @FieldDB(value = "concepto_id")
    public Integer conceptoId;
    
    @FieldDB(value = "concepto")
    public String concepto;
    
    @FieldDB(value = "monto_usado")
    public BigDecimal montoUsado;
    
    @FieldDB(value = "fecha_aprobado")
    public Date fechaAprobado;
    
    @FieldDB(value = "aprobado_por_id")
    public Persona aprobadoPor;
    
    @FieldDB(value = "tr_caja_destino_id")
    public Caja trCajaDestino;
    
    @FieldDB(value = "tr_cuenta_bancaria_destino_id")
    public CuentaBancaria trCuentaBancariaDestino;
    
    @FieldDB(value = "cuenta_bancaria_proveedor_id")
    public CuentaBancariaTerceros cuentaBancariaProveedor;
    
    @FieldDB(value = "cliente_id")
    public Persona cliente;
    
    @FieldDB(value = "ch_fecha_diferido")
    public Date chFechaDiferido;
    
    @FieldDB(value = "ch_fecha_cobro")
    public Date chFechaCobro;
    
    @FieldDB(value = "ch_pagar_a")
    public String chPagar_a;
    
    @FieldDB(value = "ch_numero")
    public String chNumero;
    
    @FieldDB(value = "tr_monto")
    public BigDecimal trMonto;
    
    @FieldDB(value = "proveedor_id")
    public Persona proveedor;
    
    @FieldDB(value = "prestamo_det_id")
    public PrestamosDet prestamoDet;
    
    @FieldDB(value = "banco_id")
    public Banco banco;

    public Persona getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(Persona creadoPor) {
        this.creadoPor = creadoPor;
    }

    public Persona getEditadoPor() {
        return editadoPor;
    }

    public void setEditadoPor(Persona editadoPor) {
        this.editadoPor = editadoPor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getAnulada() {
        return anulada;
    }

    public void setAnulada(Boolean anulada) {
        this.anulada = anulada;
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getMontoEntrada() {
        return montoEntrada;
    }

    public void setMontoEntrada(BigDecimal montoEntrada) {
        this.montoEntrada = montoEntrada;
    }

    public BigDecimal getMontoSalida() {
        return montoSalida;
    }

    public void setMontoSalida(BigDecimal montoSalida) {
        this.montoSalida = montoSalida;
    }

    public RecibosDetTipos getConceptoTipo() {
        return conceptoTipo;
    }

    public void setConceptoTipo(RecibosDetTipos conceptoTipo) {
        this.conceptoTipo = conceptoTipo;
    }

    public Integer getConceptoId() {
        return conceptoId;
    }

    public void setConceptoId(Integer conceptoId) {
        this.conceptoId = conceptoId;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public BigDecimal getMontoUsado() {
        return montoUsado;
    }

    public void setMontoUsado(BigDecimal montoUsado) {
        this.montoUsado = montoUsado;
    }

    public Date getFechaAprobado() {
        return fechaAprobado;
    }

    public void setFechaAprobado(Date fechaAprobado) {
        this.fechaAprobado = fechaAprobado;
    }

    public Persona getAprobadoPor() {
        return aprobadoPor;
    }

    public void setAprobadoPor(Persona aprobadoPor) {
        this.aprobadoPor = aprobadoPor;
    }

    public Caja gettCajaDestino() {
        return trCajaDestino;
    }

    public void settCajaDestino(Caja trCajaDestino) {
        this.trCajaDestino = trCajaDestino;
    }

    public CuentaBancaria getTrCuentaBancariaDestino() {
        return trCuentaBancariaDestino;
    }

    public void setTrCuentaBancariaDestino(CuentaBancaria trCuentaBancariaDestino) {
        this.trCuentaBancariaDestino = trCuentaBancariaDestino;
    }

    public CuentaBancariaTerceros getCuentaBancariaProveedor() {
        return cuentaBancariaProveedor;
    }

    public void setCuentaBancariaProveedor(CuentaBancariaTerceros cuentaBancariaProveedor) {
        this.cuentaBancariaProveedor = cuentaBancariaProveedor;
    }

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

    public Date getChFechaDiferido() {
        return chFechaDiferido;
    }

    public void setChFechaDiferido(Date chFechaDiferido) {
        this.chFechaDiferido = chFechaDiferido;
    }

    public Date getChFechaCobro() {
        return chFechaCobro;
    }

    public void setChFechaCobro(Date chFechaCobro) {
        this.chFechaCobro = chFechaCobro;
    }

    public String getChPagar_a() {
        return chPagar_a;
    }

    public void setChPagar_a(String chPagar_a) {
        this.chPagar_a = chPagar_a;
    }

    public String getChNumero() {
        return chNumero;
    }

    public void setChNumero(String chNumero) {
        this.chNumero = chNumero;
    }

    public BigDecimal getTrMonto() {
        return trMonto;
    }

    public void setTrMonto(BigDecimal trMonto) {
        this.trMonto = trMonto;
    }

    public Persona getProveedor() {
        return proveedor;
    }

    public void setProveedor(Persona proveedor) {
        this.proveedor = proveedor;
    }

    public PrestamosDet getPrestamoDet() {
        return prestamoDet;
    }

    public void setPrestamoDet(PrestamosDet prestamoDet) {
        this.prestamoDet = prestamoDet;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final BancosMovimiento other = (BancosMovimiento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}

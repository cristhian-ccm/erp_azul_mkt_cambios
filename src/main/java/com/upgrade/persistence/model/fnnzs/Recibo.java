/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.fnnzs;

import com.upgrade.persistence.model.Moneda;
import com.upgrade.persistence.model.cmrlz.NotaPedidoCab;
import com.upgrade.persistence.model.cmrlz.VentaCab;
import com.upgrade.persistence.model.lgstc.OrdenCompraCab;
import com.upgrade.persistence.model.tcros.Persona;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author USER
 */
@TableDB(name="fnnzs.", sequence="fnnzs._id_seq")
public class Recibo implements Serializable {

    public Recibo() {
        //super.tableName = "fnnzs.";
        //super.sequenceName = "fnnzs._id_seq";
    }
    
    @FieldDB(value = "id")
    public Integer id;
    /*
    @FieldDB(value = "creado")
    @DefaultDB(value = true)
    public Date creado;*/
    
    @FieldDB(value = "creado_por")
    public Persona creado;
    
    @FieldDB(value = "anulada")
    public Boolean anulada;
    
    @FieldDB(value = "caja_id")
    public Caja caja;
    
    @FieldDB(value = "numero")
    public Integer numero;
    
    @FieldDB(value = "fecha")
    public Date fecha;
    
    @FieldDB(value = "destino_cobro_id")
    public Integer destinoCobro;
    
    @FieldDB(value = "moneda_id")
    public Moneda moneda;
    
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
    
    @FieldDB(value = "monto_concepto")
    public BigDecimal montoConcepto;
    
    @FieldDB(value = "paga_con")
    public BigDecimal pagaCon;
    
    @FieldDB(value = "vuelto")
    public BigDecimal vuelto;
    
    @FieldDB(value = "nota_pedido_id")
    public NotaPedidoCab notaPedido;
    
    @FieldDB(value = "venta_id")
    public VentaCab venta;
    
    @FieldDB(value = "tr_caja_destino_id")
    public Caja trCajaDestino;
    
    @FieldDB(value = "tr_fecha_aprobado")
    public Date trFechaAprobado;
    
    @FieldDB(value = "tr_aprobado_por_id")
    public Persona aprobadoPor;
    
    @FieldDB(value = "letra_id")
    public LetrasClienteDet letra;
    
    @FieldDB(value = "deposito_cliente_id")
    public DepositosCliente depositoCliente;
    
    @FieldDB(value = "tr_cuenta_destino_id")
    public CuentaBancaria cuentaDestino;
    
    @FieldDB(value = "moneda_compra_id")
    public Moneda monedaCompra;
    
    @FieldDB(value = "cheque_cliente_id")
    public ChequeClienteCab chequeCliente;
    
    @FieldDB(value = "tarjeta_id")
    public Tarjeta tarjeta;
    
    @FieldDB(value = "nro_operacion")
    public String numeroOperacion;
    
    @FieldDB(value = "tarjeta_porcentaje")
    public BigDecimal tarjetaPorcentaje;
    
    @FieldDB(value = "observaciones")
    public String Observaciones;
    
    @FieldDB(value = "empleado_id")
    public Persona empleado;
    
    @FieldDB(value = "deposito_proveedor_id")
    public Integer depositoProveedor;  //Revisar
    
    @FieldDB(value = "deposito_proveedor_monto_usado")
    public BigDecimal depositoProveedorMontoUsado;
    
    @FieldDB(value = "salida")
    public Boolean salida;
    
    @FieldDB(value = "prestamo_det_id")
    public PrestamosDet prestamoDet;
    
    @FieldDB(value = "compra_id")
    public OrdenCompraCab compra;
    
    @FieldDB(value = "nro_operacion_ingresada")
    public String numeroOperacionIngresada;
    
    @FieldDB(value = "banco_id")
    public Integer bancoId;   //Revisar

//    @FieldDB(value = "cambio")
//    public BigDecimal cambio;
    
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

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getDestinoCobro() {
        return destinoCobro;
    }

    public void setDestinoCobro(Integer destinoCobro) {
        this.destinoCobro = destinoCobro;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
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

    public BigDecimal getMontoConcepto() {
        return montoConcepto;
    }

    public void setMontoConcepto(BigDecimal montoConcepto) {
        this.montoConcepto = montoConcepto;
    }

    public BigDecimal getPagaCon() {
        return pagaCon;
    }

    public void setPagaCon(BigDecimal pagaCon) {
        this.pagaCon = pagaCon;
    }

    public BigDecimal getVuelto() {
        return vuelto;
    }

    public void setVuelto(BigDecimal vuelto) {
        this.vuelto = vuelto;
    }

    public NotaPedidoCab getNotaPedido() {
        return notaPedido;
    }

    public void setNotaPedido(NotaPedidoCab notaPedido) {
        this.notaPedido = notaPedido;
    }

    public VentaCab getVenta() {
        return venta;
    }

    public void setVenta(VentaCab venta) {
        this.venta = venta;
    }

    public Persona getCreado() {
        return creado;
    }

    public void setCreado(Persona creado) {
        this.creado = creado;
    }

    public Caja getTrCajaDestino() {
        return trCajaDestino;
    }

    public void setTrCajaDestino(Caja trCajaDestino) {
        this.trCajaDestino = trCajaDestino;
    }

    public Boolean getSalida() {
        return salida;
    }

    public void setSalida(Boolean salida) {
        this.salida = salida;
    }

    public Date getTrFechaAprobado() {
        return trFechaAprobado;
    }

    public void setTrFechaAprobado(Date trFechaAprobado) {
        this.trFechaAprobado = trFechaAprobado;
    }

    public Persona getAprobadoPor() {
        return aprobadoPor;
    }

    public void setAprobadoPor(Persona aprobadoPor) {
        this.aprobadoPor = aprobadoPor;
    }

    public LetrasClienteDet getLetra() {
        return letra;
    }

    public void setLetra(LetrasClienteDet letra) {
        this.letra = letra;
    }

    public DepositosCliente getDepositoCliente() {
        return depositoCliente;
    }

    public void setDepositoCliente(DepositosCliente depositoCliente) {
        this.depositoCliente = depositoCliente;
    }
    
    public CuentaBancaria getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(CuentaBancaria cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }
    
    public Moneda getMonedaCompra() {
        return monedaCompra;
    }

    public void setMonedaCompra(Moneda monedaCompra) {
        this.monedaCompra = monedaCompra;
    }

    public ChequeClienteCab getChequeCliente() {
        return chequeCliente;
    }

    public void setChequeCliente(ChequeClienteCab chequeCliente) {
        this.chequeCliente = chequeCliente;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getNumeroOperacion() {
        return numeroOperacion;
    }

    public void setNumeroOperacion(String numeroOperacion) {
        this.numeroOperacion = numeroOperacion;
    }

    public BigDecimal getTarjetaPorcentaje() {
        return tarjetaPorcentaje;
    }

    public void setTarjetaPorcentaje(BigDecimal tarjetaPorcentaje) {
        this.tarjetaPorcentaje = tarjetaPorcentaje;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public Persona getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Persona empleado) {
        this.empleado = empleado;
    }

    public Integer getDepositoProveedor() {
        return depositoProveedor;
    }

    public void setDepositoProveedor(Integer depositoProveedor) {
        this.depositoProveedor = depositoProveedor;
    }

    public BigDecimal getDepositoProveedorMontoUsado() {
        return depositoProveedorMontoUsado;
    }

    public void setDepositoProveedorMontoUsado(BigDecimal depositoProveedorMontoUsado) {
        this.depositoProveedorMontoUsado = depositoProveedorMontoUsado;
    }

    public boolean isSalida() {
        return salida;
    }

    public void setSalida(boolean salida) {
        this.salida = salida;
    }

    public PrestamosDet getPrestamoDet() {
        return prestamoDet;
    }

    public void setPrestamoDet(PrestamosDet prestamoDet) {
        this.prestamoDet = prestamoDet;
    }
    
    public OrdenCompraCab getCompra() {
        return compra;
    }

    public void setCompra(OrdenCompraCab compra) {
        this.compra = compra;
    }

    public String getNumeroOperacionIngresada() {
        return numeroOperacionIngresada;
    }

    public void setNumeroOperacionIngresada(String numeroOperacionIngresada) {
        this.numeroOperacionIngresada = numeroOperacionIngresada;
    }

    public Integer getBancoId() {
        return bancoId;
    }

    public void setBancoId(Integer bancoId) {
        this.bancoId = bancoId;
    }
    
    public String getNombreAnulado()
    {
        return this.anulada?"ANULADO":"ACTIVO";
    }
    
    public String getNumeroOrdenVenta()
    {
        if (this.notaPedido != null)
            return String.valueOf(this.notaPedido.getNumero());
        else
            return "0";
    }
    
    public String getTotalOrdenVenta()
    {
        if(this.notaPedido != null)
            return String.valueOf(this.notaPedido.getTotal());
        else
            return "0";
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Recibo other = (Recibo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
     
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.cmrlz;

import com.upgrade.persistence.model.FormaPago;
import com.upgrade.persistence.model.Moneda;
import com.upgrade.persistence.model.PreventaTipo;
import com.upgrade.persistence.model.ecommerce.Cupones;
import com.upgrade.persistence.model.ecommerce.DocPago;
import com.upgrade.persistence.model.extcs.Almacen;
import com.upgrade.persistence.model.tcros.Direccion;
import com.upgrade.persistence.model.tcros.Persona;
import com.upgrade.persistence.model.unidad_negocio.UnidadNegocio;
import com.upgrade.persistence.model.ecommerce.DirEntrega;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author USER
 */
@TableDB(name = "cmrlz.notas_pedido_cab", sequence = "cmrlz.notas_pedido_cab_id_seq")
public class NotaPedidoCab implements Serializable {

    @FieldDB(value = "creado")
    public Date crea;

    @FieldDB(value = "creado_por")
    public Persona creado;

    @FieldDB(value = "id")
    public Integer id;

    @FieldDB(value = "editado")
    public Date editado;

    @FieldDB(value = "editado_por")
    public Persona editadoPor;

    @FieldDB(value = "numero")
    public Integer numero;

    @FieldDB(value = "fecha")
    public Date fecha;

    @FieldDB(value = "anulada")
    public Boolean anulada;

    @FieldDB(value = "direccion_cliente_id")
    public Direccion direccionCliente;

    @FieldDB(value = "vendedor_id")
    public Persona vendedor;

    @FieldDB(value = "moneda_id")
    public Moneda moneda;

    @FieldDB(value = "preventa_tipo_id")
    public PreventaTipo preventaTipo;

    @FieldDB(value = "cerrada")
    public Boolean cerrada;

    @FieldDB(value = "aprobada")//aprueba la utilidad
    public Boolean aprobada;

    @FieldDB(value = "forma_pago_id")
    public FormaPago formaPago;

    @FieldDB(value = "almacen_id")
    public Almacen almacen;

    @FieldDB(value = "observaciones")
    public String observaciones;

    @FieldDB(value = "fecha_entrega")
    public Date fechaEntrega;

    @FieldDB(value = "venta_id")
    public VentaCab venta;

    @FieldDB(value = "aprobado_sin_adelanto")
    public Boolean aprobadoSinAdelanto;

    @FieldDB(value = "aprobado_sin_adelanto_por_id")   //Creo q este no debe ir
    public Integer aprobadoSinAdelantoPorId;

    @FieldDB(value = "total_minimo")
    public BigDecimal totalMinimo;

    @FieldDB(value = "total")
    public BigDecimal total;

    @FieldDB(value = "monto_adelanto")
    public BigDecimal montoAdelanto;

    @FieldDB(value = "utilidad_minima")
    public BigDecimal utilidadMinima;

    @FieldDB(value = "comision")
    public Boolean comision;

    @FieldDB(value = "comision_monto_usado")
    public BigDecimal comisionMontoUsado;

    @FieldDB(value = "total_sin_comision")
    public BigDecimal totalSinComision;

    @FieldDB(value = "dias_credito")
    public Integer diasCredito;

    @FieldDB(value = "aprobado_en")
    public Date aprobadoEn;

    @FieldDB(value = "aprobacion_comentario")
    public String aprobacionComentario;

    @FieldDB(value = "almacen_entrega_id")
    public Almacen almacenEntrega;
    // public Integer almacenEntrega;

    @FieldDB(value = "total_real")
    public BigDecimal totalReal;

    @FieldDB(value = "de_comision")
    public Boolean deComision;

    @FieldDB(value = "aprobado_credito")
    public Boolean aprobadoCredito;//campo donde se aprueba credito

    @FieldDB(value = "aprobado_credito_comentario")
    public String aprobadoCreditoComentario;

    @FieldDB(value = "aprobado_credito_aprobador")
    public Integer aprobadoCreditoAprobador;

    @FieldDB(value = "cotizacion_id")
    public CotizacionVentasCab cotizacion;

    @FieldDB(value = "aprobador_utilidad")
    public Persona aprobadorUtilidad;

    @FieldDB(value = "fecha_aprobacion_utilidad")
    public Date fechaAprobacionUtilidad;

    @FieldDB(value = "unidad_negocio_id")
    public UnidadNegocio unidadNegocioId;

    @FieldDB(value = "vendedor_atendedor")
    public Persona vendedorAtendedor;

    @FieldDB(value = "descargado")
    public Boolean descargado;

    @FieldDB(value = "comision_terceros")
    public BigDecimal comisionTerceros;

    @FieldDB(value = "orden_compra_cliente")
    public String ordenCompraCliente;

    @FieldDB(value = "edit_detalles")
    public Persona personaEditDetalles;

    @FieldDB(value = "nota_pedido_comision_id")
    public NotaPedidoCab notaPedidoComision;

    @FieldDB(value = "es_comision")
    public Boolean esComision;

    @FieldDB(value = "es_gasto_operativo")
    public Boolean esGastoOperativo;

    @FieldDB(value = "gastos_operativos")
    public BigDecimal gastosOperativos;

    @FieldDB(value = "descripcion_gastos")
    public String descripcionGastos;
	
    @FieldDB(value = "direccion_ecommerce_id")
    public DirEntrega direccion_Ecommerce;

    @FieldDB(value = "estado_actual")
    public String estado_actual;
    
    @FieldDB(value = "tipo_entrega")
    public String tipo_entrega;
    
    @FieldDB(value = "cupon_id")
    public Cupones cupon;
    
    @FieldDB(value = "token_tarjeta")
    public String token_tarjeta;
    
    @FieldDB(value = "token_cargo")
    public String token_cargo;

    @FieldDB(value = "doc_pago_id")
    public DocPago doc_pago_id;
    
    public Persona getCreado() {
        return creado;
    }

    public void setCreado(Persona creado) {
        this.creado = creado;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Boolean getAnulada() {
        return anulada;
    }

    public Date getAprobadoEn() {
        return aprobadoEn;
    }

    public void setAprobadoEn(Date aprobadoEn) {
        this.aprobadoEn = aprobadoEn;
    }

    public void setAnulada(Boolean anulada) {
        this.anulada = anulada;
    }

    public Direccion getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(Direccion direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public Persona getVendedor() {
        return vendedor;
    }

    public void setVendedor(Persona vendedor) {
        this.vendedor = vendedor;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public PreventaTipo getPreventaTipo() {
        return preventaTipo;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public void setPreventaTipo(PreventaTipo preventaTipo) {
        this.preventaTipo = preventaTipo;
    }

    public Boolean getCerrada() {
        return cerrada;
    }

    public void setCerrada(Boolean cerrada) {
        this.cerrada = cerrada;
    }

    public Boolean getAprobada() {
        return aprobada;
    }

    public void setAprobada(Boolean aprobada) {
        this.aprobada = aprobada;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public VentaCab getVenta() {
        return venta;
    }

    public void setVenta(VentaCab venta) {
        this.venta = venta;
    }

    public Boolean getAprobadoSinAdelanto() {
        return aprobadoSinAdelanto;
    }

    public void setAprobadoSinAdelanto(Boolean aprobadoSinAdelanto) {
        this.aprobadoSinAdelanto = aprobadoSinAdelanto;
    }

    public Integer getAprobadoSinAdelantoPorId() {
        return aprobadoSinAdelantoPorId;
    }

    public void setAprobadoSinAdelantoPorId(Integer aprobadoSinAdelantoPorId) {
        this.aprobadoSinAdelantoPorId = aprobadoSinAdelantoPorId;
    }

    public BigDecimal getTotalMinimo() {
        return totalMinimo;
    }

    public void setTotalMinimo(BigDecimal totalMinimo) {
        this.totalMinimo = totalMinimo;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getMontoAdelanto() {
        return montoAdelanto;
    }

    public void setMontoAdelanto(BigDecimal montoAdelantado) {
        this.montoAdelanto = montoAdelantado;
    }

    public BigDecimal getUtilidadMinima() {
        return utilidadMinima;
    }

    public void setUtilidadMinima(BigDecimal utilidadMinima) {
        this.utilidadMinima = utilidadMinima;
    }

    public Boolean getComision() {
        return comision;
    }

    public void setComision(Boolean comision) {
        this.comision = comision;
    }

    public BigDecimal getComisionMontoUsado() {
        return comisionMontoUsado;
    }

    public void setComisionMontoUsado(BigDecimal comisionMontoUsado) {
        this.comisionMontoUsado = comisionMontoUsado;
    }

    public BigDecimal getTotalSinComision() {
        return totalSinComision;
    }

    public void setTotalSinComision(BigDecimal totalSinComision) {
        this.totalSinComision = totalSinComision;
    }

    public Integer getDiasCredito() {
        return diasCredito;
    }

    public void setDiasCredito(Integer diasCredito) {
        this.diasCredito = diasCredito;
    }

    public String getAprobacionComentario() {
        return aprobacionComentario;
    }

    public void setAprobacionComentario(String aprobacionComentario) {
        this.aprobacionComentario = aprobacionComentario;
    }

    public Almacen getAlmacenEntrega() {
        return almacenEntrega;
    }

    public void setAlmacenEntrega(Almacen almacenEntrega) {
        this.almacenEntrega = almacenEntrega;
    }

    public BigDecimal getTotalReal() {
        return totalReal;
    }

    public void setTotalReal(BigDecimal totalReal) {
        this.totalReal = totalReal;
    }

    public Boolean getDeComision() {
        return deComision;
    }

    public void setDeComision(Boolean deComision) {
        this.deComision = deComision;
    }

    public Boolean getAprobadoCredito() {
        return aprobadoCredito;
    }

    public void setAprobadoCredito(Boolean aprobadoCredito) {
        this.aprobadoCredito = aprobadoCredito;
    }

    public String getAprobadoCreditoComentario() {
        return aprobadoCreditoComentario;
    }

    public void setAprobadoCreditoComentario(String aprobadoCreditoComentario) {
        this.aprobadoCreditoComentario = aprobadoCreditoComentario;
    }

    public Integer getAprobadoCreditoAprobador() {
        return aprobadoCreditoAprobador;
    }

    public void setAprobadoCreditoAprobador(Integer aprobadoCreditoAprobador) {
        this.aprobadoCreditoAprobador = aprobadoCreditoAprobador;
    }

    public CotizacionVentasCab getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(CotizacionVentasCab cotizacion) {
        this.cotizacion = cotizacion;
    }

    public Persona getAprobadorUtilidad() {
        return aprobadorUtilidad;
    }

    public void setAprobadorUtilidad(Persona aprobadorUtilidad) {
        this.aprobadorUtilidad = aprobadorUtilidad;
    }

    public Date getFechaAprobacionUtilidad() {
        return fechaAprobacionUtilidad;
    }

    public void setFechaAprobacionUtilidad(Date fechaAprobacionUtilidad) {
        this.fechaAprobacionUtilidad = fechaAprobacionUtilidad;
    }

    public UnidadNegocio getUnidadNegocioId() {
        return unidadNegocioId;
    }

    public void setUnidadNegocioId(UnidadNegocio unidadNegocioId) {
        this.unidadNegocioId = unidadNegocioId;
    }

    public Persona getVendedorAtendedor() {
        return vendedorAtendedor;
    }

    public void setVendedorAtendedor(Persona vendedorAtendedor) {
        this.vendedorAtendedor = vendedorAtendedor;
    }

    public Date getEditado() {
        return editado;
    }

    public void setEditado(Date editado) {
        this.editado = editado;
    }

    public Persona getEditadoPor() {
        return editadoPor;
    }

    public void setEditadoPor(Persona editadoPor) {
        this.editadoPor = editadoPor;
    }

    public DirEntrega getDireccion_Ecommerce() {
        return direccion_Ecommerce;
    }

    public void setDireccion_Ecommerce(DirEntrega direccion_Ecommerce) {
        this.direccion_Ecommerce = direccion_Ecommerce;
    }
    
    public String getTipo_Entrega() {
        return tipo_entrega;
    }

    public void setTipo_Entrega(String tipo_entrega) {
        this.tipo_entrega = tipo_entrega;
    }
    
    public String getEstado_actual() {
        return estado_actual;
    }

    public void setEstado_actual(String estado_actual) {
        this.estado_actual = estado_actual;
    }
    
    public Cupones getCupon() {
        return cupon;
    }

    public void setCupon(Cupones cupon) {
        this.cupon = cupon;
    }
    
    /*public String getNombreCortoDocumentoTipo()
    {
        return documentoTipo.getNombreCorto();
    }*/
    
    public int getIdAlmacen()
    {
        return almacen.getId();
    }
        
    public String getNumeroDocumentoPersona()
    {
        return this.direccionCliente.getPersona().getIdentificador();
    }
    
    public String getRazonSocial()
    {
        return this.direccionCliente.getPersona().getNombre();
    }

        
    public String getNombreFormaPago()
    {
        return this.formaPago.getNombre();
    }

    public String getTieneComprobante()
    {
        
        return this.venta != null? this.venta.getDocumentoTipo().getNombreCorto().substring(0,1)+getSerie(String.valueOf(this.venta.getSerie()))+"-"+String.valueOf(this.venta.getNumero()):"NO GENERADO";
        //return this.venta != null?"GENERADO":"NO GENERADO";
        
    }
    
    public String getTokenTarjeta()
    {
        return this.token_tarjeta;
    }
    
    public void setTokenTarjeta(String token_tarjeta)
    {
        this.token_tarjeta = token_tarjeta;
    }

    public DocPago getDoc_pago_id() {
        return doc_pago_id;
    }

    public void setDoc_pago_id(DocPago doc_pago_id) {
        this.doc_pago_id = doc_pago_id;
    }

    public String getSerie(String serie)
    {
        int longitud = 3-serie.length();
        for(int i=0; i<longitud; i++)
        {
            serie = "0"+serie;
        }
        
        return serie;
    }
        
   /* @Override
    public String toString() {
        return "NotaPedidoCab{" +
                "id=" + id +
                ", numero=" + numero +
                ", fecha=" + fecha +
                ", fechaEntrega=" + fechaEntrega +
                '}';
    }*/

    @Override
    public String toString() {
        return "NotaPedidoCab{" +
                "id=" + id +
                ", numero=" + numero +
                ", fecha=" + fecha +
                ", fechaEntrega=" + fechaEntrega +
                ", total=" + total +
                '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
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
        NotaPedidoCab other = (NotaPedidoCab) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

}

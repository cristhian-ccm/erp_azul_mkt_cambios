/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.cmrlz;

import com.upgrade.persistence.model.DocumentoTipo;
import com.upgrade.persistence.model.FormaPago;
import com.upgrade.persistence.model.Impuesto;
import com.upgrade.persistence.model.Moneda;
import com.upgrade.persistence.model.emprs.Empresa;
import com.upgrade.persistence.model.extcs.Almacen;
import com.upgrade.persistence.model.tcros.Direccion;
import com.upgrade.persistence.model.tcros.Persona;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Evander
 */
@TableDB(name	="cmrlz.ventas_cab", sequence="cmrlz.ventas_cab_id_seq")
public class VentaCab implements Serializable {

    public VentaCab() {
    	
    }
    
    @FieldDB(value = "id")
    public Integer id;
    
    @FieldDB(value = "anulada")
    public Boolean anulada;
    
    @FieldDB(value = "creado_por")
    public Integer creadoPor;
    
    @FieldDB(value = "almacen_id")
    public Almacen almacen;
    
    @FieldDB(value = "documento_tipo_id")
    public DocumentoTipo documentoTipo;
    
    @FieldDB(value = "serie")
    public Integer serie;
    
    @FieldDB(value = "numero")
    public Integer numero;
    
    @FieldDB(value = "direccion_cliente_id")
    public Direccion direccionCliente;
    
    @FieldDB(value = "vendedor_id")
    public Persona vendedor;
    
    @FieldDB(value = "moneda_id")
    public Moneda moneda;
    
    @FieldDB(value = "fecha")
    public Date fecha;
    
    @FieldDB(value = "forma_pago_id")
    public FormaPago formaPago;
    
    @FieldDB(value = "impuesto_id")
    public Impuesto impuesto;
    
    @FieldDB(value = "observaciones")
    public String observaciones;
    
    @FieldDB(value = "monto_impuesto")
    public BigDecimal montoImpuesto;
    
    @FieldDB(value = "subtotal")
    public BigDecimal subtotal;
    
    @FieldDB(value = "total")
    public BigDecimal total;       
    
    @FieldDB(value = "monto_cobrar")
    public BigDecimal montoCobrar;
    
    @FieldDB(value = "monto_cobrado")
    public BigDecimal montoCobrado;
    
    @FieldDB(value = "dias_credito")
    public Integer diasCredito;
    
    @FieldDB(value = "empresa_id")
    public Empresa empresa;
    
    @FieldDB(value = "firma")
    public String firma;
    
    @FieldDB(value = "orden_compra_cliente")
    public String ordenCompraCliente;
    
    @FieldDB(value = "descuento")
    public BigDecimal descuento;
    
    @FieldDB(value = "aceptada_sunat")
    public Boolean aceptadaSunat;
    
    @FieldDB(value = "sunat_description")
    public String sunatDescription;  
    
    @FieldDB(value = "enlace_xml")
    public String enlaceXml;
    
    @FieldDB(value = "enlace_pdf")
    public String enlacePdf;
    
    @FieldDB(value = "enlace_anulado_pdf")
    public String enlaceAnuladoPdf;
    
    @FieldDB(value = "enlace_anulado_xml")
    public String enlaceAnuladoXml;

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

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public DocumentoTipo getDocumentoTipo() {
        return documentoTipo;
    }

    public void setDocumentoTipo(DocumentoTipo documentoTipo) {
        this.documentoTipo = documentoTipo;
    }

    public Integer getSerie() {
        return serie;
    }

    public void setSerie(Integer serie) {
        this.serie = serie;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public Impuesto getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Impuesto impuesto) {
        this.impuesto = impuesto;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public BigDecimal getMontoImpuesto() {
        return montoImpuesto;
    }

    public void setMontoImpuesto(BigDecimal montoImpuesto) {
        this.montoImpuesto = montoImpuesto;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getMontoCobrar() {
        return montoCobrar;
    }

    public void setMontoCobrar(BigDecimal montoCobrar) {
        this.montoCobrar = montoCobrar;
    }

    public BigDecimal getMontoCobrado() {
        return montoCobrado;
    }

    public void setMontoCobrado(BigDecimal montoCobrado) {
        this.montoCobrado = montoCobrado;
    }

    public Integer getDiasCredito() {
        return diasCredito;
    }

    public void setDiasCredito(Integer diasCredito) {
        this.diasCredito = diasCredito;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public Integer getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(Integer creadoPor) {
        this.creadoPor = creadoPor;
    }

    public String getOrdenCompraCliente() {
        return ordenCompraCliente;
    }

    public void setOrdenCompraCliente(String ordenCompraCliente) {
        this.ordenCompraCliente = ordenCompraCliente;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public Boolean getAceptadaSunat() {
        return aceptadaSunat;
    }

    public void setAceptadaSunat(Boolean aceptadaSunat) {
        this.aceptadaSunat = aceptadaSunat;
    }

    public String getSunatDescription() {
        return sunatDescription;
    }

    public void setSunatDescription(String sunatDescription) {
        this.sunatDescription = sunatDescription;
    }

    public String getEnlaceXml() {
        return enlaceXml;
    }

    public void setEnlaceXml(String enlaceXml) {
        this.enlaceXml = enlaceXml;
    }

    public String getEnlacePdf() {
        return enlacePdf;
    }

    public void setEnlacePdf(String enlacePdf) {
        this.enlacePdf = enlacePdf;
    }

    public String getEnlaceAnuladoPdf() {
        return enlaceAnuladoPdf;
    }

    public void setEnlaceAnuladoPdf(String enlaceAnuladoPdf) {
        this.enlaceAnuladoPdf = enlaceAnuladoPdf;
    }

    public String getEnlaceAnuladoXml() {
        return enlaceAnuladoXml;
    }

    public void setEnlaceAnuladoXml(String enlaceAnuladoXml) {
        this.enlaceAnuladoXml = enlaceAnuladoXml;
    }
    
    
    
    
    public String getNombreCortoDocumentoTipo()
    {
        return documentoTipo.getNombreCorto();
    }
    
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final VentaCab other = (VentaCab) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
    
    
}

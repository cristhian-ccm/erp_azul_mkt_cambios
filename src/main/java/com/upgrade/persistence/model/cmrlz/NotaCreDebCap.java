/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upgrade.persistence.model.cmrlz;

import com.upgrade.persistence.model.DocumentoTipo;
import com.upgrade.persistence.model.extcs.Almacen;
import com.upgrade.persistence.model.sunat.TipoNotaCredito;
import com.upgrade.persistence.model.tcros.Persona;
import ts.com.service.util.db.client.FieldDB;
import ts.com.service.util.db.client.TableDB;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author darko
 */
@TableDB(name = "cmrlz.nota_credeb_cap", sequence = "cmrlz.nota_credeb_cap_id_seq")
public class NotaCreDebCap implements Serializable {

    @FieldDB(value = "creado_por")
    public Persona creadoPor;
        @FieldDB(value = "editado")
    public Date editado;
    
    @FieldDB(value = "creado")
    public Date creado;

    @FieldDB(value = "editado_por")
    public Persona editadoPor;

    @FieldDB(value = "id")
    public Integer id;

    @FieldDB(value = "serie")
    public String serie;  
    
    @FieldDB(value = "numero")
    public Integer numero;  

    @FieldDB(value = "almacen_id")
    public Almacen almacen;

    @FieldDB(value = "anulada")
    public Boolean anulada;
    
    @FieldDB(value = "documento_tipo_id")
    public DocumentoTipo documentoTipo;

    @FieldDB(value = "fecemision")
    public Date fecEmision;

    @FieldDB(value = "codmotivo_id")
    public TipoNotaCredito codMotivo;

    @FieldDB(value = "firma")
    public String firma;
    
    @FieldDB(value = "desmotivo")
    public String desMotivo;

    @FieldDB(value = "venta_id")
    public VentaCab venta;
    
    @FieldDB(value = "observaciones")
    public String observaciones;

    @FieldDB(value = "sumotroscargos")
    public BigDecimal sumOtrosCargos;

    @FieldDB(value = "mtoopergravadas")
    public BigDecimal mtoOperGravadas;
    
    @FieldDB(value = "mtooperinafectas")
    public BigDecimal mtoOperInafectas;
    
    @FieldDB(value = "mtooperexoneradas")
    public BigDecimal mtoOperexOneradas;
    
    @FieldDB(value = "mtoigv")
    public BigDecimal mtoIGV;
    
    @FieldDB(value = "mtoisc")
    public BigDecimal mtoISC;
    
    @FieldDB(value = "mtootrostributos")
    public BigDecimal mtoOtrosTributos;
    
    @FieldDB(value = "mtoimpventa")
    public BigDecimal mtoImpVenta;
    
    @FieldDB(value = "enlace_pdf_nubefact")
    public String enlacePdfNubefact;
    
    @FieldDB(value = "enlace_xml_nubefact")
    public String enlaceXmlNubefact;
    
    @FieldDB(value = "sunat_descripcion")
    public String descripcion;
    
    @FieldDB(value = "aceptada_sunat")
    public Boolean aceptada_SUNAT;
        

    public Persona getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(Persona creadoPor) {
        this.creadoPor = creadoPor;
    }

    public Date getEditado() {
        return editado;
    }

    public void setEditado(Date editado) {
        this.editado = editado;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
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

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public Boolean getAnulada() {
        return anulada;
    }

    public void setAnulada(Boolean anulada) {
        this.anulada = anulada;
    }

    public DocumentoTipo getDocumentoTipo() {
        return documentoTipo;
    }

    public void setDocumentoTipo(DocumentoTipo documentoTipo) {
        this.documentoTipo = documentoTipo;
    }

    public Date getFecEmision() {
        return fecEmision;
    }

    public void setFecEmision(Date fecEmision) {
        this.fecEmision = fecEmision;
    }

    public TipoNotaCredito getCodMotivo() {
        return codMotivo;
    }

    public void setCodMotivo(TipoNotaCredito codMotivo) {
        this.codMotivo = codMotivo;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getDesMotivo() {
        return desMotivo;
    }

    public void setDesMotivo(String desMotivo) {
        this.desMotivo = desMotivo;
    }

    public VentaCab getVenta() {
        return venta;
    }

    public void setVenta(VentaCab venta) {
        this.venta = venta;
    }

    public BigDecimal getSumOtrosCargos() {
        return sumOtrosCargos;
    }

    public void setSumOtrosCargos(BigDecimal sumOtrosCargos) {
        this.sumOtrosCargos = sumOtrosCargos;
    }

    public BigDecimal getMtoOperGravadas() {
        return mtoOperGravadas;
    }

    public void setMtoOperGravadas(BigDecimal mtoOperGravadas) {
        this.mtoOperGravadas = mtoOperGravadas;
    }

    public BigDecimal getMtoOperInafectas() {
        return mtoOperInafectas;
    }

    public void setMtoOperInafectas(BigDecimal mtoOperInafectas) {
        this.mtoOperInafectas = mtoOperInafectas;
    }

    public BigDecimal getMtoOperexOneradas() {
        return mtoOperexOneradas;
    }

    public void setMtoOperexOneradas(BigDecimal mtoOperexOneradas) {
        this.mtoOperexOneradas = mtoOperexOneradas;
    }

    public BigDecimal getMtoIGV() {
        return mtoIGV;
    }

    public void setMtoIGV(BigDecimal mtoIGV) {
        this.mtoIGV = mtoIGV;
    }

    public BigDecimal getMtoISC() {
        return mtoISC;
    }

    public void setMtoISC(BigDecimal mtoISC) {
        this.mtoISC = mtoISC;
    }

    public BigDecimal getMtoOtrosTributos() {
        return mtoOtrosTributos;
    }

    public void setMtoOtrosTributos(BigDecimal mtoOtrosTributos) {
        this.mtoOtrosTributos = mtoOtrosTributos;
    }

    public BigDecimal getMtoImpVenta() {
        return mtoImpVenta;
    }

    public void setMtoImpVenta(BigDecimal mtoImpVenta) {
        this.mtoImpVenta = mtoImpVenta;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEnlacePdfNubefact() {
        return enlacePdfNubefact;
    }

    public void setEnlacePdfNubefact(String enlacePdfNubefact) {
        this.enlacePdfNubefact = enlacePdfNubefact;
    }

    public String getEnlaceXmlNubefact() {
        return enlaceXmlNubefact;
    }

    public void setEnlaceXmlNubefact(String enlaceXmlNubefact) {
        this.enlaceXmlNubefact = enlaceXmlNubefact;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getAceptada_SUNAT() {
        return aceptada_SUNAT;
    }

    public void setAceptada_SUNAT(Boolean aceptada_SUNAT) {
        this.aceptada_SUNAT = aceptada_SUNAT;
    }
    
    public String getAceptadoSunatStr()
    {
        if(this.serie.equals("BN"))
            return "Pendiente";

        if (this.aceptada_SUNAT != null)
            return this.aceptada_SUNAT?"Aceptado":"Rechazado";
        else
            return "Rechazado";
    }
    
    public String getNumeroVentaAfecta()
    {
        String serie = String.valueOf(this.venta.getSerie());
        int longitud = 3-serie.length();
        for(int i=0; i<longitud; i++)
        {
            serie = "0"+serie;
        }
        
        return this.venta.getNombreCortoDocumentoTipo().substring(0, 1)+serie+"-"+String.valueOf(this.venta.getNumero());
    }        
                    

    @Override
    public int hashCode() {
        int hash = 5;
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
        final NotaCreDebCap other = (NotaCreDebCap) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    

}

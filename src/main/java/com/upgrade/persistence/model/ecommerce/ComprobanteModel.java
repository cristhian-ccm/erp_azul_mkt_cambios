package com.upgrade.persistence.model.ecommerce;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class ComprobanteModel {

    public String tipo;  //factura-boleta //Boleta-Factura


    public String nombre;

   // public String apellido;

   // public String dni;
   //public String ruc;


    //public String razonSocial;


    public String telefono;
    public String direccion;




    public String identificador;




    public ComprobanteModel() {
    }




    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }





    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;

            }

    

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
*/

/*

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }


    */ 



    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String dni) {
        this.identificador = dni;
    }



/*
    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
*/


    public String getDireccion() {
        return direccion;
    }


    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "ComprobanteModel{" +
                 "tipo='" + tipo + '\'' +

                ", nombre='" + nombre + '\'' +

              // ", apellido='" + apellido + '\'' +  

                ", identificador='" + identificador + '\'' +

               // ", dni='" + dni + '\'' +


                ", telefono='" + telefono + '\'' +

              // ", razonSocial='" + razonSocial + '\'' +

               // ", ruc='" + ruc + '\'' +


                ", direccion='" + direccion + '\'' +
                '}';
    }
}

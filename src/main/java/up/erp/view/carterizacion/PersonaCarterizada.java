/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.carterizacion;

/**
 *
 * @author Upgrade - PC
 */
public class PersonaCarterizada {
    
    private int idPersona;
    private String nombre;
    private String identificador;
    private Boolean isCarterizada;
    private String nombreCarterizadoPor;
    
    public PersonaCarterizada()
    {
        
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Boolean getIsCarterizada() {
        return isCarterizada;
    }

    public void setIsCarterizada(Boolean isCarterizada) {
        this.isCarterizada = isCarterizada;
    }    

    public String getNombreCarterizadoPor() {
        return nombreCarterizadoPor;
    }

    public void setNombreCarterizadoPor(String nombreCarterizadoPor) {
        this.nombreCarterizadoPor = nombreCarterizadoPor;
    }
    
}

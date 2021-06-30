/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.service;

import com.upgrade.persistence.model.tcros.Persona;

import java.util.List;

/**
 *
 * @author Luis Aleman
 */
public interface PersonaService {
    
    public Persona getBydni(String dni);
    public Persona getByname(String nombre);
    //public List<Persona> list(boolean soloActivos);
    public List<Persona> listByNombre(String nombre);
    public void save_Cli(Persona cliente);
    public void delete_Cli(Persona cliente);
    public void update_Cli(Persona cliente);
    public Persona getOnePersona();
    public List<Persona> listByNombreOrDNI(String nombre);
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.server.serviceimpl;

import com.upgrade.persistence.model.tcros.Persona;
import ts.com.service.util.db.server.CRUD;
import up.erp.service.PersonaService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis Aleman
 */
public class PersonaServiceImpl implements PersonaService{
    
    @Override
    public Persona getBydni(String dni) {
        Persona result = new Persona();
        try {
            String where = "where identificador ilike '%" + dni + "%' limit 1";
            List<Persona> list = CRUD.list(Persona.class,where);
            if(!list.isEmpty()){
                result = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(PersonaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    /*
    @Override
    public List<PPersona> list(boolean soloActivos) {
        List<Persona> result = new ArrayList<>();
        try {
            String where = soloActivos?"where inactivo is false ":"";
            result = CRUD.list(Producto.class,where);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    */
    @Override
    public List<Persona> listByNombre(String nombre) {
        List<Persona> result = new ArrayList<>();
        try {
            String where = "where nombre ilike '%"+nombre+"%'";
            result = CRUD.list(Persona.class,where);
        } catch (Exception ex) {
            Logger.getLogger(PersonaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public List<Persona> listByNombreOrDNI(String nombre) {
        List<Persona> result = new ArrayList<>();
        try {
            String where = "where nombre ilike '%"+nombre+"%' or identificador ilike '%"+nombre+"%'";
            result = CRUD.list(Persona.class,where);
        } catch (Exception ex) {
            Logger.getLogger(PersonaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public void save_Cli(Persona cliente){
        try {
            CRUD.save(cliente);
        } catch (Exception ex) {
            Logger.getLogger(PersonaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete_Cli(Persona cliente) {
        try {
            CRUD.delete(cliente);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update_Cli(Persona cliente) {
        try {
            CRUD.update(cliente);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Persona getByname(String nombre) {
        Persona result = null;
        try {
            String where = "where nombre = '"+nombre+"' limit 1";
            List<Persona> list = CRUD.list(Persona.class,where);
            if(!list.isEmpty()){
                result = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(PersonaServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
     @Override
    public Persona getOnePersona()
    {
        Persona result = null;
        try {
            String where = "limit 1";
            List<Persona> list = CRUD.list(Persona.class,where);
            if(!list.isEmpty()){
                result = list.get(0);
            }    
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    /*
    @Override
    public List<PPersona> list(boolean soloActivos) {
        List<Persona> result = new ArrayList<>();
        try {
            String where = soloActivos?"where inactivo is false ":"";
            result = CRUD.list(Producto.class,where);
        } catch (Exception ex) {
            Logger.getLogger(ProductoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    */
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.carterizacion;

import com.upgrade.persistence.model.tcros.Direccion;
import com.upgrade.persistence.model.tcros.Persona;
import com.upgrade.persistence.model.usros.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import up.erp.service.Services;
import up.erp.view.App;
import up.erp.view.produccion.Mensaje;

/**
 *
 * @author Upgrade - PC
 */
public class CarterizacionesView extends CarterizacionesUI {
    
    public App app;
    public Persona persona = Services.getPersona().getOnePersona();
    
    public CarterizacionesView(App app) {
        this.app = app;
        //List<Usuario> listUsuarios = Services.getUsuarios().list(true);
        //gridUsuarios.setItems(listUsuarios);
    }
    
    @Override
    public void onGetUsuariosByNombre()
    {
        List<Usuario> listUsuarios = Services.getUsuarios().listByNombre(buscarByNombre.getValue());
        comboVendedores.setItems(listUsuarios);
    }
    
    @Override
    public Mensaje onGetClientesCarterizados(){
        Mensaje mensaje = new Mensaje();
        List<Direccion> listClientesCarterizados = Services.getDireccion().listClientesByVendedor(String.valueOf(comboVendedores.getValue().getId().getId()));
        
        if(listClientesCarterizados.isEmpty())
        {
            mensaje.setMensaje("El vendedor no cuenta con ningúna persona en su cartera de clientes");
            mensaje.setTipo(false);
            gridClientes.setItems(new ArrayList<>());
        }
        else
        {
            mensaje.setTipo(true);
            gridClientes.setItems(listClientesCarterizados);
        }
        
        return mensaje;
        
    }
    
    @Override
    public Mensaje onGetClientesCarterizadosDistinct(){
        Mensaje mensaje = new Mensaje();
        List<Direccion> listClientesCarterizados = Services.getDireccion().listClientesByVendedor(String.valueOf(comboVendedores.getValue().getId().getId()));
        
        if(listClientesCarterizados.isEmpty())
        {
            mensaje.setMensaje("El vendedor no cuenta con ningúna persona en su cartera de clientes");
            mensaje.setTipo(false);
            gridClientes.setItems(new ArrayList<>());
        }
        else
        {
            mensaje.setTipo(true);
            gridClientes.setItems(listClientesCarterizados);
        }
        
        return mensaje;
        
    }
    
    @Override
    public  void onGetPersonas(){
        List<Persona> listPersonas = Services.getPersona().listByNombreOrDNI(txtPersonaNombre.getValue());
        
        List<PersonaCarterizada> listPersonaCarterizada = new ArrayList<>();
        for(int i=0; i<listPersonas.size(); i++)
        {
            PersonaCarterizada personaCarterizada = new PersonaCarterizada();
            personaCarterizada.setIdPersona(listPersonas.get(i).getId());
            personaCarterizada.setNombre(listPersonas.get(i).getNombre());
            personaCarterizada.setIdentificador(listPersonas.get(i).getIdentificador());
            
            try {
                List<Direccion> listVendedores = Services.getDireccion().listDireccionByPersonaWithVendedor(listPersonas.get(i).getId());
                //System.out.println(listVendedores.get(0).getVendedor());
                if(listVendedores.get(0).getVendedor() == null)
                {
                    personaCarterizada.setIsCarterizada(Boolean.FALSE);
                    personaCarterizada.setNombreCarterizadoPor("NINGUNO");
                }
                else{
                    personaCarterizada.setIsCarterizada(Boolean.TRUE);
                    personaCarterizada.setNombreCarterizadoPor(listVendedores.get(0).getVendedor().getNombre());
                }
            } catch (Exception ex) {
                Logger.getLogger(CarterizacionesView.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            listPersonaCarterizada.add(personaCarterizada);
        }
        
        gridPersonaCarterizada.setItems(listPersonaCarterizada);
    }
    
    @Override
    public void onCambiardeCartera(){
        try {
            List<Direccion> listDireccionPersonas = Services.getDireccion().getDireccionByPersonaId(gridPersonaCarterizada.asSingleSelect().getValue().getIdPersona());
            
            for(int i=0; i<listDireccionPersonas.size(); i++)
            {
                Direccion direccion = listDireccionPersonas.get(i);
                direccion.setVendedor(comboVendedores.getValue().getId());
                Services.getDireccion().update(direccion);
            }
            
            onGetClientesCarterizados();
        } catch (Exception ex) {
            Logger.getLogger(CarterizacionesView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

/** *****************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ****************************************************************************** */
package up.erp.server.serviceimpl;

import com.upgrade.persistence.model.tcros.Direccion;
import com.upgrade.persistence.model.tcros.Persona;

import java.util.ArrayList;
import java.util.List;

import com.upgrade.persistence.model.DocumentoIdentidad;
import com.upgrade.persistence.model.cmrlz.NotaPedidoCab;
import com.upgrade.persistence.model.cmrlz.VentaCab;
import com.upgrade.persistence.model.ecommerce.DirEntrega;
import com.upgrade.persistence.model.ecommerce.PostCheckoutModel;
import com.upgrade.persistence.model.ecommerce.UsuarioWeb;
import com.upgrade.persistence.model.tcros.Tratamiento;
import java.util.logging.Level;
import java.util.logging.Logger;
import ts.com.service.util.db.ObjectDB;
import ts.com.service.util.db.Query;
import ts.com.service.util.db.server.CRUD;
import up.erp.server.Server;
import up.erp.service.DireccionService;

public class DireccionServiceImpl implements DireccionService {

    @Override
    public Direccion getDireccion(int direccionId) throws Exception {
        /*QueryDB query = new QueryDB(Direccion.class);
        query.where.add("id = " + direccionId);
        query.end.add("order by descripcion asc limit 1");
        List<Direccion> list = query.list();
        return list.isEmpty()?null:list.get(0);*/
        return null;
    }

    @Override
    public List<Direccion> getListByPersonaRuc(String ruc) throws Exception {

        Query q = new Query();
        ObjectDB direccion = q.getNewObjectDB(Direccion.class, "dir");
        ObjectDB persona = q.getNewObjectDB(Persona.class, "per");
        ObjectDB tratamiento = q.getNewObjectDB(Tratamiento.class, "tra");
        ObjectDB documentoIdentidad = q.getNewObjectDB(DocumentoIdentidad.class, "did");
        q.select.add(direccion).add(persona).add(tratamiento).add(documentoIdentidad);
        q.from.add(direccion);
        q.join.add(persona, direccion, "persona");
        q.join.add(tratamiento, persona, "tratamiento");
        q.join.add(documentoIdentidad, persona, "documentoIdentidad");
        q.where = "where per.identificador ilike '%" + ruc + "%' and dir.inactivo is false";
        q.end = "order by per.nombre asc";
        Object[][] rs = q.initResultSet();
        List<Direccion> list = new ArrayList<>();
        if (rs != null) {
            for (int i = 0; i < rs.length; i++) {
                Direccion item = (Direccion) direccion.getNewObject(i);
                item.persona = (Persona) persona.getNewObject(i);
                item.persona.documentoIdentidad = (DocumentoIdentidad) documentoIdentidad.getNewObject(i);
                item.persona.tratamiento = (Tratamiento) tratamiento.getNewObject(i);
                list.add(item);
            }
        }

        return list;
    }

    @Override
    public List<Direccion> getListByPersonaNombre(String nombre) throws Exception {
        Query q = new Query();
        ObjectDB direccion = q.getNewObjectDB(Direccion.class, "dir");
        ObjectDB persona = q.getNewObjectDB(Persona.class, "per");
        ObjectDB tratamiento = q.getNewObjectDB(Tratamiento.class, "tra");
        ObjectDB documentoIdentidad = q.getNewObjectDB(DocumentoIdentidad.class, "did");
        q.select.add(direccion).add(persona).add(tratamiento).add(documentoIdentidad);
        q.from.add(direccion);
        q.join.add(persona, direccion, "persona");
        q.join.add(tratamiento, persona, "tratamiento");
        q.join.add(documentoIdentidad, persona, "documentoIdentidad");
        q.where = "where per.nombre ilike '%" + nombre + "%' and dir.inactivo is false";
        q.end = "order by per.nombre asc";
        Object[][] rs = q.initResultSet();
        List<Direccion> list = new ArrayList<>();
        if (rs != null) {
            for (int i = 0; i < rs.length; i++) {
                Direccion item = (Direccion) direccion.getNewObject(i);
                item.persona = (Persona) persona.getNewObject(i);
                item.persona.documentoIdentidad = (DocumentoIdentidad) documentoIdentidad.getNewObject(i);
                item.persona.tratamiento = (Tratamiento) tratamiento.getNewObject(i);
                list.add(item);
            }
        }

        return list;
    }

    @Override
    public List<Direccion> getListDirecciones(int vendedorId) throws Exception {
        Query q = new Query();
        ObjectDB direccion = q.getNewObjectDB(Direccion.class, "dir", "id", "vendedor");
        q.select.add(direccion);
        q.from.add(direccion);
        q.where = "where dir.vendedor_id = " + vendedorId;
        Object[][] rs = q.initResultSet();
        List<Direccion> list = new ArrayList<>();
        if (rs != null) {
            for (int i = 0; i < rs.length; i++) {
                Direccion item = (Direccion) direccion.getNewObject(i);
                list.add(item);
            }
        }
        return list;
    }

    @Override
    public List<Direccion> getDireccionByPersona(int personaId) throws Exception {
        List<Direccion> list = new ArrayList<>();
        String[] required = new String[]{
            "persona"
        };
        String filter = "Where d.persona_id = " + personaId;
        list = CRUD.list(Direccion.class, required, filter);
        return list;
    }
    
    @Override
    public List<Direccion> getDireccionByPersonaId(int personaId) throws Exception {
        List<Direccion> list = new ArrayList<>();
        String[] required = new String[]{
            "persona"
        };
        String filter = "Where a.persona_id = " + personaId;
        list = CRUD.list(Direccion.class, required, filter);
        return list;
    }




    @Override
    public Direccion getDireccionByDirID(PostCheckoutModel model) throws Exception {
        
        Integer DirID = model.direccion_id;



        List<Direccion> list = new ArrayList<>();
        String[] required = new String[]{
            "persona"
        };
        String filter = "Where a.id = " + DirID;
        list = CRUD.list(Direccion.class, required, filter);


        if(list.isEmpty()){
            return null;
        }else{
            Direccion dir = list.get(0);
            /*dir.ubigeoCodigo = model.dirEntrega.ubigeo;
            dir.descripcion = model.dirEntrega.direccion;
            CRUD.update(dir);*/
            return dir;
        }              
    }





    @Override
    public Direccion getDireccionByIdentificador(PostCheckoutModel model) throws Exception {
        //String tipoDoc = model.comprobanteModel.tipo;

        //String identificador = model.comprobanteModel.dni;
        String identificador = model.comprobanteModel.identificador;

/*

        if(tipoDoc.equals("Factura")){
            //identificador = model.comprobanteModel.ruc;
            identificador = model.comprobanteModel.identificador;

        }
*/

        List<Direccion> list = new ArrayList<>();
        String[] require = {"persona"};

        //String where = " where b.usu_web_id = " + usuarioWebId + " and b.identificador = '"+identificador+"'";
        String where = " where  b.identificador = '"+identificador+"'";

        list = CRUD.list(Direccion.class, require, where);
        if(list.isEmpty()){
            return null;
        }else{
            Direccion dir = list.get(0);
            dir.ubigeoCodigo = model.dirEntrega.ubigeo;
            dir.descripcion = model.dirEntrega.direccion;
            CRUD.update(dir);
            return dir;
        }
        
    }


/* ORIGINAL
    @Override
    public Direccion getDireccionByUsuarioWeb(int usuarioWebId, PostCheckoutModel model) throws Exception {
        String tipoDoc = model.comprobanteModel.tipo;
        String identificador = model.comprobanteModel.dni;
        if(tipoDoc.equals("Factura")){
            identificador = model.comprobanteModel.ruc;
        }
        List<Direccion> list = new ArrayList<>();
        String[] require = {"persona"};
        String where = " where b.usu_web_id = " + usuarioWebId + " and b.identificador = '"+identificador+"'";
        
        list = CRUD.list(Direccion.class, require, where);
        if(list.isEmpty()){
            return null;
        }else{
            Direccion dir = list.get(0);
            dir.ubigeoCodigo = model.dirEntrega.ubigeo;
            dir.descripcion = model.dirEntrega.direccion;
            CRUD.update(dir);
            return dir;
        }
        
    }
*/



    @Override
    public Direccion createDireccionByUsuarioWeb(/*int usuarioWebId, */PostCheckoutModel model) throws Exception {
       
       /*
       List<UsuarioWeb> usuariosWeb = CRUD.list(UsuarioWeb.class, "where id = " + usuarioWebId);
       // UsuarioWeb usuarioWeb = usuariosWeb.isEmpty() ? null : usuariosWeb.get(0);
        
        if (usuarioWeb == null) {
            throw new Exception("Usuario no encontrado");
        }

        

       
*/


        String identificador = model.comprobanteModel.identificador;

        String tipoDoc = model.comprobanteModel.tipo;
       
      //  String identificador = model.comprobanteModel.dni;



        if(tipoDoc.equals("Factura")){
            //identificador = model.comprobanteModel.ruc;
            identificador = model.comprobanteModel.identificador;

        }
        

        PersonaServiceImpl personaService = new PersonaServiceImpl();
        Persona p = personaService.getBydni(identificador);
        
        
        //para grabar la persona si no existe
        
        if (p.id == null) {
            p = new Persona();
            p = new Persona();
            p.agenteRetencion = false;
            p.brevette = "-";
            p.cargo = "-";
            p.creadoPor = new Persona();
            p.creadoPor.id = 0;
            p.documentoIdentidad = new DocumentoIdentidad();
            p.documentoIdentidad.id = identificador.trim().length() == 11 ? 4 : 2;
            p.editado = null;
            p.editado_por = null;
            
            //p.email = usuarioWeb.email;
            p.email = model.dirEntrega.email;

            p.empresa = null;
            p.identificador = identificador;
            p.inactivo = false;

            //p.nombre = usuarioWeb.apellidos + " " + usuarioWeb.nombres;
            p.nombre = model.comprobanteModel.nombre;

            //p.telefono = usuarioWeb.telefono;
            p.telefono = model.comprobanteModel.telefono;

            p.tratamiento = new Tratamiento();
            p.tratamiento.id = 1;

            //p.usuario_web = usuarioWeb;
           


            CRUD.save(p);
        } else {
            //p.email = usuarioWeb.email;
            p.email = model.dirEntrega.email;
            
            //p.telefono = usuarioWeb.telefono;
            p.telefono = model.comprobanteModel.telefono;

           //p.usuario_web = usuarioWeb;

            CRUD.update(p);
        }


        ///
        Direccion d = new Direccion();
        d.creadoPor = new Persona();
        d.creadoPor.id = 0;
        //d.descripcion = model.dirEntrega.direccion;
        d.editado = null;
        d.editadoPor = null;

        //d.email = usuarioWeb.email;
        d.email=model.dirEntrega.email;

        d.inactivo = false;
        d.nombre = "-";
        d.persona = p;
        d.principal = true;
        d.seguimiento = null;
        
        //d.telefono = usuarioWeb.telefono;
        d.telefono = model.comprobanteModel.telefono;

        d.ubigeoCodigo = model.dirEntrega.ubigeo;
        d.vendedor = new Persona();
        d.vendedor.id = Server.VENDEDOR_ECOMMERCE_ID;

        d.descripcion=model.comprobanteModel.direccion;

        CRUD.save(d);
        return d;
    }




    
    @Override
    public List<Direccion> listClientesByVendedor(String idPersona)
    {
        List<Direccion> result = new ArrayList<>();
        try {
            String where = "where a.inactivo is false and a.vendedor_id = '"+idPersona+"' order by b.nombre";
            String[] require = {"persona"};
            result = CRUD.list(Direccion.class, require, where);
        } catch (Exception ex) {
            Logger.getLogger(DireccionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    } 
    
    @Override
    public List<Direccion> listDireccionByPersonaWithVendedor(int personaId) throws Exception {
        List<Direccion> list = new ArrayList<>();
        String[] required = new String[]{
            "vendedor"
        };
        String filter = "Where a.persona_id = " + personaId;
        list = CRUD.list(Direccion.class, required, filter);
        return list;
    }
    
    @Override
    public Direccion update(Direccion direccion)
    {
        //PlantillaTransformacion plantilla = new PlantillaTransformacion();
        try {
            //CRUD.save(newPlantilla); 
            CRUD.update(direccion);
        } catch (Exception ex) {
            Logger.getLogger(DireccionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return direccion;
    }

}

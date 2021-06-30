/**
 * *****************************************************************************
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
 ******************************************************************************
 */
package up.erp.server.serviceimpl;


import java.util.ArrayList;
import java.util.List;

import com.upgrade.persistence.auxiliar.Session;
//import com.upgrade.persistence.factory.Services;
import com.upgrade.persistence.model.emprs.Empresa;
import com.upgrade.persistence.model.emprs.Sucursal;
import com.upgrade.persistence.model.extcs.Almacen;
import com.upgrade.persistence.model.fnnzs.Caja;
import com.upgrade.persistence.model.tcros.Persona;
import com.upgrade.persistence.model.usros.Permiso;
import com.upgrade.persistence.model.usros.RolPermiso;
import com.upgrade.persistence.model.usros.Usuario;
import com.upgrade.persistence.model.usros.UsuarioAlmacen;
import com.upgrade.persistence.model.usros.UsuarioCaja;

import com.upgrade.persistence.util.Persistence;
import java.util.Date;
import ts.com.service.util.db.ObjectDB;
import ts.com.service.util.db.Query;
import ts.com.service.util.db.server.CRUD;
import up.erp.service.LoginService;
import up.erp.service.Services;

public class LoginServiceImpl implements LoginService {

    public Session newLogin(String user, String pass, int empresa_id) throws Exception {
        String where = " where usuario_id = '"+user+"' and clave = '"+ encrypt(pass)+"'";
        Usuario usuario = new Usuario();
        Session ses = new Session();
        
        List<Usuario> listUsuarios = CRUD.list(Usuario.class, where);
        
        if(!listUsuarios.isEmpty()) 
            usuario = listUsuarios.get(0);
        else
        {   
            throw new Exception("El usuario o clave son incorrectos.");
        }
        where = " where b.id = '"+usuario.getId().getId()+"'";
        String[] require = {"usuario", "almacen"};
        List<UsuarioAlmacen> listUsuarioAlmacen = CRUD.list(UsuarioAlmacen.class, require, where);
        
        if (listUsuarioAlmacen.isEmpty()) {
            throw new Exception("No se encontraron almacenes asignados al usuario ingresado");
        }
        
        List<Almacen> almacenes = new ArrayList<>();
        int rows = listUsuarioAlmacen.size();
        for (int i = 0; i < rows; i++) {
            Almacen almacen = (Almacen) listUsuarioAlmacen.get(i).getAlmacen();
            almacenes.add(almacen);
        }
        
        String filter = "where b.id in("
                + "select ur.rol_id from usros.usuarios_roles as ur where ur.usuario_id = " + usuario.id.id + ") "
                + "and b.inactivo is false and c.inactivo is false";
        String[] rolperRequired = {"rol", "permiso"};
        List<RolPermiso> listRolPermiso = CRUD.list(RolPermiso.class, rolperRequired, filter);
      
        boolean tieneCaja = false;
        List<Permiso> permisos = new ArrayList<>();
        for (RolPermiso rp : listRolPermiso) {
            permisos.add(rp.permiso);
            if(rp.rol.id == Persistence.ROL_CAJERO){
                tieneCaja = true;
            }
        }
        
        List<Caja> listCajas = new ArrayList<>();
       
        if (tieneCaja) {
            List<UsuarioCaja> listUsuarioCaja = new ArrayList<>();
            String[] r = new String[]{
                "caja as c",
                "caja.almacen as al"
            };
            String[] requireUsuarioCaja = {"caja", "caja.almacen"};
            where = " where usuario_id = '"+usuario.getId().getId()+"'";
            
            listUsuarioCaja = CRUD.list(UsuarioCaja.class, requireUsuarioCaja, where);
            for (UsuarioCaja uc : listUsuarioCaja) {
                listCajas.add(uc.caja);
            }
        }
        
        
        Empresa empresa = new Empresa();
        empresa.id = empresa_id;
        
        
        ses.usuario = usuario;
        ses.almacenes = almacenes;
        ses.empresa = empresa;
        ses.permisos = permisos;
        ses.rolPermiso = listRolPermiso;   
        ses.caja = listCajas;
        return ses;
        
    }
    
    public static String encrypt(String raw) {
        String result = "";
        int letra = 0;
        int valor = 0;
        int newvalor = 0;
        char let;
        for (int i = 0; i < raw.length(); i++) {
            let = raw.charAt(i);
            letra = string_to_ascii(let);
            valor = valor + letra;
        }

        valor = (valor % 31);
        if (valor == 0) {
            valor = 19;
        }
        for (int i = 0; i < raw.length(); i++) {
            let = raw.charAt(i);
            letra = string_to_ascii(let);
            if (i == 0) {
                newvalor = letra + valor;
            } else if ((i % 2) == 0) {
                newvalor = letra + valor;
            } else if ((i % 2) != 0) {
                newvalor = letra - valor;
            }
            valor--;
            result += Integer.toString(newvalor, 16);
        }
        return result;
    }

    // convertir una letra en su valor asccii
    private static int string_to_ascii(char string) {
        int ascii = string;
        return ascii;
    }

    @Override
    public Boolean validarUsuario(String user, String pas) throws Exception {
        /*QueryDB query = new QueryDB(Usuario.class);
        query.where .add("usuario = '" + user + "'")
                    .add("clave = '" + encrypt(pas) + "'");
        List<Usuario> usuarios = query.list();
        if (usuarios.isEmpty()) {
            return false;
            
        }
        else return true;*/
        return false;
    }

    @Override
    public Boolean validarTipoVendedor(int usuarioID, String Tipo) throws Exception {
        Date fechaActual=new Date();
        int month = fechaActual.getMonth();
        int year= fechaActual.getYear();
        
        
        return true;
    }

}

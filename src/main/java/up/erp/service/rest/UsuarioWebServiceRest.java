/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.service.rest;

import com.upgrade.persistence.model.ecommerce.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import up.erp.service.UsuarioWebService;
import up.erp.service.model.SaveCart;
import up.erp.service.model.VerificarEmail;

import java.util.List;

/**
 *
 * @author evanl
 */
@RequestMapping("/usuarios")
@RestController
public class UsuarioWebServiceRest {

    @Autowired
    private UsuarioWebService usuarioWebService;

    @PostMapping("/crear-usuario-invitado")
    public ResponseFrontModel crearUsuarioInvitado() {
        return usuarioWebService.crearUsuarioInvitado();
    }
    @PostMapping("/registrar")
    public ResponseFrontModel registrar(@RequestBody UsuarioWeb usuarioWeb) {
        return usuarioWebService.registrar(usuarioWeb);
    }
    @PostMapping("/registrar-concupon/{cuponId}")
    public ResponseFrontModel registrar_concupon(@RequestBody UsuarioWeb usuarioWeb, @PathVariable Integer cuponId) {
        return usuarioWebService.registrarConCupon(usuarioWeb, cuponId);
    }
    @PostMapping("/registrar-firebase")
    public UsuarioWeb registrarFirebase(@RequestBody UsuarioWeb usuarioWeb) {
        return usuarioWebService.registrarFirebase(usuarioWeb);
    }
    @PostMapping("/registrar-firebase-cupon/{cuponId}")
    public UsuarioWeb registrarFirebaseCupon(@RequestBody UsuarioWeb usuarioWeb, @PathVariable Integer cuponId) {
        return usuarioWebService.registrarFirebaseCupon(usuarioWeb, cuponId);
    }
    @PostMapping("/confirmar-email")
    public ResponseFrontModel confirmarEmail(@RequestBody VerificarEmail email) {
        return usuarioWebService.confirmarEmail(email.getKey());
    }
    @PostMapping("/validar-reseteo-contraseña")
    public ResponseFrontModel validarReestContraseña(@RequestBody VerificarEmail email) {
        return usuarioWebService.validarReestContraseña(email.getEmail(), email.getKey());
    }
    @PostMapping("/cambiar-password-email")
    public ResponseFrontModel cambiarPasswEmail(@RequestBody CambiarPassw cambiarPassw) {
        return usuarioWebService.cambiarPasswEmail(cambiarPassw);
    }
    @GetMapping("/validar-email")
    public boolean validarEmail(@RequestParam(value = "email") String email) {
        return usuarioWebService.validarEmail(email);
    }
    @PostMapping("/validar-email-activo")
    public ResponseFrontModel validarEmailActivo(@RequestBody UsuarioWeb usuario) {
        return usuarioWebService.validarEmailActivo(usuario.getEmail(), usuario.getPassword());
    }
    @PostMapping("/login")
    public UsuarioWeb login(@RequestBody UsuarioWeb usuario) {
        return usuarioWebService.login(usuario.getEmail(), usuario.getPassword());
    }
    @GetMapping("/reset-password")
    public ResponseFrontModel resetPassword(@RequestParam(value = "email") String email) {
        return usuarioWebService.resetPassword(email);
    }
    @GetMapping("/reset-password2")
    public ResponseFrontModel resetPassword2(@RequestParam(value = "email") String email) {
        return usuarioWebService.resetPassword2(email);
    }
    @PostMapping("/change-password")
    public ResponseFrontModel changePassword(@RequestBody CambiarPassw cambiarPassw) {
        return usuarioWebService.changePassword(cambiarPassw);
    }
    @PostMapping("/save-cart")
    public Integer saveCart(@RequestBody SaveCart saveCart) {
        return usuarioWebService.saveCart(saveCart);
    }
    @PostMapping("/save-wish")
    public Integer saveWish(@RequestBody SaveCart saveCart) {
        return usuarioWebService.saveWish(saveCart);
    }

    @GetMapping("/get-user")
    public UsuarioWeb loginFirebase(@RequestParam(value = "email") String email) {
        return usuarioWebService.loginFirebase(email);
    }
    @PostMapping("/suscribirse/{idPromo}")
    public ResponseFrontModel suscribirseConPromo(@RequestBody SuscripcionModel suscripcion, @PathVariable Integer idPromo) {
        return usuarioWebService.suscribirseConPromo(suscripcion, idPromo);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.login;

import com.upgrade.persistence.auxiliar.Session;
import com.upgrade.persistence.util.Persistence;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.router.Route;

//import jdk.javadoc.internal.doclets.toolkit.Messages;
import up.erp.service.Services;
import up.erp.view.App;

/*import com.rednave.util.Util;
import com.rednave.util.factory.Messages;
import com.rednave.util.ui.LoginUI;
import com.upgrade.App;
import com.upgrade.persistence.auxiliar.Session;
import com.upgrade.persistence.factory.Services;
import com.upgrade.persistence.util.Persistence;

import com.vaadin.ui.UI;*/

/**
 *
 * @author Hvt
 */

public class LoginView extends LoginUI {

    public LoginView() {
        // super("Grupo Upgrade S.A.C.");
        // TODO Auto-generated constructor stub

        initHandlers();

    }

    private void initHandlers() {
        // this.getTxtClave().addValueChangeListener(e->connect());
        // this.getBtnConectar().addClickListener(this::connect);
    }

    private void connect() {

        try {
            String user = txtUsuario.getValue();
            String pass = txtPassword.getValue();

            Session session = Services.getLogin().newLogin(user, pass, Persistence.EMPRESA_GRUPO_UPGRADE_ID);
            UI.getCurrent().getSession().setAttribute("session", session);

            // UI.getCurrent().getSession().setAttribute("", new MainView());
            UI.getCurrent().getSession().setAttribute("", new App());
            // App.setMainView(new MainView());
            setContent(new App());
            // App.getMainView().setCaption();
            // UI.getCurrent().setContent(App.getMainView());
            // UI.getCurrent().addWindow(App.getSesion().mainView);

            // close();
        } catch (Exception ex) {
            ex.printStackTrace();
            // Messages.error(ex.getMessage());
        }

    }

    public void setContent(Component component) {
        this.layContent.removeAll();
        this.layContent.add(component);
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.login;

import com.upgrade.persistence.auxiliar.Session;
import com.upgrade.persistence.model.usros.Usuario;
import com.upgrade.persistence.util.Persistence;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import up.erp.service.Services;
import up.erp.view.App;

/**
 *
 * @author Diego Javier Quispe
 */
@Route("")
@PWA(name = "Vaadin up.erp.Application", shortName = "Vaadin App", description = "This is an example Vaadin application.", enableInstallPrompt = false)
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
@JsModule("./styles/eva_blue.js")
@Theme(value = Lumo.class, variant = Lumo.DARK)
public class LoginUI extends VerticalLayout {

    public final TextField txtUsuario = new TextField("Usuario");
    public final PasswordField txtPassword = new PasswordField("Contraseña");
    public final Button btnLogin = new Button("Ingresar");
    public final HorizontalLayout layContent = new HorizontalLayout();
    public final VerticalLayout layVertical = new VerticalLayout();
    public final FormLayout loginForm = new FormLayout();
    public final Icon icon = VaadinIcon.USER.create();
    public final Notification notificationError = new Notification();
    public final Notification notificationSuccess = new Notification();

    /*
     * public LoginUI() { Image img = new
     * Image("https://www.upgrade.com.pe/assets/images/upgrade_iso.png",
     * "Upgrade Logo"); img.setHeight("44px"); addToNavbar(new DrawerToggle(), img);
     * Tabs tabs = new Tabs(new Tab("Home"), new Tab("About"));
     * tabs.setOrientation(Tabs.Orientation.VERTICAL); addToDrawer(tabs); }
     */

    public LoginUI() {
        initStyles();

        // layVertical.addClassName("centered-content");
        // layContent.addClassName("centered-content");
        layContent.setWidthFull();
        loginForm.setWidth("20em");
        loginForm.addClassName("centered-content");
        icon.setSize("10em");

        add(layContent);
        // System.out.println(UI.getCurrent().getSession().getAttribute("session"));

        btnLogin.addClickListener(e -> {
            connect();
        });
        btnLogin.addClickShortcut(Key.ENTER);

        if (UI.getCurrent().getSession().getAttribute("session") == null) {

            loginForm.setResponsiveSteps(new FormLayout.ResponsiveStep("2em", 1),
                    new FormLayout.ResponsiveStep("5em", 2));
            loginForm.add(icon, 2);
            loginForm.add(txtUsuario, 2);
            loginForm.add(txtPassword, 2);
            loginForm.add(btnLogin, 2);
            layContent.add(loginForm);

        } else {
            setContent(new App());
        }

        btnLogin.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

    }

    private void connect() {

        try {
            String user = txtUsuario.getValue();
            String pass = txtPassword.getValue();

            // String user = "root";
            // String pass = "123456";

            Session session = Services.getLogin().newLogin(user, pass, Persistence.EMPRESA_GRUPO_UPGRADE_ID);

            UI.getCurrent().getSession().setAttribute("session", session);
            System.out.println(UI.getCurrent().getSession());
            /*
             * for(int i=0; i<session.getPermisos().size(); i++)
             * System.out.println(session.getPermisos().get(i).getAccion());
             */
            // UI.getCurrent().getSession().setAttribute("", new MainView());
            UI.getCurrent().getSession().setAttribute("app", new App());
            // App.setMainView(new MainView());
            // setContent(new App());
            // App.getMainView().setCaption();
            setContent(new App());
            // UI.getCurrent().addWindow(App.getSesion().mainView);

            // close();
        } catch (Exception ex) {
            // ex.printStackTrace();
            notificationError.add(ex.getMessage());
            notificationError.open();
            // Messages.error(ex.getMessage());
        }

    }

    public void setContent(Component component) {
        this.layContent.removeAll();
        add(layContent);
        this.layContent.add(component);
    }

    public final void initStyles() {
        notificationError.setDuration(3000);
        notificationError.setPosition(Notification.Position.TOP_CENTER);
        notificationError.addThemeVariants(NotificationVariant.LUMO_ERROR);

        notificationSuccess.setDuration(3000);
        notificationSuccess.setPosition(Notification.Position.TOP_CENTER);
        notificationSuccess.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
    }

}

package up.erp.server;

import ts.com.service.util.db.CConexion;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppServletContextListener implements ServletContextListener {

    public AppServletContextListener() {

        // TODO Auto-generated constructor stub
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        // TODO Auto-generated method stub

    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            ServletContext sc = servletContextEvent.getServletContext();
            // CConexion.strUrl = "jdbc:postgresql://localhost:9090/upgradedb";

            // LOCAL
            // CConexion.strUrl = "jdbc:postgresql://190.119.207.218:9090/upgrade2db";

            // ----------------------------------------------------------------------
            // OLD
            // ----------------------------------------------------------------------
            // CConexion.strUrl = "jdbc:postgresql://190.117.78.108:9090/upgrade2db";
            // CConexion.strUrl = "jdbc:postgresql://190.117.78.108:9090/upgradedb";
            // ----------------------------------------------------------------------
            // NEW
            // ----------------------------------------------------------------------

            // CConexion.strUrl = "jdbc:postgresql://190.119.207.218:9090/upgrade2db";
            // server
            // CConexion.strUrl = "jdbc:postgresql://190.119.207.218:9090/upgradedb";
            CConexion.strUrl = "jdbc:postgresql://190.119.207.218:9090/bk_up5";

            // ----------------------------------------------------------------------
            CConexion.strDriver = "org.postgresql.Driver";
            CConexion.strUsr = "postgres";
            CConexion.strPwd = "rednavedb2015";

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

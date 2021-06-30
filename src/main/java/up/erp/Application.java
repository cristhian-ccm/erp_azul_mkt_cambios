package up.erp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import ts.com.service.util.db.CConexion;

/**
 * The entry point of the Spring Boot application.
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    @Override
    public void run(String... args) throws Exception {

        // CConexion.strUrl = "jdbc:postgresql://localhost:9090/upgradedb";
        // ----------------------------------------------------------------------
        // OLD
        // ----------------------------------------------------------------------
        // CConexion.strUrl = "jdbc:postgresql://190.117.78.108:9090/upgrade2db";
        // CConexion.strUrl = "jdbc:postgresql://190.117.78.108:9090/upgradedb";
        // ----------------------------------------------------------------------
        // NEW
        // ----------------------------------------------------------------------

        // CConexion.strUrl = "jdbc:postgresql://190.119.207.218:9090/upgrade2db";
        // CConexion.strUrl = "jdbc:postgresql://190.119.207.218:9090/upgradedb";
        CConexion.strUrl = "jdbc:postgresql://190.119.207.218:9090/bk_up5";

        // ----------------------------------------------------------------------

        CConexion.strDriver = "org.postgresql.Driver";
        CConexion.strUsr = "postgres";
        CConexion.strPwd = "rednavedb2015";
    }
}

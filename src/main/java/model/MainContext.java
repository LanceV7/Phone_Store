package model;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MainContext
 *
 */
import javax.servlet.ServletContext;

@WebListener
public class MainContext implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();

        DriverManagerConnectionPool dm = null;
        dm = new DriverManagerConnectionPool();
        context.setAttribute("DriverManager", dm);
        System.out.println("DriverManager creation...."+dm.toString());
    }

    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();

        DriverManagerConnectionPool dm = (DriverManagerConnectionPool) context.getAttribute("DriverManager");
        System.out.println("DriverManager deletion...."+dm.toString());
    }
}
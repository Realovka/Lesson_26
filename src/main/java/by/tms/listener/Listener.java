package by.tms.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener()
public class Listener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    public Listener() {
    }

    public void contextInitialized(ServletContextEvent sce) {
//        sce.getServletContext().setAttribute("users", new ArrayList<>());
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }

    public void sessionCreated(HttpSessionEvent se) {
       try{
            Class.forName("org.postgresql.Driver");
            se.getSession().setAttribute("connection", DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
                    "Vorobei55"));
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }
        public void sessionDestroyed (HttpSessionEvent se){
            Connection connection = (Connection) se.getSession().getAttribute("connection");
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        public void attributeAdded (HttpSessionBindingEvent sbe){
            System.out.println(sbe.getValue());
        }

        public void attributeRemoved (HttpSessionBindingEvent sbe){

        }

        public void attributeReplaced (HttpSessionBindingEvent sbe){

        }
    }

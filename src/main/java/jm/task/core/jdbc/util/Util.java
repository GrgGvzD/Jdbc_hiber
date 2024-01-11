package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {

    private static String userName  = "root";
    private static String password = "MainUser";
    private static String connectionUrl = "jdbc:mysql://localhost:3306/my_db";


    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(connectionUrl, userName, password);
    }
    /////////hib
    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration()
                .setProperty("hibernate.driver_class","com.mysql.cj.jdbc.Driver")
                .setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/my_db")
                .setProperty("hibernate.connection.username","root")
                .setProperty("hibernate.connection.password","MainUser")
                .setProperty("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect")
                .setProperty("hibernate.show_sql","true")
                .setProperty("hibernate.current_session_context_class","thread");

        configuration.addAnnotatedClass(User.class);
        return configuration.addAnnotatedClass(User.class).buildSessionFactory();

    }

    //////////

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConnectionUrl() {
        return connectionUrl;
    }

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }
}

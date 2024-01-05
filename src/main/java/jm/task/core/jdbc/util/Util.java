package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    // реализуйте настройку соеденения с БД
    private String userName;
    private String password;
    private String connectionUrl;

    Connection connection;
    Statement statement;

    public Util() throws ClassNotFoundException, SQLException {
        userName = "root";
        password = "MainUser";
        connectionUrl = "jdbc:mysql://localhost:3306/my_db";
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(connectionUrl, userName, password);
        statement = connection.createStatement();
    }

    public Util(String userName, String password, String connectionUrl) throws ClassNotFoundException, SQLException {
        this.userName = userName;
        this.password = password;
        this.connectionUrl = connectionUrl;
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(connectionUrl, userName, password);
        statement = connection.createStatement();
        System.out.println(" Connected!!!");
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }

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

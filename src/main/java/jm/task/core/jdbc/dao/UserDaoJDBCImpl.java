package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    Util util;

    {
        try {
            util = new Util();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try {
            util.getStatement().executeUpdate("create table User(id INTEGER(255) PRIMARY KEY not null auto_increment," +
                    " name VARCHAR(30), " +
                    "last_name VARCHAR(30), " +
                    "age INTEGER(99))");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        try {
            util.getStatement().executeUpdate("drop table User");
        } catch (SQLException e) {
//            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
//            util.getStatement().executeUpdate("insert into User (name, last_name, age) values ('%s', '%s', '%s')".formatted(name, lastName, age));
            util.getStatement().executeUpdate("insert into User (name, last_name, age) values ('"+name+"', '"+lastName+"', '"+age+"')");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        try {
            util.getStatement().executeUpdate("DELETE FROM User WHERE id='"+ id+"'");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            ResultSet resultSet = util.getStatement().executeQuery("select * from User");
            while (resultSet.next()) {
                User user = new User(resultSet.getString("name"),
                        resultSet.getString("last_name"),
                        resultSet.getByte("age"));
                user.setId(resultSet.getLong("id"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public void cleanUsersTable() {
        try {
            util.getStatement().executeUpdate("TRUNCATE TABLE User");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

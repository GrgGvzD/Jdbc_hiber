package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String testName = "Ivan";
        String testLastName = "Ivanov";
        byte testAge = 5;
        UserServiceImpl userService = new UserServiceImpl();
//        userService.saveUser(testName, testLastName, testAge);
        User user = userService.getAllUsers().get(0);

        System.out.println(user);
    }
}

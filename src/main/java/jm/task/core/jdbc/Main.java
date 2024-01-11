package jm.task.core.jdbc;


import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String testName = "Ivan";
        String testLastName = "Ivanov";
        byte testAge = 5;

        UserServiceImpl userService = new UserServiceImpl();



        userService.dropUsersTable();
        userService.createUsersTable();
        for (int i = 0; i < 4; i++) {
            userService.saveUser(testName + i, testLastName + i, (byte)(testAge + i));
        }

        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
        userService.removeUserById(1);
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}

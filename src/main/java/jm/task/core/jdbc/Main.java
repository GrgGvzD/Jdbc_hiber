package jm.task.core.jdbc;


import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        String testName = "Ivan";
        String testLastName = "Ivanov";
        byte testAge = 5;

        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        for (int i = 0; i < 4; i++) {
            userService.saveUser(testName + i, testLastName + i, (byte)(testAge + i));
        }

        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}

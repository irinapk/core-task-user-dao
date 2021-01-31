package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
        userService.createUsersTable();

        String [] names = {"Alex", "Anthony", "Chester", "Kurt"};
        String [] lastNames = {"Turner", "Kiedes", "Bennington", "Cobain"};
        Byte [] age = {35, 58, 41, 27};

        for (int i = 0; i < 4; i++) {
            userService.saveUser(names[i], lastNames[i], age[i]);
            System.out.println("User с именем " + names[i] + " добавлен в базу данных");
        }

        List<User> usersList = userService.getAllUsers();
        System.out.println(usersList.toString());

        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}

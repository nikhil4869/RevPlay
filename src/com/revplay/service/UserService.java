package com.revplay.service;

import com.revplay.dao.UserDao;
import com.revplay.model.User;

public class UserService {

    private UserDao userDao = new UserDao();

    // 🔹 REGISTER
    public boolean register(String username, String email, String password, String role) {

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role.trim().toUpperCase());

        return userDao.registerUser(user);
    }

    // 🔹 LOGIN
    public User login(String input, String password) {
        return userDao.login(input, password);
    }

    // 🆕 🔹 VERIFY USER FOR FORGOT PASSWORD
    public boolean verifyUser(String email, String username) {
        return userDao.verifyUser(email, username);
    }

    // 🆕 🔹 RESET PASSWORD
    public boolean resetPassword(String email, String newPassword) {
        return userDao.updatePassword(email, newPassword);
    }
}
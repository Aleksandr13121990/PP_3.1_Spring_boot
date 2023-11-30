package ru.krasikov.springboot.dao;


import ru.krasikov.springboot.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getAll();
    public User getUserById(int id);
    public void saveUser(User user);
    public void updateUser(User user);
    public void deleteUser(User user);
}

package ru.krasikov.springboot.service;



import ru.krasikov.springboot.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAll();
    public User getUserById(int id);
    public void saveUser(User user);
    public void updateUser(User user);
    public void deleteUser(User user);
}

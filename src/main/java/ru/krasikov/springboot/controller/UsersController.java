package ru.krasikov.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.krasikov.springboot.model.User;
import ru.krasikov.springboot.service.UserService;


@Controller
@RequestMapping()
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String listUsers(ModelMap modelMap) {
        modelMap.addAttribute("users", userService.getAll());
        return "users/users";
    }

    @GetMapping("/user")
    public String showUser(@RequestParam("id") int id, ModelMap modelMap) {
        modelMap.addAttribute("user", userService.getUserById(id));
        return "users/show-user";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/new-user";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam("id") int id, ModelMap modelMap) {
        modelMap.addAttribute("user", userService.getUserById(id));
        return "users/edit-user";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user, @RequestParam("id") int id) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteUser(@ModelAttribute("user") User user, @RequestParam("id") int id) {
        System.out.println("ID = " + user.getId());
        userService.deleteUser(user);
        return "redirect:/";
    }
}

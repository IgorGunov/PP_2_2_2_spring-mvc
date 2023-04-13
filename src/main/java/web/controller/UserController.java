package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDaoImp;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    private UserService service;
    private UserDaoImp dao;

    @Autowired
    public void setUserDao(UserDaoImp dao) {
        this.dao = dao;
    }

    @Autowired
    public void setUserService(UserService service) {
        this.service = service;
    }
    @GetMapping(value = "users")
    public String getCars(ModelMap model) {
        model.addAttribute("listUsers", dao.get());
        return "users";
    }

    @GetMapping(value = "/{id}")
    public String getCarsOnId(ModelMap model, @PathVariable("id") int id) {
        model.addAttribute("listUsers", dao.get().get(id));
        return "users";
    }

    @GetMapping(value = "/newUser")
    public String newUser(@ModelAttribute("user") User user) {
        return "newUser";
    }

    @PostMapping(value = "new")
    public String addUser(@ModelAttribute("user") User user) {
        dao.create(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/update/{id}")
    public String updateUser(ModelMap model, @PathVariable(value = "id") int id) {
        model.addAttribute("user", dao.get().get(id));
        return "updateUser";
    }

    @PostMapping(value = "/update")
    public String updateUser(ModelMap model, @ModelAttribute("user") User user) {
        dao.update(user);
        model.addAttribute("listUsers", dao.get());
        return "users";
    }

    @GetMapping("/delete/{id}")
    public String delete(ModelMap model, @PathVariable("id") int id) {
        dao.delete(id);
        model.addAttribute("listUsers", dao.get());
        return "users";
    }
}

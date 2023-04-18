package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.Service;

@Controller
public class UserController {

    private Service service;

    @Autowired
    public void setUserService(Service service) {
        this.service = service;
    }

    @GetMapping(value = "users")
    public String getCars(ModelMap model) {
        model.addAttribute("listUsers", service.get());
        return "users";
    }

    @GetMapping(value = "/{id}")
    public String getCarsOnId(ModelMap model, @PathVariable("id") int id) {
        model.addAttribute("listUsers", service.get().get(id));
        return "users";
    }

    @GetMapping(value = "/newUser")
    public String newUser(@ModelAttribute("user") User user) {
        return "newUser";
    }

    @PostMapping(value = "new")
    public String addUser(@ModelAttribute("user") User user) {
        service.create(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/update/{id}")
    public String updateUser(ModelMap model, @PathVariable(value = "id") int id) {
        model.addAttribute("user", service.get(id));
        return "updateUser";
    }

    @PostMapping(value = "/update")
    public String updateUser(ModelMap model, @ModelAttribute("user") User user) {
        service.update(user);
        model.addAttribute("listUsers", service.get());
        return "users";
    }

    @GetMapping("/delete/{id}")
    public String delete(ModelMap model, @PathVariable("id") int id) {
        service.delete(id);
        model.addAttribute("listUsers", service.get());
        return "users";
    }
}
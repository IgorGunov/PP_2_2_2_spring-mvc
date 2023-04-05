package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    CarService service;

    @GetMapping(value = "getCars")
    public String getCars(ModelMap model, @RequestParam(defaultValue = "5") Integer count) {
        List<Car> listCars = new ArrayList<>();
        listCars.add(new Car("qasqai", 2007, 141));
        listCars.add(new Car("lancher", 2015, 160));
        listCars.add(new Car("ls450", 2008, 450));
        listCars.add(new Car("xtrail", 2017, 170));
        listCars.add(new Car("focus", 2009, 2));
        List<Car> newListCars = service.preobrCar(listCars, count);
        System.out.println(newListCars);
        model.addAttribute("listCars", newListCars);
        return "cars";
    }
}

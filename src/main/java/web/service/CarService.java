package web.service;

import web.model.Car;

import java.util.List;

public interface CarService {

    List<Car> preobrCar(List<Car> list, int countCar);
}

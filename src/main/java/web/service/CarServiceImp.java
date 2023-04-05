package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImp implements CarService {
    @Override
    public List<Car> preobrCar(List<Car> list, int countCar) {
        System.out.println(countCar);
        System.out.println(list);
        if (countCar >= 5) {
            return list;
        }
        return list.stream().limit(countCar).collect(Collectors.toList());
    }
}

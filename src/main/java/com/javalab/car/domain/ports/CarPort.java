package com.javalab.car.domain.ports;

import com.javalab.car.domain.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarPort {

    List<Car> getCars();

    Optional<Car> getCarById(Integer id);

    Car addCar(Car car);
}

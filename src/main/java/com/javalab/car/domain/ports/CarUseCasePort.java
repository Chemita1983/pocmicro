package com.javalab.car.domain.ports;

import com.javalab.car.domain.model.Car;

import java.util.List;

public interface CarUseCasePort {

    List<Car> getCars();

    Car getById(Integer id);

    Car postCar(Car car);
}

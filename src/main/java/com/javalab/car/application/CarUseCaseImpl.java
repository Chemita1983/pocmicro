package com.javalab.car.application;

import com.javalab.common.exception.ElementNotFoundException;
import com.javalab.car.domain.model.Car;
import com.javalab.car.domain.ports.CarUseCasePort;
import com.javalab.car.infrastrucure.InMemoryRepositoryCar;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CarUseCaseImpl implements CarUseCasePort {

    private final InMemoryRepositoryCar carsRepository;

    @Override
    public List<Car> getCars() {
        return carsRepository.getCars();
    }

    @Override
    public Car getById(Integer id) {
        return carsRepository.getCarById(id).orElseThrow(ElementNotFoundException::new);
    }

    @Override
    public Car postCar(Car car) {
        return carsRepository.addCar(car);
    }
}

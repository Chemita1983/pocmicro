package com.javalab.car.infrastrucure;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import com.javalab.car.domain.model.Car;
import com.javalab.car.domain.ports.CarPort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class InMemoryRepositoryCar implements CarPort {

    private final List<Car> cars = new ArrayList<>();

    @Override
    public List<Car> getCars() {
        return this.cars;
    }

    @Override
    public Optional<Car> getCarById(final Integer id) {
        return this.cars.stream()
                .filter(car -> car.id().equals(id))
                .findFirst();
    }

    @Override
    public Car addCar(final Car car){
        this.cars.add(car);
        return car;
    }
}

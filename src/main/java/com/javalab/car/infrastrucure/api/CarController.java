package com.javalab.car.infrastrucure.api;

import com.javalab.car.domain.model.Car;
import com.javalab.car.domain.ports.CarUseCasePort;
import com.javalab.car.infrastrucure.mapper.CarMapper;
import com.javalab.openapi.api.CarsApi;
import com.javalab.openapi.api.model.CarDTO;
import com.javalab.openapi.api.model.CarInputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarController implements CarsApi {

    private final CarUseCasePort carsUseCase;

    private final CarMapper carMapper;

    @Override
    public ResponseEntity<List<CarDTO>> carsGet() {

        final List<Car> cars = this.carsUseCase.getCars();

        final List<CarDTO> carsDTO = this.carMapper.toCarsDTO(cars);

        return new ResponseEntity<>(carsDTO,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CarDTO> carsIdGet(Integer id) {

        final Car car = carsUseCase.getById(id);

        final CarDTO carDTO = carMapper.toCarDTO(car);

        return new ResponseEntity<>(carDTO,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CarDTO> carsPost(CarInputDTO carInputDTO) {

        final Car car = carMapper.toCar(carInputDTO);

        final Car carSaved = carsUseCase.postCar(car);

        final CarDTO carResponse = this.carMapper.toCarDTO(carSaved);

        return new ResponseEntity<>(carResponse,HttpStatus.CREATED);
    }
}

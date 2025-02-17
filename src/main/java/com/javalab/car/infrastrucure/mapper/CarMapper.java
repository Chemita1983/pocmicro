package com.javalab.car.infrastrucure.mapper;

import com.javalab.car.domain.model.Car;
import com.javalab.openapi.api.model.CarDTO;
import com.javalab.openapi.api.model.CarInputDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {

    List<CarDTO> toCarsDTO (List<Car> cars);

    CarDTO toCarDTO (Car car);

    Car toCar(CarInputDTO carInputDTO);
}

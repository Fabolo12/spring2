package com.example.demo.mapper;

import com.example.demo.dto.CarDTO;
import com.example.demo.model.Car;

public final class CarMapper {
    private CarMapper() {
    }

    public static CarDTO toDTO(Car car) {
        final CarDTO carDTO = new CarDTO();
        carDTO.setModel(car.getModel());
        carDTO.setDescription(car.getDescription());
        carDTO.setPrice(car.getPrice());
        return carDTO;
    }

    public static Car fromDTO(CarDTO carDTO) {
        final Car car = new Car();
        car.setModel(carDTO.getModel());
        car.setDescription(carDTO.getDescription());
        car.setPrice(carDTO.getPrice());
        return car;
    }
}

package com.example.demo.service;

import com.example.demo.dto.CarDTO;
import com.example.demo.mapper.CarMapper;
import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Iterable<CarDTO> getAll() {
        return StreamSupport.stream(carRepository.findAll().spliterator(), false)
                .map(CarMapper::toDTO)
                .collect(Collectors.toList());
    }

    public String createDefaultCar() {
        final Car car = new Car();
        car.setModel("Default model");
        car.setDescription("Default description");
        car.setPrice(100_000);
        return carRepository.save(car).getId();
    }

    public Iterable<String> getAllIds() {
        return StreamSupport.stream(carRepository.findAll().spliterator(), false)
                .map(Car::getId)
                .collect(Collectors.toList());
    }

    public CarDTO findByModel(String model) {
        if (model.trim().length() == 0) {
            throw new IllegalArgumentException("Model cannot be empty");
        }
        return carRepository.findByModel(model)
                .map(CarMapper::toDTO)
                .orElse(null);
    }

    public CarDTO findById(String id) {
        return carRepository.findById(id)
                .map(CarMapper::toDTO)
                .orElse(null);
    }

    public String create(CarDTO carDTO) {
        final Car car = CarMapper.fromDTO(carDTO);
        return carRepository.save(car).getId();
    }

    public CarDTO update(String id, CarDTO carDTO) {
        final Car car = carRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        car.setModel(carDTO.getModel());
        car.setDescription(carDTO.getDescription());
        car.setPrice(carDTO.getPrice());
        final Car updated = carRepository.save(car);
        return CarMapper.toDTO(updated);
    }

    public void delete(String id) {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
        }
    }
}

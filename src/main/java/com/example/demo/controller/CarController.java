package com.example.demo.controller;

import com.example.demo.dto.CarDTO;
import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public Iterable<CarDTO> getAll() {
        return carService.getAll();
    }

    @GetMapping("/ids")
    public Iterable<String> getAllIds() {
        return carService.getAllIds();
    }

    @GetMapping("/create-default")
    public String createDefaultCar() {
        return carService.createDefaultCar();
    }

    @GetMapping("/model")
    public CarDTO findByModel(@RequestParam String model) {
        return carService.findByModel(model);
    }

    @GetMapping("/show/{id}")
    public CarDTO findById(@PathVariable String id) {
        return carService.findById(id);
    }

    @PostMapping
    public String create(@RequestBody CarDTO carDTO) {
        return carService.create(carDTO);
    }

    @PutMapping("/update/{id}")
    public CarDTO update(@PathVariable String id, @RequestBody CarDTO carDTO) {
        return carService.update(id, carDTO);
    }

    @DeleteMapping
    public void deleted(@RequestParam String id) {
        carService.delete(id);
    }
}

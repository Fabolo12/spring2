package com.example.demo.validator;

import com.example.demo.model.Car;

public final class CarValidator {
    private CarValidator() {
    }

    public static void checkPrice(Car car) {
        if (car.getPrice() % 10 != 0) {
            throw new IllegalArgumentException();
        }
    }
}

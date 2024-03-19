package com.example.demo.car;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    // Retrieve cars based on dynamic filtering criteria
    @GetMapping
    public List<Car> getCar(@RequestParam(required = false) String make,
            @RequestParam(required = false) String bodyType,
            @RequestParam(required = false) Integer seats,
            @RequestParam(required = false) Integer price
    ) {
        List<Specification<Car>> specifications = new ArrayList<>();

        // Add specifications based on provided parameters
        if (make != null) {
            specifications.add(CarSpecifications.attributeEquals("make", make));
        }

        if (bodyType != null) {
            specifications.add(CarSpecifications.attributeEquals("bodyType", bodyType));
        }

        if (seats != null) {
            specifications.add(CarSpecifications.attributeEquals("seats", seats));
        }

        if (price != null) {
            specifications.add(CarSpecifications.attributeLessEq("price", price));
        }

        // Fetch cars based on user selected spec
        return carService.getCar(specifications);
    }

    // Add a new car to the inventory
    @PostMapping("/add")
    public Car addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    // Retrieve all cars without filtering
    @GetMapping("/all")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }
    
}


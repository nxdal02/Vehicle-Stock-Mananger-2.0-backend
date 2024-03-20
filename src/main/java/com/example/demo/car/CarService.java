package com.example.demo.car;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    // Retrieve cars based on dynamic specifications
    public List<Car> getCar(List<Specification<Car>> specifications) {
        // Combine specifications using AND operator
        Specification<Car> finalSpec = specifications.stream()
                .reduce(Specification::and)
                .orElse(null);

        // Fetch cars based on the final specification
        return carRepository.findAll(finalSpec);
    }

    // Retrieve all cars without filtering
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    // Add a new car to the inventory
    public Car addCar(Car car) {
        // Additional business logic, if needed
        return carRepository.save(car);
    }
    
    // Delete car from inventory
    public void deleteCar(long id) {
    	carRepository.deleteById(id);
    }
    
}
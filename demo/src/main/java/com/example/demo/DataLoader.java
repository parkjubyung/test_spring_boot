package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader {
    private final CoffeeRepository coffeeRepository;

    public DataLoader(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @PostConstruct
    private void loadData() {
        try {
            coffeeRepository.saveAll(List.of(
                    new Coffee("Cafe Ceresz"),
                    new Coffee("cafe 2"),
                    new Coffee("cafe 3"),
                    new Coffee("cafe 4")
            ));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.laba1.TextAnal.controller;


import com.laba1.TextAnal.model.Car;
import com.laba1.TextAnal.service.CarAnalyzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    private final CarAnalyzerService carAnalyzerService;

    @Autowired
    public CarController(CarAnalyzerService carAnalyzerService) {
        this.carAnalyzerService = carAnalyzerService;
    }

    @GetMapping("/analyze")
    public Car analyzeText(@RequestParam String text) {
        return carAnalyzerService.analyzeText(text);
    }
}
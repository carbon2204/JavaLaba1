package com.laba1.TextAnal.service;

import com.laba1.TextAnal.model.Car;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CarAnalyzerService {

    public Car analyzeText(String text) {
        Car car = new Car();

        // Регулярные выражения для поиска VIN, марки, модели и года автомобиля
        String vinRegex = "VIN:\\s*([A-Za-z0-9]+)";
        String brandRegex = "Бренд:\\s*([A-Za-z0-9]+)";
        String modelRegex = "Модель:\\s*([A-Za-z0-9\\s]+)";
        String yearRegex = "Год:\\s*(\\d{4})";

        // Поиск VIN
        Pattern vinPattern = Pattern.compile(vinRegex);
        Matcher vinMatcher = vinPattern.matcher(text);
        if (vinMatcher.find()) {
            car.setVin(vinMatcher.group(1));
        }

        // Поиск марки
        Pattern brandPattern = Pattern.compile(brandRegex);
        Matcher brandMatcher = brandPattern.matcher(text);
        if (brandMatcher.find()) {
            car.setBrand(brandMatcher.group(1));
        }

        // Поиск модели
        Pattern modelPattern = Pattern.compile(modelRegex);
        Matcher modelMatcher = modelPattern.matcher(text);
        if (modelMatcher.find()) {
            car.setModel(modelMatcher.group(1));
        }

        // Поиск года
        Pattern yearPattern = Pattern.compile(yearRegex);
        Matcher yearMatcher = yearPattern.matcher(text);
        if (yearMatcher.find()) {
            car.setYear(Integer.parseInt(yearMatcher.group(1)));
        }

        return car;
    }
}
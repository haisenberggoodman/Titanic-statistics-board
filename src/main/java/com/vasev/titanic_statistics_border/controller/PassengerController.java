package com.vasev.titanic_statistics_border.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import com.vasev.titanic_statistics_border.model.Passenger;
import com.vasev.titanic_statistics_border.model.PassengerStats;
import com.vasev.titanic_statistics_border.service.PassengerService;

import java.util.List;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @GetMapping
    public Page<Passenger> getPassengers(Pageable pageable,
            @RequestParam(required = false) Boolean survived,
            @RequestParam(required = false) Boolean adult,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) Boolean noRelatives,
            @RequestParam(required = false) String name) {
        if (survived != null) {
            return new PageImpl<>(passengerService.getSurvivors(), pageable, passengerService.getSurvivors().size());
        } else if (adult != null) {
            return new PageImpl<>(passengerService.getAdults(), pageable, passengerService.getAdults().size());
        } else if (gender != null) {
            return new PageImpl<>(passengerService.getMalePassengers(), pageable,
                    passengerService.getMalePassengers().size());
        } else if (noRelatives != null) {
            return new PageImpl<>(passengerService.getPassengersWithoutRelatives(), pageable,
                    passengerService.getPassengersWithoutRelatives().size());
        } else {
            return passengerService.getAllPassengers(pageable);
        }
    }

    @GetMapping("/stats")
    public PassengerStats getPassengerStats() {
        return passengerService.getPassengerStats();
    }
}

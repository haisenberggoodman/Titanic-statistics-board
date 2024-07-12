package com.vasev.titanic_statistics_border.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vasev.titanic_statistics_border.model.Passenger;
import com.vasev.titanic_statistics_border.model.PassengerStats;
import com.vasev.titanic_statistics_border.repository.PassengerRepository;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Cacheable("passengers")
    public Page<Passenger> getAllPassengers(Pageable pageable) {
        return passengerRepository.findAll(pageable);
    }

    @Cacheable("stats")
    public PassengerStats getPassengerStats() {
        List<Passenger> passengers = passengerRepository.findAll();
        PassengerStats stats = new PassengerStats();

        stats.setTotalFare(passengers.stream().mapToDouble(Passenger::getFare).sum());
        stats.setTotalWithRelatives(passengers.stream().filter(p -> p.getSibSp() > 0 || p.getParch() > 0).count());
        stats.setTotalSurvived(passengers.stream().filter(Passenger::getSurvived).count());

        return stats;
    }

    public List<Passenger> getSurvivors() {
        return passengerRepository.findAll().stream()
                .filter(Passenger::getSurvived)
                .collect(Collectors.toList());
    }

    public List<Passenger> getAdults() {
        return passengerRepository.findAll().stream()
                .filter(p -> p.getAge() != null && p.getAge() > 16)
                .collect(Collectors.toList());
    }

    public List<Passenger> getMalePassengers() {
        return passengerRepository.findAll().stream()
                .filter(p -> "male".equalsIgnoreCase(p.getSex()))
                .collect(Collectors.toList());
    }

    public List<Passenger> getPassengersWithoutRelatives() {
        return passengerRepository.findAll().stream()
                .filter(p -> p.getSibSp() == 0 && p.getParch() == 0)
                .collect(Collectors.toList());
    }
}
package com.vasev.titanic_statistics_border.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vasev.titanic_statistics_border.entities.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    // Дополнительные методы для поиска можно определить здесь, если необходимо
}

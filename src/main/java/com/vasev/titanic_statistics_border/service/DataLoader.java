package com.vasev.titanic_statistics_border.service;

import jakarta.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vasev.titanic_statistics_border.model.Passenger;
import com.vasev.titanic_statistics_border.model.Pclass;
import com.vasev.titanic_statistics_border.repository.PassengerRepository;

@Component
public class DataLoader {
    @Autowired
    private PassengerRepository passengerRepository;

    @PostConstruct
    public void loadData() {
        if (passengerRepository.count() == 0) {
            try {
                URL url = new URL("https://web.stanford.edu/class/archive/cs/cs109/cs109.1166/stuff/titanic.csv");
                BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

                List<Passenger> passengers = in.lines().skip(1).map(line -> {
                    String[] fields = line.split(",");
                    Passenger passenger = new Passenger();
                    passenger.setSurvived((fields[0]).equals("1"));
                    int pclassValue = Integer.parseInt(fields[1]); 
                    passenger.setPclass(Pclass.fromInt(pclassValue)); 
                    // passenger.setPclass(Pclass.valueOf(fields[1]));
                    passenger.setName(fields[2]);
                    passenger.setSex(fields[3]);
                    passenger.setAge(fields[4].isEmpty() ? null : (int) Math.round(Double.parseDouble(fields[4])));
                    passenger.setSibSp(Integer.parseInt(fields[5]));
                    passenger.setParch(Integer.parseInt(fields[6]));
                    passenger.setFare(Float.parseFloat(fields[7]));
                    return passenger;
                }).collect(Collectors.toList());

                passengerRepository.saveAll(passengers);
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

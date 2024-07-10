package com.vasev.titanic_statistics_border.entities;

import jakarta.persistence.*;

@Entity
public class Passenger {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;
    private Float fare;
    private Boolean survived;

    @Enumerated(EnumType.STRING)
    private Pclass pclass;

    private Integer sibSp;
    private Integer parch;
    private String sex;

    // Getters and Setters
}

public enum Pclass {
    FIRST,
    SECOND,
    THIRD
}

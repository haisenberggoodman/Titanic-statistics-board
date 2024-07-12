package com.vasev.titanic_statistics_border.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
public class Passenger {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private Integer age;
    @Getter
    @Setter
    private Float fare;
    @Getter
    @Setter
    private Boolean survived;

    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private Pclass pclass;
    @Getter
    @Setter
    private Integer sibSp;
    @Getter
    @Setter
    private Integer parch;
    @Getter
    @Setter
    private String sex;
}

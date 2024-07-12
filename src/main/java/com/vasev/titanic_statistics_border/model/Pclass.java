package com.vasev.titanic_statistics_border.model;

public enum Pclass {
    FIRST(1),
    SECOND(2),
    THIRD(3);

    private final int value;

    Pclass(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Pclass fromInt(int value) {
        for (Pclass pclass : Pclass.values()) {
            if (pclass.getValue() == value) {
                return pclass;
            }
        }
        throw new IllegalArgumentException("No enum constant with value " + value);
    }
}
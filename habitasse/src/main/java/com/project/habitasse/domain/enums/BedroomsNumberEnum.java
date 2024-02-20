package com.project.habitasse.domain.enums;


import lombok.Getter;

@Getter
public enum BedroomsNumberEnum {

    ONE("Um", 1),
    TWO("Dois", 2),
    THREE("Três", 3),
    FOUR("Quatro", 4),
    FIVE_OR_MORE("Cinco ou mais", 5);

    private final String desciption;
    private final Integer value;

    BedroomsNumberEnum(String desciption, Integer value) {
        this.desciption = desciption;
        this.value = value;
    }

    public boolean isOne() {
        return this.equals(ONE);
    }
    public boolean isTwo() {
        return this.equals(TWO);
    }
    public boolean isThree() {
        return this.equals(THREE);
    }
    public boolean isFour() {
        return this.equals(FOUR);
    }
    public boolean isFiveOrMore() {
        return this.equals(FIVE_OR_MORE);
    }
}

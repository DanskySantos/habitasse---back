package com.project.habitasse.domain.enums;


import lombok.Getter;

@Getter
public enum BedroomsNumberEnum {

    ONE("1", 1),
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE_OR_MORE("5", 5);

    private final String desciption;
    private final Integer value;

    BedroomsNumberEnum(String desciption, Integer value) {
        this.desciption = desciption;
        this.value = value;
    }

    public static BedroomsNumberEnum getByDescription(String description) {
        for (BedroomsNumberEnum bedroomsNumber : values()) {
            if (bedroomsNumber.getDesciption().equals(description)) {
                return bedroomsNumber;
            }
        }
        throw new IllegalArgumentException("No enum constant found with description: " + description);
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

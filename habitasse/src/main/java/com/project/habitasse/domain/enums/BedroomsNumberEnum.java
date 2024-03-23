package com.project.habitasse.domain.enums;


import lombok.Getter;

@Getter
public enum BedroomsNumberEnum {

    ONE("Um quarto", 1),
    TWO("Dois quartos", 2),
    THREE("Três quartos", 3),
    FOUR("Quatro quartos", 4),
    FIVE_OR_MORE("Cinco ou mais quartos", 5);

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

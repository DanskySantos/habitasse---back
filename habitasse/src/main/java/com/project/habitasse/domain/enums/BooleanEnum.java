package com.project.habitasse.domain.enums;


import lombok.Getter;

@Getter
public enum BooleanEnum {

    YES("Sim"),
    NO("Não"),
    INDIFFERENT("Indiferente");

    private final String description;

    BooleanEnum(String desciption) {
        this.description = desciption;
    }

    public static BooleanEnum getByDescription(String description) {
        for (BooleanEnum booleanEnum : values()) {
            if (booleanEnum.getDescription().equals(description)) {
                return booleanEnum;
            }
        }
        throw new IllegalArgumentException("No enum constant found with description: " + description);
    }

    public boolean isYes() {
        return this.equals(YES);
    }
    public boolean isNo() {
        return this.equals(NO);
    }
    public boolean isIndifferent() {
        return this.equals(INDIFFERENT);
    }
}

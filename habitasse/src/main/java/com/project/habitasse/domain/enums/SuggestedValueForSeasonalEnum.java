package com.project.habitasse.domain.enums;


import lombok.Getter;

@Getter
public enum SuggestedValueForSeasonalEnum {

    R$200("R$ 200,00", 200),
    R$400("R$ 400,00", 400),
    R$800("R$ 800,00", 800),
    R$1500("R$ 1.500,00", 1500),
    R$2000("R$ 2.000,00", 2000),
    R$2500("R$ 2.500,00", 2500),
    R$3000("R$ 3.000,00", 3000),
    R$5000("R$ 5.000,00", 5000);

    private final String desciption;
    private final Integer value;

    SuggestedValueForSeasonalEnum(String desciption, Integer value) {
        this.desciption = desciption;
        this.value = value;
    }

    public static SuggestedValueForSeasonalEnum getByDescription(String description) {
        for (SuggestedValueForSeasonalEnum suggestedValueForSeasonal : values()) {
            if (suggestedValueForSeasonal.getDesciption().equals(description)) {
                return suggestedValueForSeasonal;
            }
        }
        throw new IllegalArgumentException("No enum constant found with description: " + description);
    }

    public boolean is200() {
        return this.equals(R$200);
    }
    public boolean is400() {
        return this.equals(R$400);
    }
    public boolean is800() {
        return this.equals(R$800);
    }
    public boolean is1500() {
        return this.equals(R$1500);
    }
    public boolean is2000() {
        return this.equals(R$2000);
    }
    public boolean is2500() {
        return this.equals(R$2500);
    }
    public boolean is3000() {
        return this.equals(R$3000);
    }
    public boolean is5000() {
        return this.equals(R$5000);
    }
}

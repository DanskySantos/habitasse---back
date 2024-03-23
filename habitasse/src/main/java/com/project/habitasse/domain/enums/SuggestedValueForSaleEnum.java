package com.project.habitasse.domain.enums;


import lombok.Getter;

@Getter
public enum SuggestedValueForSaleEnum {

    R$400K("R$ 400.000,00", 400000),
    R$800K("R$ 800.000,00", 800000),
    R$1200K("R$ 1.200.000,00", 1200000),
    R$1600K("R$ 1.600.000,00", 1600000),
    R$2000K("R$ 2.000.000,00", 2000000),
    R$2400K("R$ 2.400.000,00", 2400000),
    R$5000K("R$ 5.000.000,00", 5000000),
    R$10000K("R$ 10.000.000,00", 10000000),
    R$15000K("R$ 15.000.000,00", 15000000),
    R$20000K("R$ 20.000.000,00", 20000000);

    private final String description;
    private final Integer value;

    SuggestedValueForSaleEnum(String desciption, Integer value) {
        this.description = desciption;
        this.value = value;
    }

    public static SuggestedValueForSaleEnum getByDescription(String description) {
        for (SuggestedValueForSaleEnum suggestedValueForSale : values()) {
            if (suggestedValueForSale.getDescription().equals(description)) {
                return suggestedValueForSale;
            }
        }
        throw new IllegalArgumentException("No enum constant found with description: " + description);
    }

    public boolean is400K() {
        return this.equals(R$400K);
    }
    public boolean is800K() {
        return this.equals(R$800K);
    }
    public boolean is1200K() {
        return this.equals(R$1200K);
    }
    public boolean is1600K() {
        return this.equals(R$1600K);
    }
    public boolean is2000K() {
        return this.equals(R$2000K);
    }
    public boolean is$2400K() {
        return this.equals(R$2400K);
    }
    public boolean is5000K() {
        return this.equals(R$5000K);
    }
    public boolean is10000K() {
        return this.equals(R$10000K);
    }
    public boolean is15000K() {
        return this.equals(R$15000K);
    }
}

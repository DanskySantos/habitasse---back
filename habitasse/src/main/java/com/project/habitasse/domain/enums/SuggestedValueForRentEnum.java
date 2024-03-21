package com.project.habitasse.domain.enums;


import lombok.Getter;

@Getter
public enum SuggestedValueForRentEnum {

    R$1K("R$ 1.000,00", 1000),
    R$2K("R$ 2.000,00", 2000),
    R$3K("R$ 3.000,00", 3000),
    R$4K("R$ 4.000,00", 4000),
    R$5K("R$ 5.000,00", 5000),
    R$6K("R$ 6.000,00", 6000),
    R$10K("R$ 10.000,00", 10000),
    R$15K("R$ 15.000,00", 15000);

    private final String description;
    private final Integer value;

    SuggestedValueForRentEnum(String description, Integer value) {
        this.description = description;
        this.value = value;
    }

    public static SuggestedValueForRentEnum getByDescription(String description) {
        for (SuggestedValueForRentEnum suggestedValueForRent : values()) {
            if (suggestedValueForRent.getDescription().equalsIgnoreCase(description)) {
                return suggestedValueForRent;
            }
        }
        throw new IllegalArgumentException("No enum constant found with description: " + description);
    }

    public boolean is1k() {
        return this.equals(R$1K);
    }
    public boolean is2k() {
        return this.equals(R$2K);
    }
    public boolean is3k() {
        return this.equals(R$3K);
    }
    public boolean is4k() {
        return this.equals(R$4K);
    }
    public boolean is5k() {
        return this.equals(R$5K);
    }
    public boolean is6k() {
        return this.equals(R$6K);
    }
    public boolean is10k() {
        return this.equals(R$10K);
    }
    public boolean is15k() {
        return this.equals(R$15K);
    }
}

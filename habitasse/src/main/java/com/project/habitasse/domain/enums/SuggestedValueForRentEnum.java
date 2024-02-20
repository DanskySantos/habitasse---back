package com.project.habitasse.domain.enums;


import lombok.Getter;

@Getter
public enum SuggestedValueForRentEnum {

    R$1K("Mil Reais", 1000),
    R$2K("Dois Mil Reais", 2000),
    R$3K("Três Mil Reais", 3000),
    R$4K("Quatro Mil Reais", 4000),
    R$5K("Cinco Mil Reais", 5000),
    R$6K("Seis Mil Reais", 6000),
    R$10K("Dez Mil Reais", 10000),
    R$15K("Quinze Mil Reais", 15000);

    private final String desciption;
    private final Integer value;

    SuggestedValueForRentEnum(String desciption, Integer value) {
        this.desciption = desciption;
        this.value = value;
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

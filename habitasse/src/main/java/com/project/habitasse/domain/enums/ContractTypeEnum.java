package com.project.habitasse.domain.enums;


import lombok.Getter;

@Getter
public enum ContractTypeEnum {

    RENT("Locação"),
    SALE("Venda"),
    SEASONAL("Temporada");

    private final String desciption;

    ContractTypeEnum(String desciption) {
        this.desciption = desciption;
    }

    public boolean isRent() {
        return this.equals(RENT);
    }

    public boolean isSale() {
        return this.equals(SALE);
    }

    public boolean isSeasonal() {
        return this.equals(SEASONAL);
    }
}

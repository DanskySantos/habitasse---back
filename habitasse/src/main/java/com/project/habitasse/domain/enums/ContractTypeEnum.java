package com.project.habitasse.domain.enums;


import lombok.Getter;

@Getter
public enum ContractTypeEnum {

    RENT("Locação"),
    SALE("Venda"),
    SEASONAL("Temporada");

    private final String description;

    ContractTypeEnum(String description) {
        this.description = description;
    }

    public static ContractTypeEnum getByDescription(String description) {
        for (ContractTypeEnum contractType : values()) {
            if (contractType.getDescription().equals(description)) {
                return contractType;
            }
        }
        throw new IllegalArgumentException("No enum constant found with description: " + description);
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

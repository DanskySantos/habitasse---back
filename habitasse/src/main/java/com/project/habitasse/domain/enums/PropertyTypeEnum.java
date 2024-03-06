package com.project.habitasse.domain.enums;


import lombok.Getter;

@Getter
public enum PropertyTypeEnum {

    HOUSE("Casa"),
    APARTMENT("Apartamento"),
    COMMERCIAL("Ponto Comercial"),
    ALLOTMENT("Loteamento"),
    FARM("Sítio/Fazenda/Chácara");

    private final String desciption;

    PropertyTypeEnum(String desciption) {
        this.desciption = desciption;
    }

    public static PropertyTypeEnum getByDescription(String description) {
        for (PropertyTypeEnum propertyType : values()) {
            if (propertyType.getDesciption().equals(description)) {
                return propertyType;
            }
        }
        throw new IllegalArgumentException("No enum constant found with description: " + description);
    }

    public boolean isHouse() {
        return this.equals(HOUSE);
    }

    public boolean isApartment() {
        return this.equals(APARTMENT);
    }

    public boolean isCommercial() {
        return this.equals(COMMERCIAL);
    }
    public boolean isAllotment() {
        return this.equals(ALLOTMENT);
    }
    public boolean isFarm() {
        return this.equals(FARM);
    }
}

package com.project.habitasse.outside.enums;

import lombok.Getter;

@Getter
public enum PlansEnum {

    PLANO_BASICO(6999.0),
    PLANO_ESSENCIAL(11999.0),
    PLANO_PRO(57599.0),
    PLANO_PREMIUM(115099.0);

    private final Double value;

    PlansEnum(Double value) {
        this.value = value;
    }

    public static PlansEnum getByValue(Double value) {
        for (PlansEnum plansEnum : values()) {
            if (plansEnum.getValue().equals(value)) {
                return plansEnum;
            }
        }
        throw new IllegalArgumentException("No plan found with value: " + value);
    }

    public boolean isSemanal() {
        return this.equals(PLANO_BASICO);
    }

    public boolean isEssencial() {
        return this.equals(PLANO_ESSENCIAL);
    }

    public boolean isPro() {
        return this.equals(PLANO_PRO);
    }

    public boolean isPremium() {
        return this.equals(PLANO_PREMIUM);
    }
}

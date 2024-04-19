package com.project.habitasse.outside.enums;

import lombok.Getter;

@Getter
public enum PlansEnum {

    PLANO_SEMANAL(3999.0),
    PLANO_QUINZENAL(6999.0),
    PLANO_MENSAL(11999.0),
    PLANO_PREMIUM(59999.0);

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
        return this.equals(PLANO_SEMANAL);
    }

    public boolean isQuinzenal() {
        return this.equals(PLANO_QUINZENAL);
    }

    public boolean isMensal() {
        return this.equals(PLANO_MENSAL);
    }

    public boolean isPremium() {
        return this.equals(PLANO_PREMIUM);
    }
}

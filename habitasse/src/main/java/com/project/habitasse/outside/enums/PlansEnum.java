package com.project.habitasse.outside.enums;

import lombok.Getter;

@Getter
public enum PlansEnum {

    PLANO_BASICO(1),
    PLANO_ESSENCIAL(2),
    PLANO_PRO(3),
    PLANO_PREMIUM(4);

    private final Integer value;

    PlansEnum(Integer value) {
        this.value = value;
    }

    public static PlansEnum getByReference(Integer value) {
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

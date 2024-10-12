package com.project.habitasse.outside.enums;

import lombok.Getter;

@Getter
public enum PlansEnum {

    PLANO_ESSENCIAL(1),
    PLANO_PRO(2),
    PLANO_PREMIUM(3),
    PERIODO_GRATUIDADE(4);

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

    public boolean isEssencial() {
        return this.equals(PLANO_ESSENCIAL);
    }

    public boolean isPro() {
        return this.equals(PLANO_PRO);
    }

    public boolean isPremium() {
        return this.equals(PLANO_PREMIUM);
    }

    public boolean isGratuidade(){
        return this.equals(PERIODO_GRATUIDADE);
    }
}

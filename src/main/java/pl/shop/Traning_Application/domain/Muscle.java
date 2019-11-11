package pl.shop.Traning_Application.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public enum Muscle {
    Barki("Barki"),
    Klatka("Klatka"),
    Plecy("Plecy"),
    Nogi("Nogi"),
    Brzuch("Brzuch");

    private String name;

    Muscle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

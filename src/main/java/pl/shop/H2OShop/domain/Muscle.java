package pl.shop.H2OShop.domain;

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

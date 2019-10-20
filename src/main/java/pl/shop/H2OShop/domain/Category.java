package pl.shop.H2OShop.domain;

public enum Category {
    Sztanga("Sztanga"),
    Hantle("Hantle"),
    Maszyna("Hantle"),
    MasaWlasnegoCiala("Masa Wlasnego Ciala"),
    Kardio("Kardio");

    private String name;

    Category(String name) {
        this.name = name;
    }
}

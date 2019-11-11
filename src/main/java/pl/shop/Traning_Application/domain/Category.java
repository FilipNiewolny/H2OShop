package pl.shop.Traning_Application.domain;


public enum Category {
    Sztanga("Sztanga"),
    Hantle("Hantle"),
    Maszyna("Maszyna"),
    MasaWlasnegoCiala("Masa Wlasnego Ciala"),
    Kardio("Kardio");

    private String name;

    Category(String name) {
        this.name = name;
    }
}

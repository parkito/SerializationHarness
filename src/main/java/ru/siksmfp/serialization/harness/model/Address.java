package ru.siksmfp.serialization.harness.model;

public class Address {

    private Long id;
    private String city;
    private int population;

    public Address(Long id, String city, int population) {
        this.id = id;
        this.city = city;
        this.population = population;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}

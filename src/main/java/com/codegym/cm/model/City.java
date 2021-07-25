package com.codegym.cm.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 4, max = 30)
    private String name;

    @Min(15)
    private double acreage;

    @Min(10)
    private double population;

    @Min(10)
    private double GDP;
    private String description;

    @ManyToOne
    @JoinColumn(name = "countries_id")
    private Country country;

    public City() {
    }

    public City(Long id, String name, double acreage, double population, double GDP, String description, Country country) {
        this.id = id;
        this.name = name;
        this.acreage = acreage;
        this.population = population;
        this.GDP = GDP;
        this.description = description;
        this.country = country;
    }

    public City(String name, double acreage, double population, double GDP, String description, Country country) {
        this.name = name;
        this.acreage = acreage;
        this.population = population;
        this.GDP = GDP;
        this.description = description;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAcreage() {
        return acreage;
    }

    public void setAcreage(double acreage) {
        this.acreage = acreage;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public double getGDP() {
        return GDP;
    }

    public void setGDP(double GDP) {
        this.GDP = GDP;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}

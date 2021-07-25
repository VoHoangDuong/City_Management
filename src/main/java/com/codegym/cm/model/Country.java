package com.codegym.cm.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 4, max = 30)
    private String name;

    @OneToMany(targetEntity = City.class, fetch = FetchType.EAGER)
    private List<City> cities;

    public Country() {
    }

    public Country(Long id, String name, List<City> cities) {
        this.id = id;
        this.name = name;
        this.cities = cities;
    }

    public Country(String name, List<City> cities) {
        this.name = name;
        this.cities = cities;
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

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}

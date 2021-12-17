package ua.univer.finTask.BLL;

import java.io.Serializable;

public class City implements Serializable {
    private int id;
    private Country country;
    private String name;
    private int population;
    private boolean capital;

    public City(){}
    public City(int id, Country country, String name, int population) {
        this.id = id;
        this.country = country;
        this.name = name;
        this.population = population;
        this.capital=false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public boolean getCapital() {
        return capital;
    }

    public void setCapital(boolean iscapital) {
        this.capital = iscapital;
    }

    @Override
    public String toString() {
        return "\nCity{" +
                "id=" + id +
                ", country=" + country +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", capital='" + capital + '\'' +
                '}';
    }
}

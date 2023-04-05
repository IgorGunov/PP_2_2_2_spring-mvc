package web.model;

public class Car {

    private String model;
    private int year;
    private int ls;

    public Car(String model, int year, int ls) {
        this.model = model;
        this.year = year;
        this.ls = ls;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getLs() {
        return ls;
    }

    public void setLs(int ls) {
        this.ls = ls;
    }
}

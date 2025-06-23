package ru.top.academy.Car;

public class Car {

    int id;
    String name;

    public Car(int id, String name) {

        this.id = id;
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {

        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';

    }

}

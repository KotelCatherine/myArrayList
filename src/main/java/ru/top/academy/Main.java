package ru.top.academy;

import ru.top.academy.Animal.Cat;
import ru.top.academy.Animal.Dog;
import ru.top.academy.Animal.Croc;
import ru.top.academy.Animal.Animal;
import ru.top.academy.Car.Car;
import ru.top.academy.Car.Subaru;
import ru.top.academy.Car.Toyota;
import ru.top.academy.interfaceMyArrayList.MyList;

import java.util.Comparator;


public class Main {

    static Animal dog = new Dog("dog", 5);
    static Animal cat = new Cat("cat", 2);
    static Animal crocodile = new Croc("croc", 15);
    static Car subaru = new Subaru(488, "wrx");
    static Car toyota = new Toyota(448, "levin");

    public static void main(String[] args) {

        MyList<Animal> listAnimal = new MyArrayList<>();
        MyList<Integer> listInt = new MyArrayList<>();
        MyList<Car> carMyList = new MyArrayList<>();

        listInt.add(5);
        listInt.add(55);
        listInt.add(15);
        listInt.add(0);
        listInt.add(1);

        listAnimal.add(crocodile);
        listAnimal.add(crocodile);
        listAnimal.add(dog);
        listAnimal.add(dog);
        listAnimal.add(crocodile);

        carMyList.add(subaru);
        carMyList.add(toyota);


        carMyList.sort(Comparator.comparing(Car::getName));
        System.out.println(carMyList);

        Utils.quickSort(listInt);
        Utils.quickSort(listAnimal);

        System.out.println(listInt);

        listInt.sort(Comparator.reverseOrder());
        System.out.println(listInt);

        System.out.println(listAnimal);


        listAnimal.add(dog);
        listAnimal.add(crocodile);
        listAnimal.add(dog);
        listAnimal.add(cat);

        listAnimal.sort(Comparator.comparing(Animal::getName));
        System.out.println(listAnimal);


    }

}

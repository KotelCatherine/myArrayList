package ru.top.academy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.top.academy.Animal.Animal;
import ru.top.academy.Animal.Cat;
import ru.top.academy.Animal.Croc;
import ru.top.academy.Animal.Dog;
import ru.top.academy.Car.Car;
import ru.top.academy.Car.Subaru;
import ru.top.academy.Car.Toyota;
import ru.top.academy.interfaceMyArrayList.MyList;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UtilsTest {

    MyList<Integer> listInt;
    MyList<Animal> listAnimal;
    MyList<Car> listCar;

    Animal dog;
    Animal cat;
    Animal crocodile;

    Car subaru;
    Car toyotaAqua;
    Car toyotaLevin;

    @BeforeEach
    void init() {

        listInt = new MyArrayList<>();
        listCar = new MyArrayList<>();
        listAnimal = new MyArrayList<>();

        dog = new Dog("dog", 5);
        cat = new Cat("cat", 2);
        crocodile = new Croc("croc", 15);

        subaru = new Subaru(488, "wrx");
        toyotaLevin = new Toyota(448, "levin");
        toyotaAqua = new Toyota(248, "aqua");

        listInt.add(5);
        listInt.add(55);
        listInt.add(15);
        listInt.add(0);
        listInt.add(1);

        listAnimal.add(dog);
        listAnimal.add(crocodile);
        listAnimal.add(dog);
        listAnimal.add(cat);

        listCar.add(subaru);
        listCar.add(toyotaAqua);
        listCar.add(toyotaLevin);

    }

    @AfterEach
    void clean() {

        listInt = null;
        listCar = null;
        listAnimal = null;

        dog = null;
        cat = null;
        crocodile = null;

        subaru = null;
        toyotaAqua = null;
        toyotaLevin = null;

    }

    @Test
    void quickSortListImplComparable_whenListIsNotEmpty_thenTrue() {

        Utils.quickSort(listInt);
        Utils.quickSort(listAnimal);

        assertEquals(0, listInt.get(0));
        assertEquals(1, listInt.get(1));
        assertEquals(5, listInt.get(2));
        assertEquals(15, listInt.get(3));
        assertEquals(55, listInt.get(4));

        assertEquals(cat, listAnimal.get(0));
        assertEquals(crocodile, listAnimal.get(1));
        assertEquals(dog, listAnimal.get(3));

    }

    @Test
    void quickSortListImplComparable_whenListIsEmpty_thenTrow() {

        listInt = null;

        assertThrows(NullPointerException.class, () -> Utils.quickSort(listInt));

    }

    @Test
    void quickSortWithComparator_whenListIsNotEmpty_thenTrue() {

        listCar.sort(Comparator.comparing(Car::getId));
        listInt.sort(Comparator.reverseOrder());

        assertEquals(toyotaAqua, listCar.get(0));
        assertEquals(subaru, listCar.get(2));

        assertEquals(55, listInt.get(0));
        assertEquals(15, listInt.get(1));
        assertEquals(5, listInt.get(2));
        assertEquals(1, listInt.get(3));
        assertEquals(0, listInt.get(4));

    }

    @Test
    void quickSortWithComparator_whenListIsEmpty_thenThrow() {

        listCar = null;

        assertThrows(NullPointerException.class, () -> listCar.sort(Comparator.comparing(Car::getName)));

    }

}

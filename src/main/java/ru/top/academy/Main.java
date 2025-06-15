package ru.top.academy;


import ru.top.academy.Animal.*;
import ru.top.academy.interfaceMyArrayList.MyList;


public class Main {

    static MyList<Animal> list = new MyArrayList<>();
    static Animal dog = new Dog("dog", 5);
    static Animal cat = new Cat("cat", 2);
    static Animal crocodile = new Croc("croc", 15);

    public static void main(String[] args) {

        addElements();
        getElements();


        System.out.println("\nДобавление элемента congo -> " + list.add(3, new Congo("congo", 15)));
        System.out.println("Список до сортировки" + list);

        list.sort(Animal::compareTo);

        System.out.println("Список после сортировки" + list);
        System.out.println("Поиск индекса у элемента cat -> " + list.indexOf(cat));
        System.out.println("Удаленный элемент с индексом 0 -> " + list.remove(0));

        list.remove(cat);

        System.out.println("Список после удаления элемента cat -> " + list);
        System.out.println("Размер массива -> " + list.size());

        list.clear();

        System.out.println("Список после очищения -> " + list);

    }

    /**
     * Получение списка элементов
     */
    private static void getElements() {

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

    }

    /**
     * Добавление элементов в список
     */
    private static void addElements() {

        list.add(crocodile);
        list.add(dog);
        list.add(cat);

    }

}

package ru.top.academy;


public class Main {

    static MyArrayList<Character> list = new MyArrayList<>();

    /**
     * Точка входа в программу. Демонстрация работы методов класса MyArrayList
     *
     * @param args
     */
    public static void main(String[] args) {

        addElements();
        getElements();


        System.out.println("\nДобавление элемента 125 -> " + list.add(3, '@'));
        System.out.println("Список до сортировки" + list);

        list.sort();

        System.out.println("Список после сортировки" + list);
        System.out.println("Поиск индекса у элемента '?' -> " + list.indexOf('?'));
        System.out.println("Удаленный элемент с индексом 0 -> " + list.remove(0));

        list.remove((Character) '<');

        System.out.println("Список после удаления элемента 125 -> " + list);
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

        for (int i = 0; i < 15; i++) {
            list.add((char) (i + 50));
        }

    }

}
package ru.top.academy.interfaceMyArrayList;

import java.util.Comparator;

public interface MyList<E> {

    /**
     * Добавление элемента в массив
     *
     * @param element принимает на вход элемент
     * @return возвращает булево значение в случае успешного добавления - true, если же не получилось добавить - false
     */
    boolean add(E element);

    /**
     * Добавление элемента по индексу
     *
     * @param index   индекс
     * @param element элемент
     * @return возвращает булево значение в случае успешного добавления - true, если же не получилось добавить - false
     */
    boolean add(int index, E element);

    /**
     * Удаление элемента
     *
     * @param element принимает на вход элемент необходимый для удаления
     * @return возвращает булево значение в случае успешного удаления - true, если же не получилось - false
     * @throws IndexOutOfBoundsException может бросать исключение
     */
    boolean remove(E element);

    /**
     * Удаление элемента по индексу
     *
     * @param index индекс
     * @return возвращает удаленный объект
     * @throws IndexOutOfBoundsException может бросать исключение
     */
    E remove(int index);

    /**
     * Получение индекса элемента
     *
     * @param element принимает на вход объект
     * @return возвращает индекс элемента
     */
    int indexOf(E element);

    /**
     * Очищение массива. Устанавливает для всех элементов значение - null и размер становится равен нулю
     */
    void clear();

    /**
     * Получение элемента по индексу
     *
     * @param index принимает на вход индекс
     * @return возвращает элемент
     */
    E get(int index);

    /**
     * Получение размера массива
     *
     * @return возвращает кол-во элементов в массиве
     */
    int size();

    /**
     * Сортировка массива объектов реализующих compareTo интерфейсов Comparator либо Comparable
     *
     * @param comparator интерфейс, который реализует объект для сортировки
     */
    void sort(Comparator<? super E> comparator);


}

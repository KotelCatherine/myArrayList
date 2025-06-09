package ru.top.academy;

import java.util.Arrays;

public class MyArrayList<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private int size;

    /**
     *  Конструктор. При создании объекта задается начальный объем и размер массива
     */
    public MyArrayList() {

        elementData = new Object[DEFAULT_CAPACITY];
        size = 0;

    }

    /**
     * Реализация добавления элемента в массив
     *
     * @param element добавляемый элемент
     * @param size    размер массива
     * @return возвращает булево значение в случае успешного удаления - true, если же не получилось добавить - false
     */
    private boolean add(E element, int size) {

        ifArrayFullThenIncrease();
        addElementByIndex(size, element);

        return true;

    }

    /**
     * Увеличение объема массива
     *
     * @param minCapacity размер массива на данный момент
     * @return возвращает увеличенный массив
     */
    private Object[] grow(int minCapacity) {
        return myCopyOf(elementData, newCapacity(minCapacity));
    }

    /**
     * Копирует элементы из меньшего массива в больший
     *
     * @param elementData начальный массив
     * @param newCapacity новый объем массива
     * @return возвращает новый массив с большим объемом для данных
     */
    private Object[] myCopyOf(Object[] elementData, int newCapacity) {

        Object[] newElementData = new Object[newCapacity];
        System.arraycopy(elementData, 0, newElementData, 0, elementData.length);

        return newElementData;

    }

    /**
     * Вычисление нового объема
     *
     * @param minCapacity размер массива на данный момент
     * @return возвращает вычисленное число для нового объема
     */
    private int newCapacity(int minCapacity) {
        return (minCapacity * 3) / 2 + 1;
    }

    /**
     * Проверка индекс на корректность, в случае index = -1 либо выходящего за пределы массива,
     * то будет выдано исключение IndexOutOfBoundsException
     *
     * @param index индекс
     */
    private void isIncorrectIndex(int index) {

        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Incorrect index");
        }

    }

    /**
     * Проверяет равен ли размер массива его объему
     *
     * @return возвращает булево значение в случае, если массив полный - true, иначе вернет false
     */
    private boolean isFullArray() {
        return size == elementData.length;
    }

    /**
     * Поиск элемента в массиве
     *
     * @param element элемент который надо найти
     * @return возвращает индекс найденного элемента
     */
    private int elementMatch(Object element) {

        if (element == null) {
            return indexNullElement();
        }

        return indexCorrespondingElement(element);

    }

    /**
     * Поиск совпадения в массиве
     *
     * @param element элемент, который надо найти
     * @return в случе, когда совпадение найдено, вернет индекс найденного элемента, иначе возвращает -1
     */
    private int indexCorrespondingElement(Object element) {

        for (int i = 0; i < size; i++) {

            if (elementData[i].equals(element)) {
                return i;
            }

        }

        return -1;

    }

    /**
     * Поиск совпадения в массиве, если элемент равен null
     *
     * @return в случе, когда совпадение найдено, вернет индекс найденного элемента, иначе возвращает -1
     */
    private int indexNullElement() {

        for (int i = 0; i < size; i++) {

            if (elementData[i] == null) {
                return i;
            }

        }

        return -1;

    }

    /**
     * Сдвигает элементы вправо до получаемого индекса
     *
     * @param index индекс до которого нужно сдвинуть элементы
     */
    private void shiftElementsToRight(int index) {

        if (index != size) {
            for (int i = size; i > index; i--) {
                elementData[i] = elementData[i - 1];
            }
        }

    }

    /**
     * Добавление элемента по индексу
     *
     * @param index   индекс
     * @param element элемент
     */
    private void addElementByIndex(int index, E element) {

        elementData[index] = element;
        size++;

    }

    /**
     * Сдвиг элементов влево от получаемого индекса и уменьшает размер массива на 1
     *
     * @param index индекс
     */
    private void shiftElementsToLeft(int index) {

        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }

        size--;

    }

    /**
     * Получение размера массива
     *
     * @return возвращает кол-во элементов в массиве
     */
    public int size() {
        return size;
    }

    /**
     * Получение индекса элемента
     *
     * @param element принимает на вход объект
     * @return возвращает индекс элемента
     */
    public int indexOf(Object element) {
        return elementMatch(element);
    }

    /**
     * Получение элемента по индексу
     *
     * @param index принимает на вход индекс
     * @return возвращает элемент
     */
    public Object get(int index) {
        return elementData[index];
    }

    /**
     * Добавление элемента в массив
     *
     * @param element принимает на вход элемент
     * @return возвращает булево значение в случае успешного добавления - true, если же не получилось добавить - false
     */
    public boolean add(E element) {
        return add(element, size);
    }

    /**
     * Добавление элемента по индексу
     *
     * @param index   индекс
     * @param element элемент
     * @return возвращает булево значение в случае успешного добавления - true, если же не получилось добавить - false
     */
    public boolean add(int index, E element) {

        isIncorrectIndex(index);
        ifArrayFullThenIncrease();
        shiftElementsToRight(index);
        addElementByIndex(index, element);

        return true;

    }

    private void ifArrayFullThenIncrease() {

        if (isFullArray()) {
            elementData = grow(size);
        }

    }

    /**
     * Удаление элемента по индексу
     *
     * @param index индекс
     * @return возвращает удаленный объект
     */
    public Object remove(int index) {

        isIncorrectIndex(index);
        Object oldElement = elementData[index];
        shiftElementsToLeft(index);

        return oldElement;

    }

    /**
     * Удаление элемента
     *
     * @param element принимает на вход элемент необходимый для удаления
     * @return возвращает булево значение в случае успешного удаления - true, если же не получилось добавить - false
     */
    public boolean remove(Object element) {

        int index = elementMatch(element);

        if (index != -1) {
            shiftElementsToLeft(index);
        }

        return true;

    }

    /**
     * Очищение массива. Устанавливает для всех элементов значение - null и размер становится равен нулю
     */
    public void clear() {

        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }

        size = 0;

    }

    /**
     * Сортировка массива с помощью метода sort(Object[] a) класса Arrays
     */
    public void sort() {
        Arrays.sort(elementData);
    }

    /**
     * Переопределенный метод класса Object для вывода массива
     *
     * @return возвращает строковое представление массива
     */
    @Override
    public String toString() {

        Object[] array = new Object[size];
        System.arraycopy(elementData, 0, array, 0, size);

        return Arrays.toString(array);

    }

}

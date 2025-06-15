package ru.top.academy;

import ru.top.academy.interfaceMyArrayList.MyList;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> implements MyList<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private E[] elementData;
    private int size;

    public MyArrayList() {

        elementData = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;

    }

    private boolean addElement(E element) {

        ifArrayFullThenIncrease();
        addElementByIndex(size, element);

        return true;

    }

    private E[] grow(int minCapacity) {
        return myCopyOf(elementData, newCapacity(minCapacity));
    }

    private E[] myCopyOf(E[] elementData, int newCapacity) {

        E[] newElementData = (E[]) new Object[newCapacity];
        System.arraycopy(elementData, 0, newElementData, 0, elementData.length);

        return newElementData;

    }

    private int newCapacity(int minCapacity) {
        return (minCapacity * 3) / 2 + 1;
    }

    private void isIncorrectIndex(int index) {

        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Incorrect index");
        }

    }

    private boolean isFullArray() {
        return size == elementData.length;
    }

    private int elementMatch(Object element) {

        if (element == null) {
            return indexNullElement();
        }

        return indexCorrespondingElement(element);

    }

    private int indexCorrespondingElement(Object element) {

        for (int i = 0; i < size; i++) {

            if (elementData[i].equals(element)) {
                return i;
            }

        }

        return -1;

    }

    private int indexNullElement() {

        for (int i = 0; i < size; i++) {

            if (elementData[i] == null) {
                return i;
            }

        }

        return -1;

    }

    private void shiftElementsToRight(int index) {

        if (index != size) {

            for (int i = size; i > index; i--) {
                elementData[i] = elementData[i - 1];
            }

        }

    }

    private void addElementByIndex(int index, E element) {

        elementData[index] = element;
        size++;

    }

    private void shiftElementsToLeft(int index) {

        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }

        size--;

    }

    public int size() {
        return size;
    }

    public int indexOf(E element) {
        return elementMatch(element);
    }

    public E get(int index) {
        return elementData[index];
    }

    public boolean add(E element) {
        return addElement(element);
    }

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

    public E remove(int index) {

        isIncorrectIndex(index);
        E oldElement = elementData[index];
        shiftElementsToLeft(index);

        return oldElement;

    }

    public boolean remove(E element) {

        int index = elementMatch(element);

        if (index != -1) {
            shiftElementsToLeft(index);
            return true;
        }

        return false;

    }

    public void clear() {

        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }

        size = 0;

    }

    @Override
    public void sort(Comparator<? super E> comparator) {
        Arrays.sort(elementData, 0, size, comparator);
    }


    @Override
    public String toString() {

        Object[] array = new Object[size];
        System.arraycopy(elementData, 0, array, 0, size);

        return Arrays.toString(array);

    }

}

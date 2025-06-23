package ru.top.academy;

import ru.top.academy.interfaceMyArrayList.MyList;

import java.util.Comparator;

public final class Utils {


    public static <T> void quickSort(MyList<T> elementData) {

        if (elementData == null){
            throw new NullPointerException("List is null");
        }

        recursionSort(elementData, 0, elementData.size() - 1, null);

    }

    public static <T> void quickSort(T[] elementArray, Comparator<? super T> comparator) {

        if (elementArray == null){
            throw new NullPointerException("Array is null");
        }

        MyList<T> list = new MyArrayList<>();

        fillList(list, elementArray);

        recursionSort(list, 0, list.size() - 1, comparator);

        saveChangeInArray(list, elementArray);

    }

    private static <T> void fillList(MyList<T> list, T[] elementArray) {

        for (T t : elementArray) {

            if (t == null) {
                break;
            }

            list.add(t);

        }

    }

    private static <T> void saveChangeInArray(MyList<T> list, T[] elementArray) {

        for (int i = 0; i < elementArray.length; i++) {

            if (elementArray[i] == null) {
                break;
            }

            elementArray[i] = list.get(i);

        }

    }


    private static <T> void recursionSort(MyList<T> element, int low, int high, Comparator<? super T> comparator) {

        if (low < high) {

            int middleIndex;

            if (comparator != null) {

                middleIndex = partition(element, low, high, comparator);

                recursionSort(element, low, middleIndex - 1, comparator);
                recursionSort(element, middleIndex + 1, high, comparator);

            } else {

                middleIndex = partition(element, low, high, null);

                recursionSort(element, low, middleIndex - 1, null);
                recursionSort(element, middleIndex + 1, high, null);

            }

        }

    }

    private static <T> int partition(MyList<T> element, int low, int high, Comparator<? super T> comparator) {

        int middle = low + (high - low) / 2;
        T pivot = element.get(middle);
        int leftIndex = low - 1;

        swapElement(element, element.get(middle), element.get(high), middle, high);

        for (int rightIndex = leftIndex + 1; rightIndex < high; rightIndex++) {

            if (comparator != null) {

                if (comparator.compare(element.get(rightIndex), pivot) < 0) {

                    leftIndex++;
                    swapElement(element, element.get(leftIndex), element.get(rightIndex), leftIndex, rightIndex);

                }

            } else {

                Comparable<? super T> comparable = (Comparable<? super T>) element.get(rightIndex);

                if (comparable.compareTo(pivot) < 0) {

                    leftIndex++;
                    swapElement(element, element.get(leftIndex), element.get(rightIndex), leftIndex, rightIndex);

                }

            }

        }

        swapElement(element, element.get(leftIndex + 1), element.get(high), leftIndex + 1, high);

        return leftIndex + 1;

    }

    private static <T> void swapElement(MyList<T> element, T leftValue, T rightValue, int leftIndex, int rightIndex) {

        element.remove(leftIndex);
        element.add(leftIndex, rightValue);
        element.remove(rightIndex);
        element.add(rightIndex, leftValue);

    }

}

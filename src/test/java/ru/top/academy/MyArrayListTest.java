package ru.top.academy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.top.academy.Animal.Animal;
import ru.top.academy.Animal.Cat;
import ru.top.academy.Animal.Congo;
import ru.top.academy.Animal.Dog;
import ru.top.academy.interfaceMyArrayList.MyList;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    private MyList<Animal> list;
    static Animal cat = new Cat("Gamora", 1);
    static Animal dog = new Dog("Lucky", 5);
    static Animal dogSecond = new Dog("Artur", 5);

    @BeforeEach
    public void initMyList() {

        list = new MyArrayList<>();
        list.add(cat);
        list.add(dog);
        list.add(dogSecond);

    }

    @AfterEach
    public void expectedMyList() {
        list = null;
    }

    @ParameterizedTest
    @MethodSource("testData")
    void addedElement_whenElementIsCorrect_thenTrue(Animal element) {
        assertTrue(list.add(element));
    }

    @ParameterizedTest
    @MethodSource("testData")
    void addedElementByIndex_whenIndexAndElementIsCorrect_thenTrue(Animal element) {
        assertTrue(list.add(2, element));
    }

    @ParameterizedTest
    @MethodSource("testData")
    void addedElementByIndex_whenIndexIsIncorrect_thenException(Animal element) {
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(5, element));
    }

    @Test
    void removeElementByIndex_whenIndexIsCorrect_thenTrue() {

        list.remove(0);
        assertEquals(2, list.size());

    }

    @Test
    void removeElementByIndex_whenIndexIsIncorrect_thenThrows() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(5));
    }

    @ParameterizedTest
    @MethodSource("testDataForDelete")
    void removeElement_whenElementIsCorrect_thenTrue(Animal element) {
        assertTrue(list.remove(element));
    }

    @ParameterizedTest
    @MethodSource("testData")
    void removeElement_whenElementIsIncorrect_thenFalse(Animal element) {
        assertFalse(list.remove(element));
    }

    @Test
    void indexOf_whenElementExist_thenTrue() {
        assertEquals(1, list.indexOf(dog));
    }

    @ParameterizedTest
    @MethodSource("testData")
    void indexOf_whenElementNotExist_thenNegativeIndex(Animal element) {
        assertEquals(-1, list.indexOf(element));
    }

    @Test
    void getElement_whenIndexIsCorrect_thenEqualsTrue() {
        assertEquals(dog, list.get(1));
    }

    @Test
    void getElement_whenIndexIsIncorrect_thenException() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(15));
    }

    @Test
    void size_whenSizeIsNotEmpty_thenEqualsTrue() {
        assertEquals(3, list.size());
    }

    @Test
    void sort_whenElementImplComparableOrComparator_thenTrue() {

        list.sort(Animal::compareTo);

        assertEquals(dogSecond, list.get(0));
        assertEquals(cat, list.get(1));
        assertEquals(dog, list.get(2));

    }

    @Test
    void clear_whenMyListIsNotEmpty_thenTrue() {

        list.clear();
        assertEquals(0, list.size());

    }

    public static Stream<Animal> testData() {
        return Stream.of(new Cat("cat", 5), new Congo("congo", 2), new Dog("dog", 8));
    }

    public static Stream<Animal> testDataForDelete() {
        return Stream.of(cat, dog);
    }

}

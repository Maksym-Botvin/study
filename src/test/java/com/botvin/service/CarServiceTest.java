package com.botvin.service;

import com.botvin.model.Car;
import com.botvin.repository.CarArrayRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CarServiceTest {
    private CarService target;
    private CarArrayRepository repository;

    @BeforeEach
    void setUp() {
        repository = Mockito.mock(CarArrayRepository.class);
        target = new CarService(repository);
    }

    @Test
    void create_Null() {
        final Car car = target.create();
        Assertions.assertNull(car);
    }

    @Test
    void create_NotNull() {
        final Car car = target.create();
        Assertions.assertNotNull(car);
    }

/*    @Test
    void createCars_one() {
        final int actual = target.createCars();
        Assertions.assertEquals(1, actual);
    }*/

/*    @Test
    void createCars_two() {
        final int actual = target.createCars();
        Assertions.assertEquals(2, actual);
    }*/

/*    @Test
    void createCars_three() {
        final int actual = target.createCars();
        Assertions.assertEquals(3, actual);
    }*/

/*    @Test
    void createCars_four() {
        final int actual = target.createCars();
        Assertions.assertEquals(4, actual);
    }*/

/*    @Test
    void createCars_five() {
        final int actual = target.createCars();
        Assertions.assertEquals(5, actual);
    }*/

/*    @Test
    void createCars_six() {
        final int actual = target.createCars();
        Assertions.assertEquals(6, actual);
    }*/

/*    @Test
    void createCars_seven() {
        final int actual = target.createCars();
        Assertions.assertEquals(7, actual);
    }*/

/*    @Test
    void createCars_eight() {
        final int actual = target.createCars();
        Assertions.assertEquals(8, actual);
    }*/

/*    @Test
    void createCars_nine() {
        final int actual = target.createCars();
        Assertions.assertEquals(9, actual);
    }*/

/*    @Test
    void createCars_ten() {
        final int actual = target.createCars();
        Assertions.assertEquals(10, actual);
    }*/

/*    @Test
    void createCars_minesOne() {
        final int actual = target.createCars();
        Assertions.assertEquals(-1, actual);
    }*/

/*    @Test
    void createCars_emptyString() {
        String expected = "";
        final int actual = target.createCars();
        Assertions.assertEquals(expected, actual);
    }*/

    @Test
    void printAll() {
        Assertions.assertDoesNotThrow(() -> target.printAll());
    }

    @Test
    void getAll_Null() {
        final Car[] car = target.getAll();
        Assertions.assertNull(car);
    }

    @Test
    void getAll_NotNull() {
        final Car[] car = target.getAll();
        Assertions.assertNotNull(car);
    }

/*    @Test
    void find_IdIncorrectNullId() {
        String id = null;
        final Car car = target.find(id);
        Assertions.assertNull(car);
    }*/

/*    @Test
    void find_IdIncorrectEmptyId() {
        String id = "";
        final Car car = target.find(id);
        Assertions.assertNull(car);
    }*/

/*    @Test
    void find_NotFound() {
        String id = "777";
        Mockito.when(repository.getById("777")).thenReturn(null);
        final Car car = target.find(id);
        Assertions.assertNull(car);
    }*/

    /*@Test
    void find_SpecialId() {
        final Car expected = new Car();
        String id = "147258369";
        Mockito.when(repository.getById("147258369")).thenReturn(expected);
        final Car actual = target.find(id);
        Assertions.assertEquals(expected, actual);
    }*/

}
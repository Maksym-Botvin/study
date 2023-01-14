package com.botvin;

import com.botvin.container.*;
import com.botvin.model.*;
import com.botvin.service.CarService;
import com.botvin.repository.CarRepository;
import com.botvin.util.RandomGenerator;
import com.sun.jdi.PrimitiveValue;
import lombok.SneakyThrows;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.*;

public class Main {
    public static void main(String[] args) throws UserInputException, InstantiationException, IllegalAccessException, IOException {

        CarService carService = new CarService(new CarRepository());
/*
        //Lesson 11
        Object firstCar;
        firstCar = carService.createPassengerCarOrCreateTruck();
        System.out.println(firstCar);

        Object secondCar;
        secondCar = carService.createPassengerCarOrCreateTruck();
        System.out.println(secondCar);

        System.out.println();

        System.out.println(carService.carEquals(carService.createPassengerCarOrCreateTruck(), carService.createPassengerCarOrCreateTruck()));

        System.out.println();

        System.out.println(carService.createPassengerCarOrCreateTruck());

        System.out.println();

 */

/*
        // Lesson 12
        Car car = carService.createPassengerCarOrCreateTruck();

        carService.printManufacturerAndCount(car);

        carService.printColor(car);

        carService.checkCount(car);

        carService.printEngineInfo(car);

        carService.printInfo(car);

 */

/*
        // Lesson 13

        Random random = new Random();

        System.out.println();

        carService.createArrayOfCars(5);
        final Car[] all = carService.getAll();

        String[] carsIds = new String[5];
        for (int i = 0; i < all.length; i++) {
            carsIds[i] = all[i].getId();
        }
        System.out.println(Arrays.toString(carsIds));
        System.out.println(carsIds[0] + " - the first id of our cars' array");

        System.out.println();

        System.out.println("Sorted array:");
        AlgorithmUtil.bubbleSort(carsIds);
        System.out.println(carsIds[0] + " - the first id of our sorted array of cars");

        System.out.println();

        String elementToSearch = carsIds[random.nextInt(0, carsIds.length)];
        System.out.println(elementToSearch + " - wanted item");
        int index = AlgorithmUtil.binarySearch(carsIds, elementToSearch);
        System.out.println("Еhe index of the searched element " + index);
*/
/*

        // Lesson 14

        Car car = carService.create();

        GreenericContainer<Car> greenericContainer = new GreenericContainer<>(car);

        greenericContainer.print(); // 1-st method
        System.out.println();

        greenericContainer.increaseCount(); // 2-nd method
        greenericContainer.print();
        System.out.println();

        greenericContainer.increaseCount(5.5); // 3-rd method
        greenericContainer.print();
        System.out.println();
*/
/*

        // Lesson 15

        CarList<? extends Car> carList = new CarList<>();
        Car car1 = carService.create();
        carList.addAtTheBeginning(car1);
        carList.print();

        System.out.println();

        Car car2 = carService.create();
        carList.addAtTheBeginning(car2);
        carList.print();

        System.out.println();

        Car car3 = carService.create();
        carList.addAtTheEnd(car3);
        carList.print();

        System.out.println();

        System.out.println(carList.getByTheValue(car1) + " - index of the car");

        System.out.println();

        Car car4 = carService.create();
        carList.insertValueByTheIndex(1, car4);
        carList.print();

        System.out.println();

        carList.deleteByTheIndex(1);
        carList.print();

        System.out.println();

        System.out.println(carList.getAllCarCount() + " total count");
*/
/*

        // Lesson 16

        Car car = carService.create();
        car.setCount(5);
        Car car1 = carService.create();
        car1.setCount(10);
        Car car2 = carService.create();
        car2.setCount(7);
        Car car3 = carService.create();
        car3.setCount(50);
        Car car4 = carService.create();
        car4.setCount(18);
        Car car5 = carService.create();
        car5.setCount(9);

        // Create binary tree
        CarTree<Car> carCarTree = new CarTree<>();
        BinaryTreeNode root = new BinaryTreeNode<>(car.getCount());
        carCarTree.createBinaryTree(root, car1);
        carCarTree.createBinaryTree(root, car2);
        carCarTree.createBinaryTree(root, car3);
        carCarTree.createBinaryTree(root, car4);
        carCarTree.createBinaryTree(root, car5);
        System.out.println("Traversing tree in order");
        carCarTree.traverseInOrder(root);
        System.out.println();

        // порівнювати за значенням count
        CarComparator<Car> carCarComparator = new CarComparator<>(car);
        int result = carCarComparator.countComparator(car1, car2);
        System.out.printf("Count of the first car: %d, count of the second car: %d, result of comparison: %d\n"
                , car1.getCount(), car2.getCount(), result);
        System.out.println();

        // пошук суми count усіх елементів правої та лівої гілки (корінь включно)
        CarTree bt = new CarTree();
        //Add nodes to the binary tree
        bt.root = new CarTree.Node_1(car.getCount());
        bt.root.right = new CarTree.Node_1(car1.getCount());
        bt.root.right.left = new CarTree.Node_1(car2.getCount());
        bt.root.right.right = new CarTree.Node_1(car3.getCount());
        bt.root.right.right.left = new CarTree.Node_1(car4.getCount());
        bt.root.right.left.right = new CarTree.Node_1(car5.getCount());
        //Display the sum of all the nodes in the given binary tree
        System.out.println("Sum of all nodes of binary tree: " + bt.calculateSum(bt.root));
        System.out.println();

        carService.createArrayOfCars(5);
        carService.getAll();
        carService.printAll();
        System.out.println();

        // Отримує список Car і повертає Map, де ключ це Manufacturer, а значення - к-сть машин
        // (потрібно зробити так, щоб не було перезатирання, а к-сть машин збільшувалася)
        HashMap<String, Integer> mapManufacturer = carService.returnManufacureAndCount(carService.getAll());
        System.out.println(mapManufacturer.toString());

        // Отримує список Car і повертає Map, де ключ це Engine/power, а значення - це список Car з цим двигуном
        HashMap<Integer, LinkedList> mapEngine = carService.returnEnginePowerAndList(carService.getAll());
        System.out.println(mapEngine.toString());
*/

/*

        // Lesson 17

        Car car = carService.create();
        Car car1 = carService.create();
        Car car2 = carService.create();
        Car car3 = carService.create();
        Car car4 = carService.create();

        List<Car> carList = new ArrayList<>();
        carList.add(car);
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);

        //findManafacturerByPrice Знайти машини дорожчі за ціну Х і показати їхнього виробника
        List<Car> carsList1 = carService.findManafacturerByPrice(carList);

        System.out.println();

        //countSum Порахувати суму машин через reduce
        int sum = carService.countSum(carsList1);

        System.out.println();

        //mapToMap Відсортувати машини за виробником, прибрати дублікати, перетворити на
        //Map, де ключ - це id машини, а значення - це її тип (зберігаючи порядок)
        System.out.println(carService.mapToMap(carsList1));

        System.out.println();

        //statistic Отримати статистику за ціною всіх машин
        Map<String, Integer> mapStatistic = carService.statistic(carList);

        System.out.println();

        //priceCheck Написати реалізацію предиката, який перевіряє, що в переданій колекції в усіх
        //машин є ціна, вища за число Х.
        carService.priceCheck(carList);

        System.out.println("~".repeat(10));

        //mapToObject Написати реалізацію Function, яка приймає Map<String, Object> і створює
        //конкретну машину на підставі полів Map
        Map<String, Object> map = new HashMap<>();
        map.put("manufacturer", RandomGenerator.generateRandomManufacture());
        map.put("engine", car.getEngine());
        map.put("color", Color.BLACK);
        map.put("type", Type.randomType());
        map.put("count", car.getCount());
        map.put("price", car.getPrice());
        map.put("id", car.getId());

        Car newCar = carService.mapToObject(map);
        carService.print(newCar);

        System.out.println();

        //innerList метод приймає колекцію List<List<Car>>, дістає машини, сортує за кольорами,
        //виводить інформацію на консоль, фільтрує за ціною, збирає в Map, де ключ - це колір, а
        //значення - к-ть машин
        carService.createArrayOfCars(5);
        List<Car> carList1 = new ArrayList<>();
        for (Car element : carService.getAll()) {
            carList1.add(element);
        }

        List<Car> carList2 = new ArrayList<>();
        for (Car element : carService.getAll()) {
            carList2.add(element);
        }

        List<List<Car>> lists = new ArrayList<>();
        lists.add(carList);
        lists.add(carList1);
        lists.add(carList2);

        carService.innerList(lists);

        System.out.println();
*/

        // Lesson 18

        Map<String, String> xmlMap = carService.readFileCreateMap("xml/car.xml");
        for (Map.Entry<String, String> entry : xmlMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println();

        System.out.println(carService.mapToCar(xmlMap));

        System.out.println();

        Map<String, String> jsonMap = carService.readFileCreateMap("json/car.json");
        for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println();

        System.out.println(carService.mapToCar(jsonMap));

    }
}


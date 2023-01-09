package com.botvin.service;

import com.botvin.model.*;
import com.botvin.repository.CarRepository;
import com.botvin.util.RandomGenerator;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CarService {
    private Random random = new Random();
    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car create() {
        Type type = Type.randomType();
        String manufacture = RandomGenerator.generateRandomManufacture();
        Engine engine = new Engine(RandomGenerator.generateRandomTypeOfEngine());
        if (type.equals(Type.CAR)) {
            PassengerCar passengerCar = new PassengerCar(manufacture, engine, getRandomColor(), getPassengerCount());
            passengerCar.setType(Type.CAR);
            return passengerCar;
        } else if (type.equals(Type.TRUCK)) {
            Truck truck = new Truck(manufacture, engine, getRandomColor(), getPassengerCount());
            truck.setType(Type.TRUCK);
            return truck;
        }
        return null;
    }

    public void createArrayOfCars(final int sizeOfArray) {
        for (int i = 0; i < sizeOfArray; i++) {
            carRepository.save(create());
        }
    }

    public void create(final int count) {
        for (int i = 0; i < count; i++) {
            carRepository.save(create());
        }
    }

    public Car createPassengerCarOrCreateTruck() {
        Type type = Type.randomType();
        String manufacture = RandomGenerator.generateRandomManufacture();
        Engine engine = new Engine(RandomGenerator.generateRandomTypeOfEngine());
        if (type.equals(Type.CAR)) {
            PassengerCar passengerCar = new PassengerCar(manufacture, engine, getRandomColor(), getPassengerCount());
            passengerCar.setType(Type.CAR);
            return passengerCar;
        } else if (type.equals(Type.TRUCK)) {
            Truck truck = new Truck(manufacture, engine, getRandomColor(), getPassengerCount());
            truck.setType(Type.TRUCK);
            return truck;
        }
        return null;
    }

    public boolean carEquals(Car firstCar, Car secondCar) {
        if (firstCar.hashCode() == secondCar.hashCode()) {
            if (firstCar.getType().equals(secondCar.getType())) {
                System.out.println("The cars are the same!");
            }
            return true;
        } else {
            return false;
        }
    }

    public void printManufacturerAndCount(final Car car) {
        Optional.ofNullable(car).ifPresent(value -> {
            System.out.printf("Manufacturer: %s, count: %d.\n", value.getManufacturer(), value.getCount());
        });
    }

    public void printColor(final Car car) {
        Car value = Optional.ofNullable(car).orElse(new PassengerCar(getRandomManufacture(), getRandomEngine(),
                getRandomColor(), getPassengerCount()));
        System.out.println("Color: " + car.getColor().toString());
    }

    public void checkCount(final Car car) throws UserInputException {
        Car value = Optional.ofNullable(car)
                .filter(valueFilter -> valueFilter.getCount() >= 0) // valueFilter.getCount() >= 10
                .orElseThrow(() -> new UserInputException());
        System.out.printf("Manufacturer: %s, count: %d.\n", value.getManufacturer(), value.getCount());
    }

    public void printEngineInfo(final Car car) {
        Car value = Optional.ofNullable(car)
                .orElseGet(() -> {
                    System.out.println("Create new car!");
                    return createPassengerCarOrCreateTruck();
                });
        Optional.of(value.getEngine())
                .map(eng -> {
                    System.out.printf("Engine power: %d.\n", eng.getPower());
                    return value.getEngine().toString();
                });
    }

    public void printInfo(final Car car) {
        Optional.ofNullable(car).ifPresentOrElse(
                value -> print(car),
                () -> print(createPassengerCarOrCreateTruck())
        );
    }

    public void print(final Car car) {
        System.out.println(car);
    }

    private int getPassengerCount() {
        PassengerCar passengerCar = new PassengerCar();
        int count = passengerCar.getCount();
        return count;
    }

    private int getLoadCapacity() {
        Truck truck = new Truck();
        int loadCapacity = truck.getLoadCapacity();
        return loadCapacity;
    }

    private Engine getRandomEngine() {
        Engine engine = new Engine(RandomGenerator.generateRandomTypeOfEngine());
        return engine;
    }

    private String getRandomManufacture() {
        String manufacture = RandomGenerator.generateRandomManufacture();
        return manufacture;
    }

    private Color getRandomColor() {
        Color[] values = Color.values();
        int randomIndex = random.nextInt(values.length);
        return values[randomIndex];
    }

    public void printAll() {
        Car[] all = carRepository.getAll();
        for (Car car : all) {
            System.out.println(car);
        }
    }

    /*
        public void printAll() {
        Car[] all = carRepository.getAll();
        System.out.println(Arrays.toString(all));
    }
     */
    public Car[] getAll() {
        return carRepository.getAll();
    }

    public Car find(String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return carRepository.getById(id);
    }

    public void delete(String id) {
        if (id == null || id.isEmpty()) {
            return;
        }
        carRepository.delete(id);
    }

    public void changeRandomColor(String id) {
        if (id == null || id.isEmpty()) {
            return;
        }
        Car car = find(id);
        if (car == null) {
            return;
        }
        findAndChangeRandomColor(car);
    }

    private void findAndChangeRandomColor(Car car) {
        Color color = car.getColor();
        Color randomColor;
        do {
            randomColor = getRandomColor();
        } while (randomColor == color);
        carRepository.updateColor(car.getId(), randomColor);
    }


    public void insert(String id) {
        carRepository.insert(id);
    }

    public static void check(Car car) {

        boolean countStatement;
        boolean powerStatement;

        if (car.getCount() > 0) {
            countStatement = true;
        } else {
            countStatement = false;
            System.out.printf("The count of car %s is less then 1! \n", car);
        }

        if (car.getEngine().getPower() > 200) {
            powerStatement = true;
        } else {
            powerStatement = false;
            System.out.printf("The power of car %s is less then 200! \n", car);
        }

        if ((countStatement && powerStatement) == true) {
            System.out.printf("The car %s is ready to sell! \n", car);
        }
    }

    // New CarServices' methods from 16-th lesson
    public HashMap<String, Integer> returnManufacureAndCount(Car[] cars) {
        HashMap<String, Integer> map = new HashMap<>();
        for (Car car : cars) {
            map.put(car.getManufacturer(), car.getCount());
        }
        return map;
    }

    public HashMap<Integer, LinkedList> returnEnginePowerAndList(Car[] cars) {
        HashMap<Integer, LinkedList> map = new HashMap<>();
        LinkedList<Car> carList;
        for (Car car : cars) {
            int power = car.getEngine().getPower();
            if (map.containsKey(power)) {
                carList = map.get(power);
                carList.add(car);
            } else {
                map.put(power, new LinkedList<>());
                carList = map.get(power);
                carList.add(car);
            }
        }
        return map;
    }

    // New CarServices' methods from 17-th lesson
    //findManafacturerByPrice Знайти машини дорожчі за ціну Х і показати їхнього виробника
    public List<Car> findManafacturerByPrice(final List<Car> cars) {
        final List<Car> expensiveCar = cars.stream()
                .filter(e -> e.getPrice() > 50_000)
                .peek(System.out::println)
                .collect(Collectors.toList());
        return expensiveCar;
    }

    //countSum Порахувати суму машин через reduce
    public int countSum(final List<Car> cars) {
        final int sum = cars.stream()
                .map(x -> x.getCount())
                .reduce(0, Integer::sum);
        System.out.println("Sum of cars: " + sum);
        return sum;
    }

    //mapToMap Відсортувати машини за виробником, прибрати дублікати, перетворити на
    //Map, де ключ - це id машини, а значення - це її тип (зберігаючи порядок)
    public LinkedHashMap<String, Type> mapToMap(final List<Car> cars) {
        LinkedHashMap<String, Type> mapCars = cars.stream()
                .distinct()
                .sorted(Comparator.comparing(Car::getManufacturer))
                .collect(Collectors.toMap(Car::getId, Car::getType, (key1, key2) -> key1, LinkedHashMap::new));
        return mapCars;
    }

    // statistic Отримати статистику за ціною всіх машин
    public Map<String, Integer> statistic(final List<Car> cars) {
        Map<String, Integer> statisticOfCars = cars.stream()
                .collect(Collectors.toMap(Car::getManufacturer, Car::getPrice, (o1, o2) -> o1));
        System.out.println(statisticOfCars);
        return statisticOfCars;
    }

    //priceCheck Написати реалізацію предиката, який перевіряє, що в переданій колекції в усіх
    //машин є ціна, вища за число Х.
    public void priceCheck(final List<Car> cars) {
        Predicate<Car> isExpensive = e -> e.getPrice() > 50_000;
        cars.stream()
                .filter(isExpensive).forEach(System.out::println);
    }

    //mapToObject Написати реалізацію Function, яка приймає Map<String, Object> і створює
    //конкретну машину на підставі полів Map
    public Car mapToObject(final Map<String, Object> map) {
        Function<Map, Car> function = m -> {
            if (m.get("type") == Type.CAR) {
                return new PassengerCar();
            } else if (m.get("type") == Type.TRUCK) {
                return new Truck();
            } else {
                throw new NullPointerException("Type of car not exist");
            }
        };

        return function.andThen(c -> {
                    if (map.get("manufacturer") != null) {
                        c.setManufacturer((String) map.get("manufacturer"));
                    }
                    if (map.get("engine") != null) {
                        c.setEngine((Engine) map.get("engine"));
                    }
                    if (map.get("color") != null) {
                        c.setColor((Color) map.get("color"));
                    }
                    if (map.get("type") != null) {
                        c.setType((Type) map.get("type"));
                    }
                    if (map.get("count") != null) {
                        c.setCount((int) map.get("count"));
                    }
                    if (map.get("price") != null) {
                        c.setPrice((int) map.get("price"));
                    }
                    if (map.get("id") != null) {
                        c.setId((String) map.get("id"));
                    }
                    return c;
                })
                .apply(map);
    }

    //innerList метод приймає колекцію List<List<Car>>, дістає машини, сортує за кольорами,
    //виводить інформацію на консоль, фільтрує за ціною, збирає в Map, де ключ - це колір, а
    //значення - к-ть машин
    public Map<Color, Long> innerList(final List<List<Car>> cars) {
        Predicate<Car> isExpensive = e -> e.getPrice() > 50_000;
        Map<Color, Long> sortedCars = cars.stream()
                .flatMap(list -> list.stream())
                .sorted(Comparator.comparing(Car::getColor))
                .peek(System.out::println)
                .filter(isExpensive)
                .collect(Collectors.groupingBy(Car::getColor, Collectors.counting()));
        return sortedCars;
    }

    // Lesson 18
    public List readXmlCreateList(final String path) {
        final ClassLoader loader = Thread.currentThread().getContextClassLoader();
        final InputStream inputXml = loader.getResourceAsStream(path);
        final List<String> xmlStringList = new ArrayList<>();
        byte[] xmlArray = new byte[1000];
        try {
            inputXml.read(xmlArray);
            final String xmlData = new String(xmlArray);
            final Matcher matcherXml = Pattern.compile("<([a-zA-Z, 0-9]+)(.?\\>)(.*?)").matcher(xmlData);//<([a-zA-Z, 0-9]+)
            while (matcherXml.find()) {
                xmlStringList.add(matcherXml.group(1));
            }
            inputXml.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return xmlStringList;
    }

    public List readJsonCreateList(final String path) {
        final ClassLoader jsonLoader = Thread.currentThread().getContextClassLoader();
        final BufferedInputStream jsonInput = (BufferedInputStream) jsonLoader.getResourceAsStream(path);
        final List<String> jsonList = new ArrayList<>();
        byte[] jsonArray = new byte[1000];
        try {
            jsonInput.read(jsonArray);
            final String jsonData = new String(jsonArray);
            final Matcher matcherXml = Pattern.compile(
                    "(?:\\\"|\\')([^\\\"]*)(?:\\\"|\\')(?=:)(?:\\:\\s*)(?:\\\")" +
                            "?(true|false|[-0-9]+[\\.]*[\\d]*(?=,)|[0-9a-zA-Z\\(\\)\\@\\:\\,\\/\\!\\+\\-\\.\\$\\ \\\\\\']*)" +
                            "(?:\\\")?").matcher(jsonData);
            while (matcherXml.find()) {
                jsonList.add(matcherXml.group(1));
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return jsonList;
    }

/*
    public static void print(Car car) {
        System.out.printf("Manufacturer: %s, Engine: %s, Color: %s, Count: %d, Price: %d \n",
                car.getManufacturer(), car.getEngine(), car.getColor(), car.getCount(), car.getPrice());
    }

 */
}

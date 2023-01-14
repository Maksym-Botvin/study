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
    public Map readFileCreateMap(final String path) {
        String regex = "";
        if (path.endsWith(".xml")) {
            regex = "<(.*?)>(.*)<(.*?)>";
        } else if (path.endsWith(".json")) {
            regex = "(?:\\\"|\\')([^\\\"]*)(?:\\\"|\\')(?=:)(?:\\:\\s*)(?:\\\")?(true|false|[-0-9]+[\\.]*[\\d]*(?=,)|[0-9a-zA-Z\\(\\)\\@\\:\\,\\/\\!\\+\\-\\.\\$\\ \\\\\\']*)(?:\\\")?";
        } else {
            throw new NullPointerException("Wrong file!");
        }
        final ClassLoader loader = Thread.currentThread().getContextClassLoader();
        final BufferedInputStream input = (BufferedInputStream) loader.getResourceAsStream(path);
        final Map<String, String> carMap = new LinkedHashMap<>();// HashMap
        final byte[] array = new byte[1000];
        try {
            input.read(array);
            final String data = new String(array);
            final Matcher matcher = Pattern.compile(regex).matcher(data);
            while (matcher.find()) {
                carMap.put(matcher.group(1), matcher.group(2));
            }
            input.close();
        } catch (
                Exception e) {
            e.getStackTrace();
        }
        return carMap;
    }

    private void setFieldsOfCar(Map<String, String> mapByFile, Car car) {
        Optional.ofNullable(mapByFile.get("manufacturer")).
                ifPresent(car::setManufacturer);
        Optional.ofNullable(mapByFile.get("power")).
                ifPresent(s -> car.getEngine().setPower(Integer.parseInt(s)));
        Optional.ofNullable(mapByFile.get("color")).
                ifPresent(s -> car.setColor(Color.valueOf(s)));
        Optional.ofNullable(mapByFile.get("passengerCount")).
                ifPresent(s -> ((PassengerCar) car).setPassengerCount(Integer.parseInt(s)));
        Optional.ofNullable(mapByFile.get("loadCapacity")).
                ifPresent(s -> ((Truck) car).setLoadCapacity(Integer.parseInt(s)));
        Optional.ofNullable(mapByFile.get("id")).
                ifPresent(car::setId);
        Optional.ofNullable(mapByFile.get("typeOfCar")).
                ifPresent(s -> car.setType(Type.CAR));
        Optional.ofNullable(mapByFile.get("count")).
                ifPresent(s -> car.setCount(Integer.parseInt(s)));
        Optional.ofNullable(mapByFile.get("price")).
                ifPresent(s -> car.setPrice(Integer.parseInt(s)));
    }

    public Car mapToCar(Map<String, String> mapByFile) {
        if (mapByFile == null) {
            throw new NullPointerException("Map not exist");
        }
        final Function<Map<String, String>, Car> function = m -> {
            if (m.get("typeOfCar").equals("CAR")) {
                PassengerCar passengerCar = new PassengerCar();
                passengerCar.setEngine(new Engine("Diesel"));
                setFieldsOfCar(m, passengerCar);
                return passengerCar;
            } else if (m.get("typeOfCar").equals("TRUCK")) {
                Truck truck = new Truck();
                truck.setEngine(new Engine("Benzine"));
                setFieldsOfCar(m, truck);
                return truck;
            } else {
                throw new NullPointerException("Type of car not exist");
            }
        };
        return function.apply(mapByFile);
    }

/*
    public static void print(Car car) {
        System.out.printf("Manufacturer: %s, Engine: %s, Color: %s, Count: %d, Price: %d \n",
                car.getManufacturer(), car.getEngine(), car.getColor(), car.getCount(), car.getPrice());
    }

 */
}

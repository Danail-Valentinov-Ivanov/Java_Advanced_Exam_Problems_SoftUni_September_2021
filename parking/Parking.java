package parking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (data.size() < capacity) {
            data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        if (!data.isEmpty()) {
            for (Car car : data) {
                if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                    data.remove(car);
                    return true;
                }
            }
        }
        return false;
    }

    public Car getLatestCar() {
        if (!data.isEmpty()) {
            return data.stream().max((e1, e2) -> Integer.compare(e1.getYear(), e2.getYear())).get();
        }
        return null;
    }

    public Car getCar(String manufacturer, String model) {
        List<Car> filteredData = data.stream().filter(car -> car.getManufacturer().equals(manufacturer))
                .filter(car -> car.getModel().equals(model)).collect(Collectors.toList());
        if (!filteredData.isEmpty()) {
            for (Car car : filteredData) {
                return car;
            }
        }
        return null;
    }

    public int getCount() {
        return data.size();
    }

    //    The cars are parked in {parking type}:
//{Car1}
//{Car2}
//(…)
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder(String.format("The cars are parked in %s:", type))
                .append(System.lineSeparator());
        for (Car car : data) {
            stringBuilder.append(car.toString()).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}

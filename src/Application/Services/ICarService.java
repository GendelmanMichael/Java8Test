package Application.Services;

import java.util.List;

import Application.Entities.Car;

public interface ICarService {

	Car addRandomCar();

	int addRandomCars(int num);

	List<Car> getCarsByModel(String model);

	List<Car> getCarsByExample(String model, boolean ac);

}
package Application.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import Application.Entities.Car;
import Application.Repository.CarJPArepository;

@Service
public class CarService implements ICarService {

	@Autowired CarJPArepository carRepo;

	@Override
	public Car addRandomCar() {
		return carRepo.save(Car.getRandomCar());
	}

	@Override
	public int addRandomCars(int num) {
		ArrayList<Car> garage = new ArrayList<>();
		for (int i = 0 ; i < num ; i++) garage.add(Car.getRandomCar());
		carRepo.saveAll(garage);
		return garage.size();
	}

	@Override
	public List<Car> getCarsByModel(String model){
		return carRepo.findByModel(model);
	}

	@Override
	public List<Car> getCarsByExample(String model, boolean ac) {
		return carRepo.findAll(Example.of(new Car(null, model, null, null, ac)));
	}
}

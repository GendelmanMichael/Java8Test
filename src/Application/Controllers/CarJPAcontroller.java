package Application.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import Application.Entities.Car;
import Application.Services.ICarService;

@RestController
public class CarJPAcontroller {

	@Autowired ICarService service;
	
	@GetMapping("/addRandomCar")
	public Car addRandomCar() {
		return service.addRandomCar();
	}
	
	@GetMapping("/addRandomCars")
	public int addRandomCar(int num) {
		return service.addRandomCars(num);
	}
	
	@GetMapping("/getCarsByModel")
	public List<Car> getCarsByModel(String model){
		return service.getCarsByModel(model);
	}
	
	@GetMapping("/getCarsByModelAndAc")
	public List<Car> getCarsByAC(String model, boolean ac){
		return service.getCarsByExample(model, ac);
	}
}

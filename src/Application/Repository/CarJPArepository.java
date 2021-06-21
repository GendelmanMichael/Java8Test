package Application.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Application.Entities.Car;

public interface CarJPArepository extends JpaRepository<Car, Integer> {

	List<Car> findByModel(String model);

}

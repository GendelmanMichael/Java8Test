package Application.Entities;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name="car")
public class Car {

	private static final String[] MODELS = {"Ford", "Toyota", "Kia", "Lexus", "Audi"};
	private static final int MIN_YEAR = 2000;
	private static final int MAX_YEAR = 2020;
	private static final double MIN_ENGINE = 1.0;
	private static final double MAX_ENGINE = 2.0;
	private static final double AC_PROBABILITY = 0.5;

	static private Random gen = new Random();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 200)
	private String model;
	private Integer year;
	private Double engine;
	private Boolean ac;

	public static Car getRandomCar() {

		String randomModel = MODELS[gen.nextInt(MODELS.length)];
		int randomYear = MIN_YEAR + gen.nextInt(MAX_YEAR - MIN_YEAR + 1);
		double randomEngine = MIN_ENGINE + gen.nextDouble()*(MAX_ENGINE - MIN_ENGINE);
		boolean randomAc = gen.nextDouble() < AC_PROBABILITY;

		return new Car(0, randomModel, randomYear, randomEngine, randomAc);
	}
}

package lab5.carwash;

/**
 * This class keeps track of the total amount of cars created.
 *	The carCount variable is kept static because it is used for creating unique car ID:s.
 */
public class CarFactory{
	
	private static int carCount = -1;

	/**
	 * newCar() keeps track of the number of cars that is currently in the simulation.
	 * With the class own private variable the numberOfCars variable is incremented at each call to the method.
	 * @return create a new car object and returns it.
	 */
	public static Car newCar(){
		carCount++;
		return new Car(carCount);
	}
	/**
	 * @return The total number of cars that have been created.
	 */
	public static int numberOfCars(){
		return carCount;
	}
}

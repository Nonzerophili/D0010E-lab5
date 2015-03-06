package lab5.carwash;

public class CarFactory{
	
	private static int carCount = 0;

	/**
	 * newCar() keeps track of the number of cars that is currently in the simulation.
	 * With the class own private variable the numberOfCars variable is incremented at each call to the method.
	 * @return
	 */
	public void newCar(){
		carCount++;
		new Car(carCount);
	}
	/**
	 * 
	 * @return
	 */
	public int numberOfCars(){
		return carCount;
	}
}

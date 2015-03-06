package lab5.carwash;

public class Car {
	
	private int carID;
	
	/**
	 * Car Constructor, creates a Car object with an ID.
	 * @param carID
	 */
	public Car(int carID){
		this.carID = carID;
	}
	/**
	 * Each Car has it's own ID.
	 * @return the ID of the Car.
	 */
	public int carID(){
		return carID;
	}
}

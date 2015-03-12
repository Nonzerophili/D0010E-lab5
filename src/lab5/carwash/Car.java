package lab5.carwash;

/**
 * This class constructor creates a car object. Each car has its own unique carID.
 */
public class Car{
	
	private int carID;
	String previousMachine = "";
	
	/**
	 * Car Constructor, creates a Car object with an ID.
	 * @param carID
	 */
	public Car(int carID){
		this.carID = carID;
	}
	/**
	 * @return ID of the Car.
	 */
	public int carID(){
		return carID;
	}
	/**
	 * 
	 * @return The method returns which carwash machine the car left.
	 */
	public String previousMachine(){
		return previousMachine;
	}
}

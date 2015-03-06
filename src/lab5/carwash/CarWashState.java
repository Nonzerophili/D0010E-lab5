package lab5.carwash;

public class CarWashState {

	private static int rejectedCars = 0;			//Total number of cars that have been rejected from both the slow and fast carWashes combined.
	private static boolean fastWashEmpty = true;
	private static boolean slowWashEmpty = true;
	private static double fastWashTime = 0;
	private static double slowWashTime = 0;
	private static int fastWashesAmount = 0;
	private static int slowWashesAmount = 0;
	
	
	public boolean fastIsEmpty(){
		return (fastWashEmpty) ? true : false;
	}
	public boolean slowIsEmpty(){
		return (slowWashEmpty) ? true : false;
	}
	public static int slowWashesAmount(){
		return slowWashesAmount;
	}
	public static int fastWashesAmount(){
		return fastWashesAmount;
	}
	public static int rejectedCars(){
		return rejectedCars;
	}
}

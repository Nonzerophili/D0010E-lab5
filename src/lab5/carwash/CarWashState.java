package lab5.carwash;

public class CarWashState {

	static int rejectedCars = 0;			//Total number of cars that have been rejected from both the slow and fast carWashes combined.
	
	private static double fastWashTime = 0;
	private static double slowWashTime = 0;
	
	private static int totalFastMachines = 0;
	private static int totalSlowMachines = 0;
	static int availableFastMachines = 0;
	static int availableSlowMachines = 0;
	
	private static double totalWashTime = 0;
	private static double queueTime = 0;
	private static int seed = 1234;
	
	private static double distributionFastLower = 0;
	private static double distributionFastUpper = 0;
	
	private static double distributionSlowUpper = 0;
	private static double distributionslowUpper = 0;
	
	private static double lambda = 0;
	
	static int maxQueueSize = 0;
	
	
	public static boolean fastAvailable(){
		return (availableFastMachines > 0) ? true : false;
	}
	public static boolean slowAvailable(){
		return (availableSlowMachines > 0) ? true : false;
	}
	public static int slowWashesAmount(){
		return totalSlowMachines;
	}
	public static int fastWashesAmount(){
		return totalFastMachines;
	}
	public static int rejectedCars(){
		return rejectedCars;
	}
}

package lab5.carwash;
import lab5.random.ExponentialRandomStream;
import lab5.random.UniformRandomStream;

public class CarWashState {

	static FIFO FIFO;
	
	private static int totalFastMachines = 0;
	private static int totalSlowMachines = 0;
	static int availableFastMachines = 0;
	static int availableSlowMachines = 0;

	private static double fastWashTime = 0.00;
	private static double slowWashTime = 0.00;
	
	private static double totalWashTime = 0.00;
	private static double totalQueueTime = 0.00;
	
	double currentTime = 0.00;
	double previousTotalIdleTime = 0.00;
	double previousCurrentTime = 0.00;
	
	private static double distributionFastLower = 2.8;
	private static double distributionFastUpper = 4.6;
	private static double distributionSlowLower = 3.5;
	private static double distributionslowUpper = 6.7;
	
	private static double lambda = 2;
	private static int seed = 1234;
	
	private static UniformRandomStream slowMachineTime = new UniformRandomStream(distributionSlowLower,distributionslowUpper,seed);
	private static UniformRandomStream fastMachineTime  = new UniformRandomStream(distributionSlowLower,distributionslowUpper,seed);
	
	private ExponentialRandomStream timeToNextCarArrival = new ExponentialRandomStream(lambda,seed);
	
	static int maxQueueSize = 0;
	static int queueSize = 0;
	static int rejectedCars = 0;
	
	/*	• For car arrivals ExponentialRandomStream(2, 1234) and ExponentialRandomStream(1.5, 1234),
		• for fast machines UniformRandomStream(2.8, 4.6, 1234) and UniformRandomStream(2.8, 5.6, 1234), and
		• for slow machines UniformRandomStream(3.5, 6.7, 1234) and UniformRandomStream(4.5, 6.7, 1234), respectively.*/
	
	public static boolean fastAvailable(){
		return (availableFastMachines > 0) ? true : false;
	}
	public static boolean slowAvailable(){
		return (availableSlowMachines > 0) ? true : false;
	}
	public static int getTotalSlowMachines(){
		return totalSlowMachines;
	}
	public static int getTotalFastMachines(){
		return totalFastMachines;
	}
	public static int rejectedCars(){
		return rejectedCars;
	}
	public double getTotalIdleTime(){
		double totalIdleTime = currentTime * (availableFastMachines + availableSlowMachines) + previousTotalIdleTime; 
		previousTotalIdleTime = totalIdleTime;
		return totalIdleTime;
	}
	public double newEventTime(){
		currentTime += timeToNextCarArrival.next();
		return currentTime;
	}
	public double totalQueueTime(){
		totalQueueTime = (currentTime - previousCurrentTime)*FIFO.getSize();
		previousCurrentTime = totalQueueTime;
		return totalQueueTime;
		
	}
	public static double meanQueueTime(){
		
		
		return 0;
	}
	
}
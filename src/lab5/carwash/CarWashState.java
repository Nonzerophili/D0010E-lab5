package lab5.carwash;
import lab5.random.ExponentialRandomStream;
import lab5.random.UniformRandomStream;
import lab5.simulator.Event;
import lab5.simulator.SimState;

/**
 * This class keeps track of the state of the carwash.
 */
public class CarWashState extends SimState{

	private static int totalFastMachines = 2;
	private static int totalSlowMachines = 2;
	static int availableFastMachines = 2;
	static int availableSlowMachines = 2;
	
	static int maxQueueSize = 5;
	static int rejectedCars = 0;
	static String currentEvent = "";
	
	static double distributionFastLower = 2.8;
	static double distributionFastUpper = 4.6;
	static double distributionSlowLower = 3.5;
	static double distributionSlowUpper = 6.7;
	
	static double currentTime = 0.00;
	
	static double totalQueueTime = 0.00;
	static double totalIdleTime = 0.00;
	
	private double previousCurrentTime = 0.00;
	private double previousTotalQueueTime = 0.00;
	
	static double lambda = 2;
	static int seed = 1234;
	
	private UniformRandomStream slowMachineTime = new UniformRandomStream(distributionSlowLower,distributionSlowUpper,seed);
	private UniformRandomStream fastMachineTime  = new UniformRandomStream(distributionFastLower,distributionFastUpper,seed);
	private ExponentialRandomStream timeToNextCarArrival = new ExponentialRandomStream(lambda,seed);
	
	/**
	 * Each event must have an arrival time which states when the event will occur.
	 * This method is called each time and event is created.
	 * 
	 * @return Returns the arrival time for the event.
	 */
	double newEventTime(){						
		currentTime += timeToNextCarArrival.next();
		return currentTime;
	}
	
	/**
	 * @return Returns the time that the event will spend in the fast carwash.
	 */
	double getFastWashTime(){
		return fastMachineTime.next();
	}

	/**
	 * @return Returns the time that the event will spend in the slow carwash.
	 */
	double getSlowWashTime(){
		return slowMachineTime.next();
	}
	
	/**
	 * This method updates the totalIdle time. Which is the time that the machines are empty, but the simulation is running.
	 * 
	 * @param e The event that is being processed.
	 */
	void updateTotalIdleTime(Event e){
		totalIdleTime += (e.time - previousCurrentTime) * (availableFastMachines + availableSlowMachines);
		previousCurrentTime = e.time;
	}
	
	/**
	 * This method updates the totalQueue time. Which is the time that the cars have to spend in the FIFO queue before entering the machines.
	 * @param e
	 */
	void updateTotalQueueTime(Event e){
		totalQueueTime += (e.time - previousTotalQueueTime) * FIFO.carQueue.size();
		previousTotalQueueTime = e.time;
	}
	
	/**
	 * Checks if the fast machine can accept a car. If the machine is full. The car will have to either go to the FIFO or get rejected.
	 * @return returns true if there is a fast machine that is empty.
	 */
	static boolean fastAvailable(){
		return (availableFastMachines > 0) ? true : false;
	}
	
	/**
	 * Checks if the fast machine can accept a car. If the machine is full. The car will have to either go to the FIFO or get rejected.
	 * @return returns true if there is a slow machine that is empty.
	 */
	static boolean slowAvailable(){
		return (availableSlowMachines > 0) ? true : false;
	}
	
	/**
	 * @return Returns the total amount of slow carwashes that exist in the simulation.
	 */
	static int getTotalSlowMachines(){
		return totalSlowMachines;
	}
	
	/**
	 * @return Returns the total amount of slow carwashes that exist in the simulation.
	 */
	static int getTotalFastMachines(){
		return totalFastMachines;
	}
	/**
	 * @return Returns the total amount of car that have been rejected from the simulation. (Due to FIFO maxSize reached)
	 */
	static int rejectedCars(){
		return rejectedCars;
	}
}
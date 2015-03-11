package lab5.carwash;
import lab5.random.ExponentialRandomStream;
import lab5.random.UniformRandomStream;
import lab5.simulator.Event;
import lab5.simulator.SimState;

public class CarWashState extends SimState{

	static FIFO FIFO;

	static int totalFastMachines = 2;
	static int totalSlowMachines = 2;
	static int availableFastMachines = 2;
	static int availableSlowMachines = 2;
	
	static int maxQueueSize = 5;
	static int queueSize = 0;
	static int rejectedCars = 0;
	
	//-----------------------------------------------TIME------------------------------------------------------------------------------
	static double distributionFastLower = 2.8;
	static double distributionFastUpper = 4.6;
	static double distributionSlowLower = 3.5;
	static double distributionSlowUpper = 6.7;
	
	static double currentTime = 0.00;
	
	static double totalWashTime = 0.00;
	static double totalQueueTime = 0.00;
	static double totalIdleTime = 0.00;
	
	double previousCurrentTime = 0.00;
	double previousTotalIdleTime = 0.00;
	double previousTotalQueueTime = 0.00;
	
	static double lambda = 2;
	static int seed = 1234;
	
	private UniformRandomStream slowMachineTime = new UniformRandomStream(distributionSlowLower,distributionSlowUpper,seed);
	private UniformRandomStream fastMachineTime  = new UniformRandomStream(distributionFastLower,distributionFastUpper,seed);
	
	private ExponentialRandomStream timeToNextCarArrival = new ExponentialRandomStream(lambda,seed);
	
	/*	• For car arrivals ExponentialRandomStream(2, 1234) and ExponentialRandomStream(1.5, 1234),
		• for fast machines UniformRandomStream(2.8, 4.6, 1234) and UniformRandomStream(2.8, 5.6, 1234), and
		• for slow machines UniformRandomStream(3.5, 6.7, 1234) and UniformRandomStream(4.5, 6.7, 1234), respectively.*/
	
	public double newEventTime(){						//Calculate the time for the new Event.
		currentTime += timeToNextCarArrival.next();
		return currentTime;
	}
	public double getFastWashTime(){					//Wash time for the fast machine.
		return slowMachineTime.next();
	}
	public double getSlowWashTime(){					//Wash time for the slow machine.
		return fastMachineTime.next();
	}
	public void updateTotalIdleTime(Event e){			//Takes the event.time (which is the currentTime when the Event should happen)
		//totalIdleTime = currentTime * (availableFastMachines + availableSlowMachines) + previousTotalIdleTime;
		totalIdleTime += (e.time - previousTotalIdleTime) * (availableFastMachines + availableSlowMachines);
		previousTotalIdleTime = e.time;
	}
	public void updateTotalQueueTime(Event e){
		//totalQueueTime = (currentTime - previousCurrentTime)*FIFO.getSize();
		totalQueueTime = (e.time - previousTotalQueueTime) * FIFO.getSize();
		previousTotalQueueTime = e.time;
	}
	//----------------------------------------------------------------------------------------------------------------------------------
	
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
}
package lab5.carwash;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Observable;

import lab5.simulator.Event;
import lab5.simulator.SimState;
import lab5.simulator.SimView;
import lab5.carwash.CarWashState;

/**
 * This class prints the state of the simulation. First we have an initial print and then an update method that prints the state each time and event is executed.
 * Lastly we have an end print which prints and summarize the state after all of the events have happened.
 */
public class CarWashView extends SimView{

	CarWashState CWS;
	Car car;
	
	/**
	 * Class constructor. super(CWS) call the parent constructor with CWS as an argument.
	 * @param CWS CarWashState parent constructor call with CWS.
	 */
	public CarWashView(SimState CWS){
		super(CWS);
	}

	/**
	 * Prints the initial print of the carwash state. This method is called from the simulator class.
	 * This print is static. The states will change while the events are being executed.
	 */
	public void initialPrint(){
		System.out.println("Fast CarWashes: "+ CarWashState.getTotalFastMachines());
		System.out.println("Slow CarWashes: "+ CarWashState.getTotalSlowMachines());
		System.out.println("Fast Distribution: ("+CarWashState.distributionFastLower+","+CarWashState.distributionFastUpper+")");
		System.out.println("Slow Distribution: ("+CarWashState.distributionSlowLower+","+CarWashState.distributionSlowUpper+")");
		System.out.println("Exponential distribution with lambda = "+CarWashState.lambda);
		System.out.println("Seed = " + CarWashState.seed);
		System.out.println("Max Queue size: "+ CarWashState.maxQueueSize);
		System.out.println("----------------------------------------------------");
		System.out.printf("%4s %9s %9s %7s %11s %13s %14s %14s %13s\n","Time","Fast","Slow","ID","Event","IdleTime","QueueTime","QueueSize","Rejected");
	}
	
	/**
	 * This method is called everytime there is a call to the notifyObservers() method. Every time we enter an event's execute method. This method will be
	 * called and the state will be printed.
	 * Since the type of the event is sent to the notifyObserver() method we can access this type from the Object Obj which is sent as and parameter in the
	 * update method.
	 */
	public void update(Observable obs, Object obj){ 
		
		NumberFormat fmt = new DecimalFormat("#0.00");
		Event temp = (Event) obj;
		
		if(temp instanceof Start){
			System.out.printf("%-5s %6s %9s %9s %11s %11.4s %14s %12s %12s\n",
					fmt.format(temp.time),
					CarWashState.availableFastMachines, 
					CarWashState.availableSlowMachines,
					"-",
					"Start",
					fmt.format(CarWashState.totalIdleTime),
					fmt.format(CarWashState.totalQueueTime),
					FIFO.getSize(),
					CarWashState.rejectedCars());
		}
		if(temp instanceof Stop){
			System.out.printf("%-5s %6s %9s %9s %11s %11.4s %14s %12s %12s\n",
					fmt.format(temp.time),
					CarWashState.availableFastMachines,
					CarWashState.availableSlowMachines,
					"-",
					"Stop",
					fmt.format(CarWashState.totalIdleTime),
					fmt.format(CarWashState.totalQueueTime),
					FIFO.getSize(),
					CarWashState.rejectedCars());
		}
		if(temp instanceof Arrive){
			Arrive temp2 = (Arrive) temp;
			System.out.printf("%-5s %6s %9s %9s %11s %11.4s %14s %12s %12s\n",
					fmt.format(temp.time),
					CarWashState.availableFastMachines,
					CarWashState.availableSlowMachines,
					temp2.car.carID(),
					//"ID",
					"Arrive",
					fmt.format(CarWashState.totalIdleTime),
					fmt.format(CarWashState.totalQueueTime),
					FIFO.getSize(),
					CarWashState.rejectedCars());
		}
		if(temp instanceof Leave){
			Leave temp2 = (Leave) temp;
			System.out.printf("%-5s %6s %9s %9s %11s %11.4s %14s %12s %12s\n",
					fmt.format(temp.time),
					CarWashState.availableFastMachines,
					CarWashState.availableSlowMachines,
					temp2.car.carID(),
					"Leave",
					fmt.format(CarWashState.totalIdleTime),
					fmt.format(CarWashState.totalQueueTime),
					FIFO.getSize(),
					CarWashState.rejectedCars());
		}
	}
	
	/**
	 * This is the method that will be invoked after all of the events have happened.
	 * Add up the total times and prints them.
	 */
	public void endPrint(){
		NumberFormat fmt = new DecimalFormat("#0.00");
		System.out.println("----------------------------------------------------");
		System.out.println("Total idle machine time: " + fmt.format(CarWashState.totalIdleTime));
		System.out.println("Total queueing time: " + fmt.format(CarWashState.totalQueueTime));
		System.out.println("Mean queueing time: " + fmt.format(CarWashState.totalQueueTime/(CarFactory.numberOfCars() - CarWashState.rejectedCars())));	//rejected ?
		System.out.println("Rejected cars: " + CarWashState.rejectedCars());
	}
}

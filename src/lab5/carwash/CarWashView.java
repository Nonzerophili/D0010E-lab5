package lab5.carwash;
import java.util.Observable;

import lab5.simulator.Event;
import lab5.simulator.SimState;
import lab5.simulator.SimView;
import lab5.carwash.CarWashState;

public class CarWashView extends SimView{

	CarWashState CWS;
	static FIFO FIFO;
	Car car;
	
	public CarWashView(SimState CWS){		//hmm.
		//super(CWS);
		//CWS = (CarWashState) SS;
	}
	
	public void initialPrint(){
		System.out.println("Fast CarWashes: "+ CarWashState.getTotalFastMachines());
		System.out.println("Slow CarWashes: "+ CarWashState.getTotalSlowMachines());
		System.out.println("Fast Distribution: ("+CarWashState.distributionFastLower+","+CarWashState.distributionFastUpper+")");
		System.out.println("Slow Distribution: ("+CarWashState.distributionSlowLower+","+CarWashState.distributionSlowUpper+")");
		System.out.println("Exponential distribution with lambda = "+CarWashState.lambda);
		System.out.println("Seed = " + CarWashState.seed);
		System.out.println("Max Queue size: "+ CarWashState.maxQueueSize);
		System.out.println("----------------------------------------------------");
		System.out.printf("%4s%9s%9s%7s%11s%13s%14s%14s%13s\n","Time","Fast","Slow","ID","Event","IdleTime","QueueTime","QueueSize","Rejected");
		System.out.printf("%-4.2f%9s%9s%7s%11s%13.2f%14.2f%14s%13s\n",CarWashState.currentTime,CarWashState.availableFastMachines,CarWashState.availableSlowMachines,"-","Start",CarWashState.totalIdleTime,CarWashState.totalQueueTime,FIFO.getSize(),CarWashState.rejectedCars());
	}
	
	/*obs is the object that extends Observable and has the notifyObservers method. 
	 * You can cast obs to your object that extends Observable and then call the methods you need. 
	 * obj is the optional parameter that can be passed to notifyObservers.
	 * */
	
	public void update(Observable obs, Object obj){	// obs = SimState, 
		
		//System.out.println("test");
		//CarWashEvent carWashEvent = (CarWashEvent)obj;
		
		//Event temp = (Event) obj;
		if(obj instanceof Start){
			System.out.printf("%4s%9s%9s%7s%11s%13s%14s%14s%13s\n",CarWashState.currentTime,CarWashState.availableFastMachines,CarWashState.availableSlowMachines,"ID","Start",CarWashState.totalIdleTime,CarWashState.totalQueueTime,FIFO.getSize(),CarWashState.rejectedCars());
		}
		if(obj instanceof Stop){
			System.out.printf("%4s%9s%9s%7s%11s%13s%14s%14s%13s\n",CarWashState.currentTime,CarWashState.availableFastMachines,CarWashState.availableSlowMachines,"-","Stop",CarWashState.totalIdleTime,CarWashState.totalQueueTime,FIFO.getSize(),CarWashState.rejectedCars());
		}
		if(obj instanceof Arrive){
			//Arrive temp2 = (Arrive) temp;
			System.out.printf("%4s%9s%9s%7s%11s%13s%14s%14s%13s\n",CarWashState.currentTime,CarWashState.availableFastMachines,CarWashState.availableSlowMachines,"ID","Arrive",CarWashState.totalIdleTime,CarWashState.totalQueueTime,FIFO.getSize(),CarWashState.rejectedCars());
		}
		if(obj instanceof Leave){
			System.out.printf("%4s%9s%9s%7s%11s%13s%14s%14s%13s\n",CarWashState.currentTime,CarWashState.availableFastMachines,CarWashState.availableSlowMachines,"-","Leave",CarWashState.totalIdleTime,CarWashState.totalQueueTime,FIFO.getSize(),CarWashState.rejectedCars());
		}
		
		/*if(CarWashState.currentEvent == "ARRIVE"){
			System.out.printf("%4s%9s%9s%7s%11s%13s%14s%14s%13s\n",CarWashState.currentTime,CarWashState.availableFastMachines,CarWashState.availableSlowMachines,"ID","Arrive",CarWashState.totalIdleTime,CarWashState.totalQueueTime,FIFO.getSize(),CarWashState.rejectedCars());
		}
		if(CarWashState.currentEvent == "START"){
			System.out.printf("%4s%9s%9s%7s%11s%13s%14s%14s%13s\n",CarWashState.currentTime,CarWashState.availableFastMachines,CarWashState.availableSlowMachines,"ID","Start",CarWashState.totalIdleTime,CarWashState.totalQueueTime,FIFO.getSize(),CarWashState.rejectedCars());
		}
		if(CarWashState.currentEvent == "LEAVE"){
			System.out.printf("%4s%9s%9s%7s%11s%13s%14s%14s%13s\n",CarWashState.currentTime,CarWashState.availableFastMachines,CarWashState.availableSlowMachines,"-","Leave",CarWashState.totalIdleTime,CarWashState.totalQueueTime,FIFO.getSize(),CarWashState.rejectedCars());
		}*/
	}
	public void endPrint(){
		System.out.println("----------------------------------------------------");
		System.out.println("Total idle machine time: " + CarWashState.totalIdleTime);
		System.out.println("Total queueing time: " + CarWashState.totalQueueTime);
		System.out.println("Mean queueing time: " + CarWashState.totalQueueTime/(CarFactory.numberOfCars() - CarWashState.rejectedCars()));	//rejected ?
		System.out.println("Rejected cars: " + CarWashState.rejectedCars());
	}
}

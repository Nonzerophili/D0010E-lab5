package lab5.carwash;
import java.util.Observable;
import java.util.Observer;
import lab5.simulator.SimView;
import lab5.carwash.CarWashState;

public class CarWashView extends SimView implements Observer {

	//CarWashState CWS;
	//FIFO FIFO;
	
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
	public void update(Observable observedObject, Object modifiedObject){	//(arg0 Object that is being observed. arg1 Object that have changed.)
		
		CarWashEvent carWashEvent = (CarWashEvent)modifiedObject;
		
		if(carWashEvent.getEventType() == "ARRIVE"){
			System.out.printf("%4s%9s%9s%7s%11s%13s%14s%14s%13s\n",CarWashState.currentTime,CarWashState.availableFastMachines,CarWashState.availableSlowMachines,"CARID !!","Arrive",CarWashState.totalIdleTime,CarWashState.totalQueueTime,FIFO.getSize(),CarWashState.rejectedCars());
		}
		/*if(carWashEvent.getEventType() == "LEAVE"){
			System.out.printf("%4s%9s%9s%7s%11s%13s%14s%14s%13s\n",CWS.currentTime,CWS.availableFastMachines,CWS.availableSlowMachines,"CARID !!","Leave",CWS.totalIdleTime,CWS.totalQueueTime,FIFO.getSize(),CWS.rejectedCars());
		}
		if(carWashEvent.getEventType() == "STOP"){
			System.out.printf("%4s%9s%9s%7s%11s%13s%14s%14s%13s\n",CWS.currentTime,CWS.availableFastMachines,CWS.availableSlowMachines,"-","Stop",CWS.totalIdleTime,CWS.totalQueueTime,FIFO.getSize(),CWS.rejectedCars());
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

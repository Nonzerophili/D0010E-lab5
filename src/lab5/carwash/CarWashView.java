package lab5.carwash;
import java.util.Observable;
import java.util.Observer;
import lab5.simulator.SimView;
import lab5.carwash.CarWashState;

public class CarWashView extends SimView implements Observer {

	CarWashState CWS;
	FIFO FIFO;
	
	public void initialPrint(){
		System.out.println("Fast CarWashes: "+ CarWashState.fastWashesAmount());
		System.out.println("Slow CarWashes: "+ CarWashState.slowWashesAmount());
		System.out.println("Fast Distribution: ");
		System.out.println("Slow Distribution: ");
		System.out.println("Exponential distribution with lambda = ");
		System.out.println("Seed = ");
		System.out.println("Max Queue size: ");
		System.out.println("----------------------------------------------------");
		System.out.printf("%-12s%-12s%s\n","Time","Fast","Slow","ID","Event","IdleTime","QueueTime","QueueSize","Rejected");
	}
	public void update(Observable observedObject, Object modifiedObject){	//(arg0 Object that is being observed. arg1 Object that have changed.)
		
		CarWashEvent carWashEvent = (CarWashEvent)modifiedObject;
		
		if(carWashEvent.getEventType() == "ARRIVE"){
			System.out.printf("%-12s%-12s%s",CWS.currentTime,CWS.availableFastMachines,CWS.availableSlowMachines,"CARID !!","Arrive",CWS.getTotalIdleTime(),CWS.totalQueueTime(),FIFO.getSize(),CWS.rejectedCars());
		}
		if(carWashEvent.getEventType() == "LEAVE"){
			System.out.printf("%-12s%-12s%s",CWS.currentTime,CWS.availableFastMachines,CWS.availableSlowMachines,"CARID !!","Leave",CWS.getTotalIdleTime(),CWS.totalQueueTime(),FIFO.getSize(),CWS.rejectedCars());
		}
		if(carWashEvent.getEventType() == "STOP"){
			System.out.printf("%-12s%-12s%s",CWS.currentTime,CWS.availableFastMachines,CWS.availableSlowMachines,"-","Stop",CWS.getTotalIdleTime(),CWS.totalQueueTime(),FIFO.getSize(),CWS.rejectedCars());
		}
	}
	public void endPrint(){
		System.out.println("----------------------------------------------------");
		System.out.println("Total idle machine time: "+ CWS.getTotalIdleTime());
		System.out.println("Total queueing time: "+ CWS.totalQueueTime());
		System.out.println("Mean queueing time: "+ "");		//OBS MEAN QUEUE TIME
		System.out.println("Rejected cars: " + CWS.rejectedCars());
	}
}

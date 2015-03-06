package lab5.carwash;
import java.util.Observable;
import java.util.Observer;
import lab5.simulator.SimView;
import lab5.carwash.CarWashState;

public class CarWashView extends SimView implements Observer {

	public void initialPrint(){
		System.out.println("Fast CarWashes: "+ CarWashState.fastWashesAmount());
		System.out.println("Slow CarWashes: "+ CarWashState.slowWashesAmount());
		System.out.println("Fast Distribution: ");
		System.out.println("Slow Distribution: ");
		System.out.println("Exponential distribution with lambda = ");
		System.out.println("Seed = ");
		System.out.println("Max Queue size: ");
		System.out.println("----------------------------------------------------");
		System.out.format("%d2s4 ");
	}
	public void update(Observable observedObject, Object modifiedObject){	//(arg0 Object that is being observed. arg1 Object that have changed.)
		
		CarWashEvent carWashEvent = (CarWashEvent)modifiedObject;
		
		if(carWashEvent.START){
			initialPrint(); // hmm
		}
		if(carWashEvent.STOP){
			endPrint();
		}
		if(carWashEvent.ARRIVE){
			System.out.format("");
		}
		if(carWashEvent.LEAVE){
			
		}
		
	}
	public void endPrint(){
		System.out.println("----------------------------------------------------");
		System.out.println("Total idle machine time: ");
		System.out.println("Total queueing time: ");
		System.out.println("Mean queueing time: ");
		System.out.println("Rejected cars: ");
	}
}

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
	}
	public void update(Observable arg0, Object arg1){	//(arg0 Object that is being observed. arg1 Object that have changed.)
		
	}
	public void endPrint(){
		System.out.println("----------------------------------------------------");
		System.out.println("Total idle machine time: ");
		System.out.println("Total queueing time: ");
		System.out.println("Mean queueing time: ");
		System.out.println("Rejected cars: ");
	}
}

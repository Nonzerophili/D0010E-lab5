package lab5.simulator;
import java.util.Observable;

public class SimState extends Observable {
	
	private static boolean RUNNING = true;
	
	public boolean isRunning(){
		return RUNNING;
	}
	public void setRUNNING(Boolean bool){
		RUNNING = (bool == true) ? true : false;
	}
	public void observable(Event e){
		//System.out.println("Observable");
		setChanged();
		notifyObservers();
	}
	/*public SimState(){
		
	}*/
}

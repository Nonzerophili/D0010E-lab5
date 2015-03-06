package lab5.simulator;
import java.util.Observable;

public class SimState extends Observable {
	
	private static boolean RUNNING = false;
	private static double currentTime = 0;
	
	public boolean isRunning(){
		return RUNNING;
	}
	public void setRUNNING(Boolean bool){
		RUNNING = (bool == true) ? true  : false ;
	}
}

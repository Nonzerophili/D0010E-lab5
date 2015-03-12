package lab5.simulator;
import java.util.Observable;

/**
 * Keeps track of the Simulation states.
 */
public class SimState extends Observable {
	
	private static boolean RUNNING = true;
	
	/**
	 * @return Returns true if the Simulation is running.
	 */
	public boolean isRunning(){
		return RUNNING;
	}
	/**
	 * Sets the RUNNING Variable.
	 * @param bool
	 */
	public void setRUNNING(Boolean bool){
		RUNNING = bool;
	}
	/**
	 * This method is called from each event. When the state have changed this method is responsible for sending out
	 * the event state to the view.
	 * @param event
	 */
	public void observable(Event event){
		setChanged();
		notifyObservers(event);
	}
}

package lab5.simulator;
import java.util.ArrayList;

/**
 * This class keeps track of the events in the simulation. 
 */
public class EventQueue {

	ArrayList<Event> eventQueue = new ArrayList<Event>();

	/**
	 * @return Returns the whole array.
	 */
	public ArrayList<Event> getArray(){
		return eventQueue;
	}
	/**
	 * This method is called from the simulator.
	 * @return Returns the first element in the EventQueue.
	 */
	public Event getFirstEvent(){
		Event temp = eventQueue.get(0);
		eventQueue.remove(0);
		return temp;
	}
	/**
	 * Adds the event to the Queue.
	 * @param event
	 */
	public void addEvent(Event event){
		eventQueue.add(event);
	}
}

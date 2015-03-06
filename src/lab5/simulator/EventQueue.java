package lab5.simulator;
import java.util.ArrayList;

public class EventQueue {

	private 
	
	ArrayList<Event> eventQueue = new ArrayList<Event>();
	
	public Event getFirstEvent(){
		return eventQueue.get(0);
	}
	
	public int numberOfEventsInQueue(){
		return eventQueue.size();
	}
}

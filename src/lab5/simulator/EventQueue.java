package lab5.simulator;
import java.util.ArrayList;

public class EventQueue {

	ArrayList<Event> eventQueue = new ArrayList<Event>();

	public ArrayList<Event> getArray(){
		return eventQueue;
	}
	public Event getFirstEvent(){
		return eventQueue.get(0);
	}
	public int numberOfEventsInQueue(){
		return eventQueue.size();
	}
}

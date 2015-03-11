package lab5.simulator;
import java.util.ArrayList;

public class EventQueue {

	//SortedSequence SSeq;
	
	ArrayList<Event> eventQueue = new ArrayList<Event>();

	public ArrayList<Event> getArray(){
		return eventQueue;
	}
	public Event getFirstEvent(){
		//eventQueue = SSeq.getSortedArray();
		return eventQueue.get(0);
	}
	public int numberOfEventsInQueue(){
		return eventQueue.size();
	}
}

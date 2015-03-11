package lab5.simulator;
import java.util.ArrayList;

public class EventQueue {

	ArrayList<Event> eventQueue = new ArrayList<Event>();

	public ArrayList<Event> getArray(){
		return eventQueue;
	}
	public Event getFirstEvent(){
		Event temp = eventQueue.get(0);
		eventQueue.remove(0);
		return temp;
	}
	public int numberOfEventsInQueue(){
		return eventQueue.size();
	}
	public void addSortedQueueToEventQueue(ArrayList<Event> list){
		eventQueue = list;
	}
	public void addEvent(Event event){
		eventQueue.add(event);
	}
	public String toString(){
		String printObjects="";
		for(int i=0;i<eventQueue.size();i++){
			printObjects += "(" + String.valueOf(eventQueue.get(i).getClass()) + ") ";
		}
		return "Queue: "+ printObjects;
	}
}

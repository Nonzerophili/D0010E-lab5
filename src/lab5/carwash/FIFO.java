package lab5.carwash;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import lab5.simulator.Event;

public class FIFO{

	static ArrayList<Event> carQueue = new ArrayList<Event>();
	
	public static boolean isEmpty(){
		return carQueue.isEmpty();
	}
	public static void add(Event event){
		carQueue.add(event);
	}
	public static void removeFirst() throws NoSuchElementException{
		if(carQueue.size() == 0){
			throw new NoSuchElementException();
		}
		carQueue.remove(0);
	}
	public static Event getFirst() throws NoSuchElementException{
		if(carQueue.size() == 0){
			throw new NoSuchElementException();
		}
		return carQueue.get(0);
	}
	public static int getSize(){
		return carQueue.size();
	}
	public static int maxSize(){
		return CarWashState.maxQueueSize;
	}
}

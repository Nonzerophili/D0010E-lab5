package lab5.carwash;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import lab5.simulator.Event;

/**
 * This class represents the car queue that is used in the case when all of the machines are full and the car that just arrived will have to wait in.
 */
public class FIFO{

	static ArrayList<Event> carQueue = new ArrayList<Event>();

	/**
	 * @return Returns true if the car queue is empty.
	 */
	public static boolean isEmpty(){
		return carQueue.isEmpty();
	}
	
	/**
	 * Appends the event to the back of the queue.
	 * @param event The event that is being added.
	 */
	public static void add(Event event){
		carQueue.add(event);
	}
	
	/**
	 * Removes the first element of the queue. This method can throw NoSuchElementException in the case when the queue is empty.
	 * @throws NoSuchElementException
	 */
	public static void removeFirst() throws NoSuchElementException{
		if(carQueue.size() == 0){
			throw new NoSuchElementException();
		}
		carQueue.remove(0);
	}
	/**
	 * Retrives the first element from the queue.
	 * @return Returns the first element from the queue. The element retrived is of the type Event.
	 * @throws NoSuchElementException
	 */
	public static Event getFirst() throws NoSuchElementException{
		if(carQueue.size() == 0){
			throw new NoSuchElementException();
		}
		return carQueue.get(0);
	}
	/**
	 * @return Returns the size of the queue, (int).
	 */
	public static int getSize(){
		return carQueue.size();
	}
	/**
	 * @return Returns the max size of the queue, (int).
	 */
	public static int maxSize(){
		return CarWashState.maxQueueSize;
	}
}

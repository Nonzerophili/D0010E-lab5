package lab5.carwash;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class FIFO{
	
	private static int maxSize;

	ArrayList<Car> carQueue = new ArrayList<Car>();
	
	public boolean isEmpty(){
		return carQueue.isEmpty();
	}
	public void add(Car car){
		carQueue.add(car);
	}
	public void removeFirst() throws NoSuchElementException{
		if(carQueue.size() == 0){
			throw new NoSuchElementException();
		}
		carQueue.remove(0);
	}
	public Car getFirst() throws NoSuchElementException{
		if(carQueue.size() == 0){
			throw new NoSuchElementException();
		}
		return carQueue.get(0);
	}
	public int getSize(){
		return carQueue.size();
	}
	public int maxSize(){
		return maxSize;
	}
}

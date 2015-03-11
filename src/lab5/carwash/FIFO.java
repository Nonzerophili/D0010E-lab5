package lab5.carwash;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class FIFO{

	static ArrayList<CarWashEvent> carQueue = new ArrayList<CarWashEvent>();
	
	public boolean isEmpty(){
		return carQueue.isEmpty();
	}
	public void add(CarWashEvent carEvent){
		carQueue.add(carEvent);
	}
	public void removeFirst() throws NoSuchElementException{
		if(carQueue.size() == 0){
			throw new NoSuchElementException();
		}
		carQueue.remove(0);
	}
	public CarWashEvent getFirst() throws NoSuchElementException{
		if(carQueue.size() == 0){
			throw new NoSuchElementException();
		}
		return carQueue.get(0);
	}
	public int getSize(){
		return carQueue.size();
	}
	public int maxSize(){
		return CarWashState.maxQueueSize;
	}
}

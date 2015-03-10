package lab5.carwash;
import lab5.simulator.Event;
import lab5.simulator.SimState;
import lab5.simulator.SortedSequence;

public class CarWashEvent extends Event {

	SimState ss;
	private String eventType = "";
	
	public CarWashEvent(String eventType){
		this.eventType = eventType;
	}
	public String getEventType(){
		return eventType;
	}
	
	public void Execute(SortedSequence SortedSequence, SimState SS){
		
		if(this.eventType == "START"){
			time = 0.00;
			SS.setRUNNING(true);
			SS.observable(this);									//Skickar in nuvarande Event till SimState som i sin tur uppdaterar.
			SortedSequence.sortEvents(new CarWashEvent("ARRIVE"));	//Skapar ett nytt ARRIVE-Event medans ett ARRIVE-Event körs.
		}
		if(this.eventType == "STOP"){
			time = 15.00;
			SS.setRUNNING(false);
									//Måste ändra kötiden
			SS.observable(this);
		}
		if(this.eventType == "ARRIVE"){
			
			SortedSequence.sortEvents(new CarWashEvent("ARRIVE"));
			Car newCar = CarFactory.newCar();
			
			if(CarWashState.fastAvailable()){
				CarWashState.availableFastMachines--;
				newCar.previousMachine = "fast";
				
			}else if(CarWashState.slowAvailable()){
				CarWashState.availableSlowMachines--;
				newCar.previousMachine = "slow";
				
			}else if(FIFO.getSize()<FIFO.maxSize()){
				FIFO.add(newCar);
				
			}else{
				CarWashState.rejectedCars++;
			}
		}
		if(this.eventType == "LEAVE"){
			
			
			
		}
	}
	public double getTime(){
		return time;
	}
}
package lab5.carwash;
import lab5.simulator.Event;
import lab5.simulator.SimState;
import lab5.simulator.SortedSequence;

/**
 * Leave is a class which represents a type of event that will occur when a car leaves a carwash machine.
 */
public class Leave extends Event{

	CarWashState CWS;
	public Car car;
	
	/**
	 * Class constructor which connects the arrive event with the leave event.
	 * The constructor is called in the arrive event's execute and creates a leave event with a copy of the arrives time.
	 * 
	 * @param SS The state when the arrive is executed.
	 * @param car The car that is connected to the arrive event.
	 * @param time The time when the Arrive event occurs.
	 * @param washTime The wash time for the Arrive event.
	 */
	public Leave(SimState SS, Car car, double time, double washTime){
		this.car = car;
		this.time = time + washTime;
		CWS = (CarWashState) SS;
	}
	/**
	 * This method is called by the simulator when the event is in the first place of the EventQueue.
	 * Depending on which machine the event came from the corresponding machine number is increased.
	 * When a leave event leaves a machine the next event will be the event which is in the first place of the FIFO queue.
	 * @param SSeq Used for accessing the sortEvent method that adds the event to the EventQueue.
	 * @param SS Used for updating the CWS state.
	 */
	public void Execute(SortedSequence SSeq, SimState SS) {
		CWS = (CarWashState) SS;
		
		CarWashState.currentEvent = "LEAVE";
		CWS.updateTotalQueueTime(this);

		if(car.previousMachine().equals("Fast")){
			CarWashState.availableFastMachines++;
			if(FIFO.isEmpty() == false){
				Leave firstInLine = (Leave) FIFO.getFirst();
				FIFO.removeFirst();
				
				firstInLine.time = this.time + CWS.getFastWashTime();
				firstInLine.car.previousMachine = "Fast";
				CarWashState.availableFastMachines--;
				SSeq.sortEvents(firstInLine);
				CWS.observable(this);
			}
		}
		if(car.previousMachine().equals("Slow")){
			CarWashState.availableSlowMachines++;
			if(FIFO.isEmpty() == false){
				Leave firstInLine = (Leave) FIFO.getFirst();
				FIFO.removeFirst();
				
				firstInLine.time = this.time + CWS.getSlowWashTime();
				firstInLine.car.previousMachine = "Slow";
				CarWashState.availableSlowMachines--;
				SSeq.sortEvents(firstInLine);
				CWS.observable(this);
			}
		}
		
	}
}

package lab5.carwash;

import lab5.simulator.Event;
import lab5.simulator.SimState;
import lab5.simulator.SortedSequence;

/**
 *  Arrive is a class which represents a type of event that will occur when a car arrives to the simulation.
 */
public class Arrive extends Event{
	
	public Car car;
	CarWashState CWS;
	private double washTime;
	
	/**
	 * Class constructor that binds a car to itself.
	 * @param SSeq SortedSequence parameter.
	 * @param SS State passed to the Arrive in order to change the carWashState.
	 */
	public Arrive(SortedSequence SSeq,SimState SS){
		CWS = (CarWashState) SS;
		this.car = CarFactory.newCar();
		time = CWS.newEventTime();
	}
	
	/**
	 * This method is called by the simulator when the event is in the first place of the EventQueue.
	 * The Arrive event enters a machine or the FIFO queue, depending on the state of the machines and the FIFO queue.
	 * @param SSeq Used for accessing the sortEvent method that adds the event to the EventQueue.
	 * @param SS Used for updating the CWS state.
	 */
	public void Execute(SortedSequence SSeq, SimState SS){

		CarWashState.currentEvent = "ARRIVE";
		SSeq.sortEvents(new Arrive(SSeq,SS));
		CWS.updateTotalQueueTime(this);
		
		if(CarWashState.fastAvailable()){
			car.previousMachine = "Fast";
			washTime = CWS.getFastWashTime();								//Beräkna washTime för detta Arrive-Objekt (FAST Machine)
			SSeq.sortEvents(new Leave(CWS,car,time,washTime)); //Skapar ett nytt leave objekt som får all ARRIVE info.
			CWS.updateTotalIdleTime(this);
			CWS.observable(this);
			CarWashState.availableFastMachines--;
			
		}else if(CarWashState.slowAvailable()){
			car.previousMachine = "Slow";
			washTime = CWS.getSlowWashTime();	//Beräkna washTime för detta Arrive-Objekt (SLOW Machine)
			SSeq.sortEvents(new Leave(CWS,car,time,washTime));
			CWS.updateTotalIdleTime(this);
			CWS.observable(this);
			CarWashState.availableSlowMachines--;
			
		}else if((CarWashState.fastAvailable() == false && CarWashState.slowAvailable() == false) && FIFO.carQueue.size()<FIFO.maxSize()){	//Om FIFO:n inte är full
			car.previousMachine = "FIFO";
			CWS.observable(this);
			FIFO.add(new Leave(CWS,car,time,washTime));
		
		}else{
			CWS.observable(this);
			CarWashState.rejectedCars++;
		}
	}
}
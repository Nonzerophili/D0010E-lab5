package lab5.carwash;

import lab5.simulator.Event;
import lab5.simulator.SimState;
import lab5.simulator.SortedSequence;

public class Arrive extends Event{

	public Car car;
	CarWashState CWS;
	private double washTime;
	
	public Arrive(SortedSequence SSeq,SimState SS){
		CWS = (CarWashState) SS;
		this.car = CarFactory.newCar();
		time = CWS.newEventTime();
	}
	
public void Execute(SortedSequence SSeq, SimState SS){

			CarWashState.currentEvent = "ARRIVE";
			SSeq.sortEvents(new Arrive(SSeq,SS));
			CWS.updateTotalQueueTime(this);
			
			if(CarWashState.fastAvailable()){
				CarWashState.availableFastMachines--;
				car.previousMachine = "Fast";
				washTime = CWS.getFastWashTime();								//Beräkna washTime för detta Arrive-Objekt (FAST Machine)
				SSeq.sortEvents(new Leave(CWS,car,time,washTime)); //Skapar ett nytt leave objekt som får all ARRIVE info.
				CWS.updateTotalIdleTime(this);
				CWS.observable(this);
				
			}else if(CarWashState.slowAvailable()){
				CarWashState.availableSlowMachines--;
				car.previousMachine = "Slow";
				washTime = CWS.getSlowWashTime();	//Beräkna washTime för detta Arrive-Objekt (SLOW Machine)
				SSeq.sortEvents(new Leave(CWS,car,time,washTime));
				CWS.updateTotalIdleTime(this);
				CWS.observable(this);
				
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
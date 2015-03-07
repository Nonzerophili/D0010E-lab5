package lab5.carwash;
import lab5.simulator.Event;
import lab5.simulator.SimState;

public class CarWashEvent extends Event {

	SimState ss;
	
	/**
	 * 0 Start
	 * 1 Stop
	 * 2 Arrive
	 * 3 Leave
	 */
	private int eventStatus = 0;
	
	
	public void Execute(SimState SS){
		
		if(eventStatus == 0){	//START
			SS.setRUNNING(true);
		}
		if(eventStatus == 1){	//STOP
			SS.setRUNNING(false);
		}
		if(eventStatus == 2){	//ARRIVE
			
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
		if(eventStatus == 3){	//LEAVE
			
			
		}
	}
}
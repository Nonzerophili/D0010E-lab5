package lab5.carwash;
import lab5.simulator.Event;
import lab5.simulator.EventQueue;
import lab5.simulator.SimState;

public class CarWashEvent extends Event{

	SimState ss;
	
	/**
	 * 0 Start
	 * 1 Stop
	 * 2 Arrive
	 * 3 Leave
	 */
	private int eventStatus = 0;	
	
	public void Execute(SimState SS){
		
		if(eventStatus == 0){
			SS.setRUNNING(true);
		}
		if(eventStatus == 1){
			SS.setRUNNING(false);
		}
		if(eventStatus == 2){
			
			if(){
				
			}
			if(FIFO.isEmpty()){
				
			}
			
			
		}
		if(eventStatus == 3){
	
		}
	}
}
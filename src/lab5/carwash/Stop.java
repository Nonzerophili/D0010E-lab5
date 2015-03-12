package lab5.carwash;
import lab5.simulator.Event;
import lab5.simulator.SimState;
import lab5.simulator.SortedSequence;

/**
 * Stop event that stop the simulation when it reaches the index zero of the queue.
 */
public class Stop extends Event{

	public Stop(){
		time = 15.00;
	}

	/**
	 * This method is called when the simulation reaches the end of the Simulator timer.
	 */
	public void Execute(SortedSequence SSeq, SimState SS){
		CarWashState.currentEvent = "STOP";
		SS.setRUNNING(false);
		CarWashState CWS = (CarWashState) SS;
		CWS.updateTotalQueueTime(this);
		CWS.observable(this);
	}
}

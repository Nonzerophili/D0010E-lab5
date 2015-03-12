package lab5.carwash;

import lab5.simulator.Event;
import lab5.simulator.SimState;
import lab5.simulator.SortedSequence;

/**
 * This class represents a Start event that starts the simulation.
 */
public class Start extends Event{

	public Start(SimState SS){
		time = 0.00;
	}

	/**
	 * Starts the simulation and creates the next Arrive event. 
	 */
	public void Execute(SortedSequence SSeq, SimState SS){
		CarWashState.currentEvent = "START";
		SS.setRUNNING(true);
		SSeq.sortEvents(new Arrive(SSeq,SS));
		SS.observable(this);
	}
}

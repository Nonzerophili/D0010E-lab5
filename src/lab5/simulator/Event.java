package lab5.simulator;

/**
 * Abstract class that is extended by each each event.
 */
public abstract class Event {
	
	public double time;
		
	public abstract void Execute(SortedSequence SortedSequence, SimState SS);
}

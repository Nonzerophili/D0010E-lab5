package lab5.simulator;

public abstract class Event {
	
	protected double time; 	//Exponential
		
	public abstract String getEventType();
	public abstract void Execute(SortedSequence SortedSequence, SimState SS);
}

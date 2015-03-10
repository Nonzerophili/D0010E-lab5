package lab5.simulator;

public abstract class Event {
	
	public double time;
		
	public abstract String getEventType();
	public abstract void Execute(SortedSequence SortedSequence, SimState SS);
}

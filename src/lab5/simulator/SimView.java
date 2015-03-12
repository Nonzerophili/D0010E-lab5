package lab5.simulator;
import java.util.Observer;

/**
 * This is a abstract class that each view can extend in order to keep track of the SimState.
 */
public abstract class SimView implements Observer{
	protected SimState SS;
	
	public SimView(SimState SS){
		this.SS = SS;
	}
	
	public abstract void initialPrint();
	public abstract void endPrint();
}

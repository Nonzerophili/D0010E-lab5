package lab5.simulator;
import java.util.Observer;

public abstract class SimView implements Observer{
	protected SimState SS;
	
	public SimView(SimState SS){
		this.SS = SS;
	}
	
	public abstract void initialPrint();
	public abstract void endPrint();
	
}

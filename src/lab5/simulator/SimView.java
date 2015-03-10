package lab5.simulator;
import java.util.Observable;
import java.util.Observer;

public abstract class SimView extends Observable implements Observer{

	public abstract void initialPrint();
	public abstract void endPrint();
	
}

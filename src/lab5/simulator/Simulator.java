package lab5.simulator;
import lab5.simulator.EventQueue;

/**
 * The simulator is responsible for calling each event's execute method.
 */
public class Simulator{
	private SortedSequence SSeq;
	private EventQueue EQ;
	private SimState SS;
	private SimView SV;
	
	public Simulator(SortedSequence SSeq, SimState SS, SimView SV, EventQueue EQ){
		this.SSeq = SSeq;
		this.SS = SS;
		this.EQ = EQ;
		this.SV = SV;
	}
	
	/**
	 * run() is called from the Main method. As long as the SimState RUNNING variable is set to true 
	 * this method will keep go through the EventQueue and call each events execute.
	 */
	public void run(){
		SV.initialPrint();
		while(SS.isRunning() == true){
			Event currentEvent = EQ.getFirstEvent();
			currentEvent.Execute(SSeq,SS);
		}
		SV.endPrint();
	}
}

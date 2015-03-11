package lab5.simulator;
import lab5.simulator.EventQueue;

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
	
	public void run(){
		
		SV.initialPrint();
		while(SS.isRunning() == true){
			Event currentEvent = EQ.getFirstEvent();
			currentEvent.Execute(SSeq,SS);
		}
		SV.endPrint();
	}
}

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
		//System.out.println("lsjhdol");
		SV.initialPrint();
		while(SS.isRunning() == true){
			//System.out.println("Simulator loops");
			Event currentEvent = EQ.getFirstEvent();
			//System.out.println(currentEvent.getEventType());
			//System.out.println(EQ.toString());
			
			//System.out.println(EQ.eventQueue);
			currentEvent.Execute(SSeq,SS);
			//System.out.println("currentEvent executed");
			
		}
		SV.endPrint();
	}
}

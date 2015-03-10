package lab5.simulator;
import lab5.simulator.EventQueue;
import lab5.carwash.CarWashEvent;
import lab5.carwash.CarWashState;
import lab5.carwash.CarWashView;

public class Simulator{
	private SortedSequence SSeq;
	private EventQueue EQ;
	private SimState SS;
	private SimView SV;
	
	public <E>Simulator(SortedSequence SSeq, E SS, SimView SV, EventQueue EQ){
		this.SSeq = SSeq;
		this.SS = (SimState)SS;
		this.EQ = EQ;
		this.SV = SV;
	}
	
	public void run(){
		
		SV.initialPrint();
		while(SS.isRunning() == true){
			if(EQ.numberOfEventsInQueue() != 0){
				Event currentEvent = EQ.getFirstEvent();
				if(currentEvent.getEventType() == "STOP"){
					break;
				}
				currentEvent.Execute(SSeq,SS);
			}
			
		}
		SV.endPrint();
	}
}

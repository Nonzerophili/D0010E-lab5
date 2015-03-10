package lab5.simulator;
import lab5.simulator.EventQueue;
import lab5.carwash.CarWashEvent;
import lab5.carwash.CarWashState;
import lab5.carwash.CarWashView;

public class Simulator{
	
	private static boolean RUNNING;
	private EventQueue EQ;
	private SimState SS;
	private SimView SV;
	
	/**
	 * @param EQ
	 * @param CWS
	 * @param CWV
	 */
	public Simulator(SortedSequence SSeq, CarWashState CWS, CarWashView CWV){
		
		CWV.initialPrint();
		
		while(RUNNING){
			if(EQ.numberOfEventsInQueue() != 0){
				Event currentEvent = EQ.getFirstEvent();
				if(currentEvent.getEventType() == "STOP"){
					break;
				}
				currentEvent.Execute(SSeq,SS);
			}
			
		}
		CWV.endPrint();
	}
}

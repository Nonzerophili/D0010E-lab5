package lab5.carwash;
import lab5.simulator.Event;
import lab5.simulator.SimState;
import lab5.simulator.SortedSequence;

public class Stop extends Event{

	//private double time;
	
	public Stop(){
		time = 15.00;
	}

	public void Execute(SortedSequence SSeq, SimState SS) {
		CarWashState.currentEvent = "STOP";
		//System.out.println(SS.isRunning()+"INNAN");
		SS.setRUNNING(false);
		//System.out.println(SS.isRunning()+"EFTER");
		CarWashState CWS = (CarWashState) SS;
		CWS.updateTotalQueueTime(this);
		CWS.observable(this);
	}
	
}

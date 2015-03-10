package lab5;
import lab5.simulator.EventQueue;
import lab5.simulator.SimState;
import lab5.simulator.SimView;
import lab5.simulator.SortedSequence;
import lab5.carwash.CarWashEvent;
import lab5.carwash.CarWashState;
import lab5.carwash.CarWashView;
import lab5.simulator.Simulator;

public class MainSim {
	
	public static void main(String[] args) {
		
		
		/*Observer,Leave,Print CarID,Simulator,Main
		  */
		
		SortedSequence SSeq = new SortedSequence();
		EventQueue EQ = new EventQueue();
		CarWashState CWS = new CarWashState();
		CarWashView CWV = new CarWashView();
		SimState SS = new SimState();
		CWV.initialPrint();
		CWV.endPrint();
		/*SS.addObserver(CWV);
		
		EQ.addEvent(new CarWashEvent("STOP"));
		EQ.addEvent(new CarWashEvent("START"));
		Simulator s = new Simulator(SSeq,CWS,CWV,EQ);
		s.run();*/
	}
}

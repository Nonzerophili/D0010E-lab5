package lab5;
import lab5.simulator.EventQueue;
import lab5.simulator.SimState;
import lab5.simulator.SortedSequence;
import lab5.carwash.CarWashState;
import lab5.carwash.CarWashView;
import lab5.carwash.Start;
import lab5.carwash.Stop;
import lab5.simulator.Simulator;

public class MainSim{
	
	public static void main(String[] args) {
		
		/*Observer,Print CarID,Simulator,Main
		  */
		
		EventQueue EQ = new EventQueue();
		SortedSequence SSeq = new SortedSequence(EQ);
		CarWashState CWS = new CarWashState();

		SimState SS = new SimState();
		CarWashView CWV = new CarWashView(SS);
		
		CWS.addObserver(CWV);
		SSeq.sortEvents(new Stop());
		SSeq.sortEvents(new Start(CWS));
		/*SSeq.sortEvents(new CarWashEvent("STOP",CWS,true));
		SSeq.sortEvents(new CarWashEvent("START",CWS));*/
		Simulator s = new Simulator(SSeq,CWS,CWV,EQ);
		s.run();
	}
}

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
	
	/**
	 * @author Henrik Johansson, Jacob Permansson, Johan Kannel
	 * 2015-03-12
	 * 
	 * This program creates a simulator and simulates a carwash.
	 * The simulator is kept separate from the carwash so that it can be used by other applications.
	 * 
	 * This method start the program. It first creates objects for each class that the simulator need.
	 * The observer is added and some initial events are created.
	 * The simulator receives the objects as parameters.
	 *  
	 */
	
	public static void main(String[] args) {
		
		EventQueue EQ = new EventQueue();
		SortedSequence SSeq = new SortedSequence(EQ);
		CarWashState CWS = new CarWashState();

		SimState SS = new SimState();
		CarWashView CWV = new CarWashView(SS);
		
		CWS.addObserver(CWV);
		SSeq.sortEvents(new Stop());
		SSeq.sortEvents(new Start(CWS));
		Simulator s = new Simulator(SSeq,CWS,CWV,EQ);
		s.run();
	}
}

package lab5;
import lab5.simulator.EventQueue;
import lab5.simulator.SortedSequence;
import lab5.carwash.CarWashState;
import lab5.carwash.CarWashView;
import lab5.simulator.Simulator;

public class MainSim {
	
	public static void main(String[] args) {
		SortedSequence SSeq = new SortedSequence();
		CarWashState CWS = new CarWashState();
		CarWashView CWV = new CarWashView();
		CWS.addObserver(CWV);
		
		
		new Simulator(SSeq,CWS,CWV);
	}
}

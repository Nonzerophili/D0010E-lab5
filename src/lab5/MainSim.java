package lab5;
import lab5.simulator.EventQueue;
import lab5.carwash.CarWashState;
import lab5.carwash.CarWashView;
import lab5.simulator.Simulator;

public class MainSim {

	
	
	public static void main(String[] args) {
		EventQueue EQ = new EventQueue();
		CarWashState CWS = new CarWashState();
		CarWashView CWV = new CarWashView();
		
		//CWV.addObserver(CWV);
		new Simulator(EQ,CWS,CWV);
		
		
		CWV.initialPrint();
	}
}

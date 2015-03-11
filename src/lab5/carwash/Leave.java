package lab5.carwash;
import lab5.simulator.Event;
import lab5.simulator.SimState;
import lab5.simulator.SortedSequence;

public class Leave extends Event{

	CarWashState CWS;
	public Car car;
	
	public Leave(SimState SS, Car car, double time, double washTime){
		this.car = car;
		this.time = time + washTime;
		CWS = (CarWashState) SS;
	}
	
	public void Execute(SortedSequence SSeq, SimState SS) {
		CWS = (CarWashState) SS;
		//System.out.println("LEAVE EXECUTE");
		//Om leave inte �r i fast eller slow. S� m�ste den v�nta p� att dess arrive ska ske. Som i sin tur �ndrar p� previousmachine till antingen fast eller slow.
		
		CarWashState.currentEvent = "LEAVE";
		CWS.updateTotalQueueTime(this);

		if(car.previousMachine().equals("Fast")){
			CarWashState.availableFastMachines++;
			if(FIFO.isEmpty() == false){	//Vi (Endast d�r vi kan plocka ifr�n)prioriterar bilar som �r i FIFOn
				Leave firstInLine = (Leave) FIFO.getFirst();
				
				//System.out.println("HEJSAN DEJSAN");
				//System.out.println("FIRSTINLINE DERP HERP"+firstInLine);
				
				FIFO.removeFirst();	//Index 0?
				firstInLine.time = this.time + CWS.getFastWashTime();	//Detta Leave event var i en Fast maskin tidigare. P� s� s�tt vet vi att en fast �r tom. (R�knar ut en fast wash time)
				firstInLine.car.previousMachine = "Fast";
				CarWashState.availableFastMachines--;
				SSeq.sortEvents(firstInLine);
				CWS.observable(this);
			}
		}
		if(car.previousMachine().equals("Slow")){
			//System.out.println("GHIDGHUDHSGJIOJGOIDHDIUSGH");
			CarWashState.availableSlowMachines++;
			if(FIFO.isEmpty() == false){	//Vi prioriterar bilar som �r i FIFOn
				Leave firstInLine = (Leave) FIFO.getFirst();
				FIFO.removeFirst();
				firstInLine.time = this.time + CWS.getSlowWashTime();	//Detta Leave event var i en Fast maskin tidigare. P� s� s�tt vet vi att en fast �r tom. (R�knar ut en fast wash time)
				firstInLine.car.previousMachine = "Slow";
				CarWashState.availableSlowMachines--;
				SSeq.sortEvents(firstInLine);
				CWS.observable(this);
			}
		}
		
	}
}

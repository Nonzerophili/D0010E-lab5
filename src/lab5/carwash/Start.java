package lab5.carwash;

import lab5.simulator.Event;
import lab5.simulator.SimState;
import lab5.simulator.SortedSequence;

public class Start extends Event{

	public Start(SimState SS){							//START
		time = 0.00;
	}

	public void Execute(SortedSequence SSeq, SimState SS){
		CarWashState.currentEvent = "START";
		SS.setRUNNING(true);
		SSeq.sortEvents(new Arrive(SSeq,SS));			//Skapar ett nytt ARRIVE-Event medans ett ARRIVE-Event körs.
		SS.observable(this); // kanske					//Skickar in nuvarande Event till SimState som i sin tur uppdaterar.
	}
}

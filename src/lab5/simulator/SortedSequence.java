package lab5.simulator;

import java.util.ArrayList;

public class SortedSequence {
	
	EventQueue EQ;
	
	public ArrayList<Event> sortEvents(Event event){
		System.out.print("herp");
		System.out.print(EQ.getArray());
		System.out.print("derp");
		ArrayList<Event> sortedEventQueue = EQ.getArray();
		for(int i = 0;i<EQ.getArray().size();i++){
			if((event.time) < EQ.getArray().get(i).time){
				sortedEventQueue.add(i,event);			//Kan gå utanför Arrayen.
				return sortedEventQueue;
			}else if(i == EQ.getArray().size()-1){		//Ifall i = sista index.
				sortedEventQueue.add(event);
				return sortedEventQueue;
			}
		}
		return sortedEventQueue;	//Add Exception
	}
}

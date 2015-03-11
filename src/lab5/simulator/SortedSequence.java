package lab5.simulator;

import java.util.ArrayList;

public class SortedSequence {
	
	EventQueue EQ;
	
	ArrayList<Event> sortedEventQueue = new ArrayList<Event>();
	
	public void/*ArrayList<Event>*/sortEvents(Event event){

		if(sortedEventQueue.size() == 0){
			//EQ.eventQueue.add(event);
			sortedEventQueue.add(event);
		}else{
			for(int i = 0;i<sortedEventQueue.size();i++){
				if((event.time) < sortedEventQueue.get(i).time){
					//System.out.println("derp");
					EQ.eventQueue.add(i, event);
					//sortedEventQueue.add(i,event);			//Kan gå utanför Arrayen.
					//return sortedEventQueue;
				}else if(i == sortedEventQueue.size()-1){		//Ifall i = sista index.
					//EQ.eventQueue.add(event);
					//System.out.println("clerk");
					sortedEventQueue.add(event);
					//return sortedEventQueue;
				}
				//System.out.println("ded");
			}
		}
		//return sortedEventQueue;	//Add Exception
	}
	public ArrayList<Event> getSortedArray(){
		return sortedEventQueue;
	}
}

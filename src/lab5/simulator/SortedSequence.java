package lab5.simulator;

/**
 * This class receives the events and sorts them by their time.
 * The event with the earliest time will be places on index zero.
 */
public class SortedSequence{
	
	EventQueue EQ;
	
	public SortedSequence(EventQueue EQ){
		this.EQ = EQ;
	}
	
	/**
	 * Sorts the event by its time.
	 * @param event
	 */
	public void sortEvents(Event event){
		if(EQ.getArray().size() == 0){
			EQ.getArray().add(event);
		}else{
			for(int i = 0;i < EQ.getArray().size();i++){
				
				if((event.time) < EQ.getArray().get(i).time){
					EQ.getArray().add(i,event);
					break;
				}
				else if(i == EQ.getArray().size()-1){	
					EQ.getArray().add(event);
					break;
				}
			}
		}
	}
}

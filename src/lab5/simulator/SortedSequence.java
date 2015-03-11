package lab5.simulator;

public class SortedSequence{
	
	EventQueue EQ;
	
	public SortedSequence(EventQueue EQ){
		this.EQ = EQ;
	}
	
	public void sortEvents(Event event){
		//System.out.println("SORTED EVENT!");
		if(EQ.getArray().size() == 0){
			EQ.getArray().add(event);
		}else{
			for(int i = 0;i < EQ.getArray().size();i++){
				
				if((event.time) < EQ.getArray().get(i).time){
					EQ.getArray().add(i,event);				//Kan gå utanför Arrayen.
					break;
				}
				else if(i == EQ.getArray().size()-1){		//Ifall i = sista index.
					EQ.getArray().add(event);
					break;
				}
			}
		}
	}
}

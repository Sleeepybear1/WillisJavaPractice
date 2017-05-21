


public class ArrayList {
	Node head;
	int size;
	
	public ArrayList(){
		this.size=0;
	}
	
	public void addValue(int data, int index){
		if (head == null){
			head = new Node(data,index);
			this.size++;
			return;
					/* If there is no head the new node becomes the head */
		}
		;
		if (head.next == null){
			if(head.getIndex()== index){
				head = new Node(data,index);
				return;
			}
			if (head.getIndex() > index){
				this.prepend(data, index);
				return;
				// make another method to prepend indices since that's easier lolz.
			}else{
				head.next = new Node(data,index);
				this.size++;
				return;
			}
		}
		Node current = head;
		
		while(current.next != null){
			if(current.next.getIndex() == index){
				Node temp = current.next.next;
				current.next = new Node(data, index);
				current.next.next = temp;
				return;
			}else if(current.next.getIndex() > index){
				//do insert
				Node temp = current.next;
				current.next = new Node(data,index);
				current.next.next = temp;
				this.size++;
				return;
				//I think there's a mistake here where I'm deleting the current value when I shouldn't be. 
				//The fix is probably to look 2 nodes ahead and assign the temporary node to current.next.next
			}else{
				current = current.next;
			}
			
		}
		if (current.next == null){
			current.next = new Node(data,index);
		}
		
	}
		
	public void prepend(int data, int index){
		Node newHead = new Node(data,index);
		newHead.next = head;
		head = newHead;
		this.size++;
	}
		
	
	
	public void removeAtIndex(int index){
		//remove the value at a particular index. First check that it's a valid index. Then break the link on either side and the rebuild links or something like that?
		if (head == null){
		    return;
		    }
		    if (head.index == index){
		        head = head.next;
		        this.size--;
		    }
		    if(head.next.index == index){
		    	head.next = head.next.next;
		    	this.size--;
		    	return;
		    }
		Node current = head;
		while(current.next != null){
			if(current.next.index == index){
    			current.next = current.next.next;
    			this.size--;
    			return;    
			}
			current = current.next;
			
			/* Find the location to perform the insert at */
		}
				
	}
	
	public boolean hasValue(int value){
		if (head == null){
		    return false;
		}
		Node current = head;
		
		if (current.data == value){
		    return true;
		}
		if (current.next.data == value){
			return true;
		}
		while (current.next.next != null){
		    
		    
		    if (current.next.data == value){
		        return true;
	        }else{
		        current = current.next;
		    }
			//ititerate through the list. Return true if the value at the node ever matches the input value
		}
		return false;
	}
	
	public void removeValue(int value){
	    if (head == null){
	        return;
	    }
	    if (head.data == value){
	        head = head.next;
	        this.size--;
	    }
	    Node current = head;
	    while (current.next != null){
	        if(current.next.data == value){
	            current.next = current.next.next;
	            this.size--;
	            return;
	        }
	        current = current.next;
	    }
		
	}
	
	
	
	public int getSize(){
		return this.size;
	}
	public static void main(String[] args) {
		//  Auto-generated method stub
    System.out.println("If this prints the code compiles!");
    ArrayList trial = new ArrayList();
    System.out.println(trial.getSize());
    trial.addValue(25, 20);
    System.out.println(trial.getSize());
    trial.addValue(10, 1);
    trial.addValue(10, 1);
    System.out.println(trial.getSize());

    trial.addValue(10, 1);
    System.out.println(trial.getSize());

    trial.addValue(11, 1);
    System.out.println(trial.getSize());

    trial.addValue(9,20);
    trial.addValue(2, 5);
    
    System.out.println(trial.hasValue(10));
    System.out.println(trial.getSize());
	}
	

}

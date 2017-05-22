
/* Public class ArrayList
 * 
 * written by Gehn 
 * 
 * Makes an array with the underlying structure of a linked list.
 * 
 * Methods:
 * 
 * addValue(data,index): Adds a node
 * 
 * removeAtIndex(index): Removes value at index.
 * 
 * removeValue(value): Removes first instance of the input value from array
 * 
 * hasValue(value): boolean. Checks if array has value or not
 * 
 * getSize(): Returns number of elements in array
 * 
 * */

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
		if (current.index > index){
			this.prepend(data,index);
			return;
		}
		if (current.next.index == index) {
			Node temp = current.next;
			current = new Node(data, index);
			current.next = temp;
			return;
		}
		
		while(current.next != null){
			if(current.getIndex()==index){
				Node temp = current.next;
				current = new Node(data, index);
				current.next = temp;
				return;
			}
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
		        System.out.println("Removed at Index:" + index);
		    }
		    if(head.next.index == index){
		    	head.next = head.next.next;
		    	this.size--;
		    	System.out.println("Removed at Index:" + index);
		    	return;
		    }
		Node current = head;
		while(current.next != null){
			if(current.next.index == index){
    			current.next = current.next.next;
    			this.size--;
    			System.out.println("Removed at Index:" + index);
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
	        System.out.println("Removed value of: " + value + "!");
	        return;
	    }
	    Node current = head;
	    while (current.next != null){
	        if(current.next.data == value){
	            current.next = current.next.next;
	            this.size--;
	            System.out.println("Removed Value of: " +value + "!");
	            return;
	        }
	        current = current.next;
	    }
		
	}
	
	
	
	public int getSize(){
		return this.size;
	}
	
	public void printList(){
		Node current = head;
		if (current == null){
			System.out.println("Empty Array");
			return;
		}
		if (head.next == null){
			System.out.println(current.data + " , " + current.index);
			System.out.println("Current size is:" + this.getSize());
			return;
		}
		while (current != null){
			System.out.println(current.data + " , " + current.index);
			current = current.next;
		}
		System.out.println("Current size is:" + this.getSize());
		return;
	}
	public static void main(String[] args) {
		//  Auto-generated method stub
    System.out.println("If this prints the code compiles!");
    ArrayList trial = new ArrayList();
    trial.printList();
    trial.addValue(2, 120);
    trial.printList();
    trial.addValue(10, 11);
    System.out.println(trial.hasValue(10));
    trial.printList();
    trial.addValue(10, 2);
    trial.printList();

    trial.addValue(10, 1);
    trial.printList();

    trial.addValue(11, 4);
    trial.printList();

    trial.addValue(9,3);
    trial.addValue(2, 5);
    
    System.out.println(trial.hasValue(10));
    if (trial.hasValue(10)){
    	trial.removeValue(10);
    }
    trial.printList();
    trial.removeAtIndex(5);
    trial.printList();
    trial.addValue(7642, 2);
    trial.printList();
    trial.addValue(50, 4);
    trial.printList();
    trial.addValue(15, 1);
    trial.printList();
	}
	

}

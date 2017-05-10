public class Node{
	Node next;
	int data;
	int index;
	
	public Node(int data, int index){
		this.data = data;
		this.index = index;
	}
	
	public int getIndex(){
		return this.index;
	}
	
}

import java.util.Scanner;
import java.util.HashMap;

public class PrintNum {
	
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		HashMap<Integer, String> values = new HashMap<Integer, String>();
		boolean loop = true;
		while(loop){
			System.out.println("Enter another number. Enter anything else if you're ready to print your numbers");
			while (kb.hasNextInt()){
				
				int nextInt = kb.nextInt();
				if( !values.containsKey(nextInt)){
					values.put(nextInt, "");
				}
				
			loop = false;	
			}
				loop = false;
				System.out.println(values.keySet());
				
				
			}
			
		}	
	}
	



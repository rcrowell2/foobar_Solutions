package foobar;

/**
 
  @author rcrowell
  
Commander Lambda uses an automated algorithm to assign minions randomly to tasks, in order to keep her minions on their toes. But you've noticed a flaw in the algorithm - it eventually loops back on itself, so that instead of assigning new minions as it iterates, it gets stuck in a cycle of values so that the same minions end up doing the same tasks over and over again. You think proving this to Commander Lambda will help you make a case for your next promotion. 

You have worked out that the algorithm has the following process: 

1) Start with a random minion ID n, which is a nonnegative integer of length k in base b
2) Define x and y as integers of length k.  x has the digits of n in descending order, and y has the digits of n in ascending order
3) Define z = x - y.  Add leading zeros to z to maintain length k if necessary
4) Assign n = z to get the next minion ID, and go back to step 2

For example, given minion ID n = 1211, k = 4, b = 10, then x = 2111, y = 1112 and z = 2111 - 1112 = 0999. Then the next minion ID will be n = 0999 and the algorithm iterates again: x = 9990, y = 0999 and z = 9990 - 0999 = 8991, and so on.

Depending on the values of n, k (derived from n), and b, at some point the algorithm reaches a cycle, such as by reaching a constant value. For example, starting with n = 210022, k = 6, b = 3, the algorithm will reach the cycle of values [210111, 122221, 102212] and it will stay in this cycle no matter how many times it continues iterating. Starting with n = 1211, the routine will reach the integer 6174, and since 7641 - 1467 is 6174, it will stay as that value no matter how many times it iterates.

Given a minion ID as a string n representing a nonnegative integer of length k in base b, where 2 <= k <= 9 and 2 <= b <= 10, write a function answer(n, b) which returns the length of the ending cycle of the algorithm above starting with n. For instance, in the example above, answer(210022, 3) would return 3, since iterating on 102212 would return to 210111 when done in base 3. If the algorithm reaches a constant, such as 0, then the length is 1.
 
 
 1) Start with a random minion ID n, which is a nonnegative integer of length k in base b
2) Define x and y as integers of length k.  x has the digits of n in descending order, and y has the digits of n in ascending order
3) Define z = x - y.  Add leading zeros to z to maintain length k if necessary
4) Assign n = z to get the next minion ID, and go back to step 2
 
 
 */
/*
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class answer {
	static ArrayList<Integer> ans = new ArrayList<Integer>();

	public static int answer(String n, int b) {
		while (true) {
			//add the current value to an array list
			ans.add(Integer.parseInt(n));
			
			//figures out k value
			int k = n.length();

			String stringX = sortAsc(n);
			String stringY = sortDes(n);
			
			// subtracting using the given base
			int x = Integer.parseInt(stringX, b);
			int y = Integer.parseInt(stringY, b);
			String z = Integer.toString(x - y, b);
			
			//checks the case that the answer is zero to return 1
			if (Integer.parseInt(z) == 0) {
				return 1;
			}
			//goes through the array list ans to check if a pattern is happening
			for(int i = 0; i < ans.size(); i++){
				//if checking the arraylist for a repeating number
				if(Integer.parseInt(z) == ans.get(i)){
					//returns the size of the list minus the index at which it finds 
					//the duplicate answer
					return ans.size() - i;
					
				}
			}
			//resets the algorithm to loop through itself
			n = z;
		}
	}

	//sorts the given string, n,into ascending numerical order
	public static String sortAsc(String n) {
		String ans = "";
		Integer[] numbs = new Integer[n.length()];
		for (int i = 1; i <= n.length(); i++) {
			numbs[i - 1] = Integer.parseInt(n.substring(i - 1, i));
		}
		Arrays.sort(numbs, Collections.reverseOrder());
		for (int a : numbs) {
			ans = ans + Integer.toString(a);
		}
		return ans;
	}

	//sorts the given string, n,into descending numerical order
	public static String sortDes(String n) {
		String ans = "";
		Integer[] numbs = new Integer[n.length()];
		for (int i = 0; i < n.length(); i++) {
			numbs[i] = Integer.parseInt(n.substring(i, i + 1));
		}
		Arrays.sort(numbs);
		for (int a : numbs) {
			ans = ans + Integer.toString(a);
		}
		return ans;
	}
}
*/
	//checks itself using both of the given test cases
//	public static void main(String[] a){
	//	System.out.println(answer("1211",10)); //answer = 1
		//System.out.println(answer("210022",3)); //answer = 3
	//}
//}
public class Answer {   
    public static int[] answer(int[] l, int t) { 
        int sum = 0;
        for(int i: l){ // gets some of the list
            sum += i;
        }
        System.out.println(sum);
        if (sum == t){ // checks to see if the ans is the whole list
        	int[] ans = {0,l.length};
            return ans;
        }else if (sum < t){ // checks to see if ans is even possible
        	int[] ans = {-1,-1};
            return ans;
        }
        
        int temp = 0;
        for(int i = 0; i < l.length; i++){
            temp = l[i];
            System.out.println("This is temp for loop 1: " + temp);
            for(int j = i + 1; j< l.length; j++){ //loops through the list adding to see if it works
                temp += l[j];
                System.out.println("This is temp for second loop: " + temp);
                if (temp == t){
                	int[] ans = {i,j};
                    return ans;
                }else if(temp > t){ 
                    temp = temp - l[j]; //if temp > t it removes the first value and loops through the first loop
                    break;
                }
                
            }
        }
        int[] ans = {-1,-1};
        return ans;
    } 

public static void main(String[] a){
	int[] l = {4,3,10,2,8};
	int t = 12;
	System.out.println(answer(l,t));
}
}


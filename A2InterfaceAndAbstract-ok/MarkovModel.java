
/**
 * Write a description of MarkovModel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.Random;
import java.util.*;
import edu.duke.*;
import java.io.*;

public class MarkovModel extends AbstractMarkovModel{

	private int N;
	//n is the number of characters to use to predict the next character
	public MarkovModel(int n) {
	        //myRandom = new Random();
	        N = n;
	}
	
	public void setTraining(String s){
	        myText = s.trim();
	}
	
	//four places to change from MarkovOne to MarkovTwo, key = key.substring(1) + next;
	//three places to change from 2 t 3 or to n
	public String getRandomText(int numChars){
	        if (myText == null){
		    return "";
		}
		StringBuilder sb = new StringBuilder();
		//generate the first key
		int index = myRandom.nextInt(myText.length()-N);
		String key = myText.substring(index, index+N);
		sb.append(key);
		//generate following letters
		for(int k=0; k < numChars-N; k++){
		        ArrayList<String> follows = getFollows(key);
		        if(follows.size() == 0) {
		            break;
		        }
		        index = myRandom.nextInt(follows.size());
		        String next = follows.get(index);
		        sb.append(next);
		        key = key.substring(1) + next;
		}    
		return sb.toString();
	}
	
	public String toString() {
	    return "MarkovModel of order "+N+".";
	}
}

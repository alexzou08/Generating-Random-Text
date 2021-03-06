
/**
 * Write a description of MarkovOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.Random;
import java.util.*;
import edu.duke.*;
import java.io.*;

public class MarkovOne extends AbstractMarkovModel{
	
	public void setTraining(String s){
	        myText = s.trim();
	}
	
	public String getRandomText(int numChars){
	        if (myText == null){
		    return "";
		}
		StringBuilder sb = new StringBuilder();
		//generate the first letter
		int index = myRandom.nextInt(myText.length()-1);
		String key = myText.substring(index, index+1);
		sb.append(key);
		//generate following letters
		for(int k=0; k < numChars-1; k++){
		        ArrayList<String> follows = getFollows(key);
		        if(follows.size() == 0) {
		            break;
		        }
		        index = myRandom.nextInt(follows.size());
		        String next = follows.get(index);
		        sb.append(next);
		        key = next;
		}    
		return sb.toString();
	}
	
	public String toString() {
	    return "MarkovModel of order 1.";
	}
}

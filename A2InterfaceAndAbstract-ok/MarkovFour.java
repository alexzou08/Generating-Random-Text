
/**
 * Write a description of MarkovFour here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.Random;
import java.util.*;
import edu.duke.*;
import java.io.*;

public class MarkovFour extends AbstractMarkovModel{

	
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
		int index = myRandom.nextInt(myText.length()-4);
		String key = myText.substring(index, index+4);
		sb.append(key);
		//generate following letters
		for(int k=0; k < numChars-4; k++){
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
	    return "MarkovModel of order 4.";
	}
}

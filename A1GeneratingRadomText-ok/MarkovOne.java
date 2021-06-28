
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

public class MarkovOne {
        private String myText;
	private Random myRandom;
	
	public MarkovOne() {
	        myRandom = new Random();
	}
	
	public void setRandom(int seed){
	        myRandom = new Random(seed);
	}
	
	public void setTraining(String s){
	        myText = s.trim();
	}
	
	//find the character (as string) followed by a string "key" in the training text 
	//and put them all in an ArrayList
	public ArrayList<String> getFollows(String key) {
	        ArrayList<String> follows = new ArrayList<String>();
	        int lengthOfKey = key.length();
	        for(int i=0; i < myText.length()-lengthOfKey; i++) {
	            if(key.equals(myText.substring(i,i+lengthOfKey))){
	                follows.add(myText.substring(i+lengthOfKey,i+lengthOfKey+1));
	            }
	        }
	        return follows;
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
}


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

public class MarkovModel {
        private String myText;
	private Random myRandom;
	private int N;
	//n is the number of characters to use to predict the next character
	public MarkovModel(int n) {
	        myRandom = new Random();
	        N = n;
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
}

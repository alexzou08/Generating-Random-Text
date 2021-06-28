
/**
 * Abstract class AbstractMarkovModel - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    protected int seed;
    
    public AbstractMarkovModel() {
        myRandom = new Random();
    }
    
    public void setRandom(int seed){
	myRandom = new Random(seed);
    }
    
    public void setTraining(String s) {
        myText = s.trim();
    }
    
    abstract public String getRandomText(int numChars);
    
    //find the character (as string) followed by a string "key" in the training text 
    //and put them all in an ArrayList
    
    protected ArrayList<String> getFollows(String key) {
        ArrayList<String> follows = new ArrayList<String>();
	int lengthOfKey = key.length();
	for(int i=0; i < myText.length()-lengthOfKey; i++) {
	    if(key.equals(myText.substring(i,i+lengthOfKey))){
	        follows.add(myText.substring(i+lengthOfKey,i+lengthOfKey+1));
	    }
	}
	return follows;  
    }
    
   
}

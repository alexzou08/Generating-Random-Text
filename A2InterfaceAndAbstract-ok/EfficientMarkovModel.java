
/**
 * Write a description of EfficientMarkovModel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Random;
import java.util.*;
import edu.duke.*;
import java.io.*;

public class EfficientMarkovModel extends AbstractMarkovModel{
    private int N;
    private HashMap<String, ArrayList<String>> map;
    
    public EfficientMarkovModel(int number) {
        myRandom = new Random();
        N = number;
        map = new HashMap<String,ArrayList<String>>();
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s) {
        myText = s.trim();
        buildMap();
    }
    
    public void buildMap() {
        for(int i = 0; i < myText.length()-N; i++) {
            String newKey = myText.substring(i,i+N);
            if(!map.containsKey(newKey)) {
                ArrayList<String> list = getFollows(newKey);
                map.put(newKey,list);
            }
        }
    }
    
    /* This did not work out, don't know why
    public ArrayList<String> getFollows(String key) {
        ArrayList<String> follows = new ArrayList<String>();
        follows = map.get(key);
        return follows;
    }
    */
    public void printHashMapInfo() {
        buildMap();
        System.out.println("Keys in the hashmap: " + (map.size() + 1));
        int index = 0;
        String maxkey = "";
        for(String s: map.keySet()) {
            if(map.get(s).size() > index) {
                index = map.get(s).size();
                maxkey = s;
            }
            System.out.println(s + " " + map.get(s));
        }
        System.out.println("max num of keys = " + index);
        System.out.println("the key is this = " + maxkey);
    }
    
    public String getRandomText(int numChars){
        if(myText == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        //generate the first key
	int index = myRandom.nextInt(myText.length()-N);
	String key = myText.substring(index, index+N);
	sb.append(key);
	//generate following letters
	for(int k=0; k < numChars - N; k++){
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
	    return "This is EfficientMarkovModel of order "+ N +".";
    }
}

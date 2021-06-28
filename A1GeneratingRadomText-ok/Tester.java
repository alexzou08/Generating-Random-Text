
/**
 * Write a description of Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.Random;
import java.util.*;
import edu.duke.*;
import java.io.*;

public class Tester {
    
    public void testGetFollowsWithFile() {
        FileResource fr = new FileResource();
	String st = fr.asString();
	st = st.replace('\n', ' ');
	MarkovTwo m1 = new MarkovTwo();
	m1.setTraining(st);
	ArrayList<String> follows = m1.getFollows("o");
	System.out.println(follows.size());
    }

}

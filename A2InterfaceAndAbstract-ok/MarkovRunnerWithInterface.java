
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*;
import java.util.Random;
import java.util.*;
import edu.duke.*;
import java.io.*;

public class MarkovRunnerWithInterface {
    
    public void runModel(IMarkovModel markov, String text, int size, int seed) {
        markov.setTraining(text);
        markov.setRandom(seed); 
        System.out.println("running with " + markov);
        for(int k=0; k < 3; k++){
            String st= markov.getRandomText(size);
            printOut(st);
        }
    }
    
    public void runMarkov() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        int size = 200;
        int seed = 100; 
        MarkovZero mz = new MarkovZero();
        runModel(mz, st, size, seed);
    
        MarkovOne mOne = new MarkovOne();
        runModel(mOne, st, size, seed);
        
        MarkovModel mThree = new MarkovModel(3);
        runModel(mThree, st, size, seed);
        
        MarkovFour mFour = new MarkovFour();
        runModel(mFour, st, size, seed);

    }
    
    public void testHashMap() {
        //FileResource fr = new FileResource();
        //String st = fr.asString();
        String st = "yes-this-is-a-thin-pretty-pink-thistle";
        st = st.replace('\n', ' ');
        int size = 50;
        int seed = 42; 
        EfficientMarkovModel mod = new EfficientMarkovModel(2);
        runModel(mod, st, size, seed);
        mod.printHashMapInfo();
    }
    
    private void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for(int k=0; k < words.length; k++){
            System.out.print(words[k]+ " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println();
                psize = 0;
            }
        }
        System.out.println("\n----------------------------------");
    }
    
    //below is not yet completed. You can calculate the time each takes by using 
    //System.nanoTime() for the current time.
    public void compareMethods() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        int size = 200;
        int seed = 100; 
        MarkovModel mThree = new MarkovModel(2);
        runModel(mThree, st, size, seed);
        EfficientMarkovModel mod = new EfficientMarkovModel(2);
        runModel(mod, st, size, seed);
    }
}

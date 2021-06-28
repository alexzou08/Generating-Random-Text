
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*;

public class MarkovRunner {
    
    public void runMarkovZero() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovZero markov = new MarkovZero();
        //fix the random number leave () blank to true random
        markov.setRandom(1024);
        markov.setTraining(st);
        for(int k=0; k < 3; k++){
            String text = markov.getRandomText(500);
            printOut(text);
        }
    }
    
    public void runMarkovOne() {
	FileResource fr = new FileResource();
	String st = fr.asString();
	st = st.replace('\n', ' ');
	MarkovOne markov = new MarkovOne();
	//fix the random number leave () blank to true random
	markov.setRandom(365);
	markov.setTraining(st);
	for(int k=0; k < 3; k++){
		String text = markov.getRandomText(500);
		printOut(text);
	}
    }
    
    public void runMarkovTwo() {
	FileResource fr = new FileResource();
	String st = fr.asString();
	st = st.replace('\n', ' ');
	MarkovTwo markov = new MarkovTwo();
	//fix the random number leave () blank to true random
	//markov.setRandom(101);
	markov.setTraining(st);
	for(int k=0; k < 3; k++){
		String text = markov.getRandomText(500);
		printOut(text);
	}
    }
    
    public void runMarkovFour() {
	FileResource fr = new FileResource();
	String st = fr.asString();
	st = st.replace('\n', ' ');
	MarkovFour markov = new MarkovFour();
	//fix the random number leave () blank to true random
	markov.setRandom(715);
	markov.setTraining(st);
	for(int k=0; k < 3; k++){
		String text = markov.getRandomText(500);
		printOut(text);
	}
    }
    
    public void runMarkovModel() {
	FileResource fr = new FileResource();
	String st = fr.asString();
	st = st.replace('\n', ' ');
	MarkovModel markov = new MarkovModel(8);
	//fix the random number leave () blank to true random
	markov.setRandom(365);
	markov.setTraining(st);
	for(int k=0; k < 3; k++){
		String text = markov.getRandomText(500);
		printOut(text);
	}
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
    
}

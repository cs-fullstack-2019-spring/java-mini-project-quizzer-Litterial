import java.lang.reflect.Array;
import java.util.Random;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
public class Main {

    public static final Random gen = new Random(); //grabs a random number
    public static void printRandomQuestions(int n, int maxRange, ArrayList<String> List) {
        assert n <= maxRange : "cannot get more unique numbers than the size of the range";
        int score=0; //keeps track of how many points the user has
        String S1,userinput,name; // S1 grabs the question from the ArrayList List, name grabs user input for the person playing
        String[] askquestion; //ask question is used to split S1 by a delimiter to differientiate the questions from the answers
        ArrayList<String> rando=new ArrayList<String>();  // holds the questions in a random order
        Set<Integer> used = new HashSet<Integer>(); // keeps track of the used indices from List
        Scanner reader=new Scanner(System.in);
        System.out.println("Enter your name");
        name=reader.next();

        for (int i = 0; i < n; i++) {

            int newRandom;
            do {
                newRandom = gen.nextInt(maxRange+1); // gets a number from 0 to max range (inclusive)
                System.out.println(newRandom);
            } while (used.contains(newRandom)); //runs loop until it finds an unused integer
            rando.add(List.get(newRandom)); //appends question to the rando arraylist
//            System.out.println(rando);
            used.add(newRandom); //appends the used number to the set.
        }
//        System.out.println("This is rando"); Test to check the rando arraylist
//        System.out.println(rando);
        for (String i:rando) { //iterates each element in the arraylist
            S1=i; //sets the element to equal 1
            System.out.println(i);
            askquestion=S1.split(",",6); //converts the string into an array based on the "," delimiter
            System.out.println(askquestion[0]+"?"); // ask the question
            //reveals the answer choices
            System.out.println("A "+askquestion[1]);
            System.out.println("B "+askquestion[2]);
            System.out.println("C "+askquestion[3]);
            System.out.println("D "+askquestion[4]);
//            System.out.println(askquestion[5]);
            //ask for for their answer choice, then converts to a different value based on their input
            userinput=reader.next();
            if (userinput.equalsIgnoreCase("A")){userinput="1";}
            else if (userinput.equalsIgnoreCase("B")){userinput="2";}
            else if (userinput.equalsIgnoreCase("C")){userinput="3";}
            else if (userinput.equalsIgnoreCase("D")){userinput="4";}
            else {userinput="9";}

            //if their answer choice is matches the correct answers, they gain 1 point
            if(userinput.equalsIgnoreCase(askquestion[5])){score+=1;}
            System.out.println(score);;
        }
        //returns score after all questions are answered.
        System.out.println(name+ " scored " +((double)score/5)*100+"%");



    }

    public static void main(String[] args) {
        ArrayList<String> question_bank=new ArrayList<String>();
        File myfile =new File("quizzer.txt");
        try {
            Scanner scan = new Scanner(myfile); // scanner will try to read from a text file
            while(scan.hasNextLine())
            {
//                System.out.println(scan.nextLine());
                question_bank.add(scan.nextLine()); // each line of the text file will be added to the arraylist
            }
        }
        catch(FileNotFoundException e)//try catch to see if the file is missing
        {
            e.printStackTrace();
        }

//        for (String i:question_bank) { testing to see if the ArrayList read from the txt file
//            System.out.println(i);
//        };
        System.out.println("\n");
        printRandomQuestions(5,5,question_bank); // runs a functions that accepts questions n+1 questions
        //pulls a set amount of questions (maxRange) from an ArrayList (question_bank)

    }
}

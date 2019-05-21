import java.lang.reflect.Array;
import java.util.Random;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
public class Main {

    public static final Random gen = new Random();
    public static void printRandomQuestions(int n, int maxRange, ArrayList<String> List) {
        assert n <= maxRange : "cannot get more unique numbers than the size of the range";

        ArrayList<String> rando=new ArrayList<String>();
        Set<Integer> used = new HashSet<Integer>();

        for (int i = 0; i < n; i++) {

            int newRandom;
            do {
                newRandom = gen.nextInt(maxRange+1);
            } while (used.contains(newRandom));
            rando.add(List.get(newRandom));
            used.add(newRandom);
        }
        for (String i:rando) {
            System.out.println(i);
        };;
    }

    public static void main(String[] args) {
        ArrayList<String> question_bank=new ArrayList<String>();
        File myfile =new File("quizzer.txt");
        try {
            Scanner scan = new Scanner(myfile);
            while(scan.hasNextLine())
            {
//                System.out.println(scan.nextLine());
                question_bank.add(scan.nextLine());
            }
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }

        for (String i:question_bank) {
            System.out.println(i);
        };
        System.out.println("\n");
        printRandomQuestions(5,6,question_bank);

    }
}

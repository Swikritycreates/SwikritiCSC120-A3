import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Conversation {

    /**
     * sets the final value of random for operating canned responses
     */

    private static final Random random = new Random();
    /**
     * 
     * @param input - takes input of sentences to split it into words, set as outputs for replacement task
     * @return canned responses, if any of the targetted words for replacement are not detected
     */

    private static String response(String input) {
        String[] words = input.split(" ");
        String output = input;
        boolean replaced = false;

        // Canned responses
        
        String[] exceptions = {
            "Mmm-hm.",
            "Interesting.",
            "Tell me more.",
            "Why do you say that?",
            "I see."
        };

        /*
         * 
         */

        for (String word : words) {
            switch(word.toLowerCase()) {
                case "i":
                    //output = output.replace(" I ", " you ").replace(" i ", " you ");
                    output = output.replace("I ", "You ").replace("i ", "you ");
                    replaced = true;
                    break;
                case "me":

                    output = output.replace(" me ", " you ").replace(" Me ", " You ");
                    replaced = true;
                    break;
                case "am":
                    output = output.replace(" am ", " are ").replace(" Am ", " Are ");
                    replaced = true;
                    break;
                case "you":
                    output = output.replace(" you ", " I ").replace(" You ", " I ");
                    replaced = true;
                    break;
                case "my":
                    output = output.replace(" my ", " your ").replace(" My ", " Your ");
                    replaced = true;
                    break;
                case "your":
                    output = output.replace(" your ", " my ").replace(" Your ", " My ");
                    replaced = true;
                    break;
                case "are":
                    output = output.replace(" are ", " am ").replace(" Are ", " Am ");
                    replaced = true;
                    break;
            }
        }

        if (replaced) {
            if (output.endsWith(".")) {
                output = output.substring(0, output.length() - 1) + "?";
            } else if (!output.endsWith("?")) {
                output += "?";
            }
            return output;
        } else {
            return exceptions[random.nextInt(exceptions.length)];
        }
    }
/**
 * takes input for number of rounds
 * prints bot responses
 * takes in inputs from user responses
 * makes transcript records
 * prints transcripts
 * @param args
 */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of rounds: ");
        int rounds = in.nextInt();
        in.nextLine(); // Take in new line

        System.out.println("Hey, what's on your mind?");
        ArrayList<String> transcript = new ArrayList<>();
        transcript.add("Hey, what's on your mind?");

        // Make a transcript record
        for (int i = 0; i < rounds; i++) {
            String userInput = in.nextLine();
            transcript.add(userInput);
            String botResponse;
            if (i == rounds - 1) {
                botResponse = "See ya!";
            } else {
                botResponse = response(userInput);
            }
            System.out.println(botResponse);
            transcript.add(botResponse);
        }

        System.out.println("\nTranscript:");
        for (String message : transcript) {
            System.out.println(message);
        }
    }
}
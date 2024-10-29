import java.util.ArrayList;
import java.util.Scanner;

public class Case1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String vowel = "aeiou";
        String consonant = "bcdfghjklmnpqrstvwxyz";

        String[] vowelChar = vowel.split("");
        String[] consonantChar = consonant.split("");

        System.out.println("Input one line of words : ");
        String input = scanner.nextLine();
        String[] inputChar = input.toLowerCase().split("");

        ArrayList<String> vowelCharList = new ArrayList<>();
        ArrayList<String> consCharList = new ArrayList<>();

        for (String s : inputChar) {
            for (String vc : vowelChar) {
                if (s.equalsIgnoreCase(vc)) {
                    vowelCharList.add(s);
                    break;
                }
            }
            for (String cc : consonantChar) {
                if (s.equalsIgnoreCase(cc)) {
                    consCharList.add(s);
                    break;
                }
            }
        }

        System.out.println("Vowel Characters : " + String.join("",vowelCharList));
        System.out.println("Consonant Characters : " + String.join("",consCharList));
    }
}
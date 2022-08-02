import java.util.ArrayList;
import java.util.Random;

public class TestPuzzleJava {
    public static void main(String[] args) {

        PuzzleJava generator = new PuzzleJava();

        ArrayList<Integer> randomRolls = generator.getTenRolls();
        System.out.println("------------Random Rolls--------------");
        System.out.println(randomRolls);


        String randomLetter = generator.getRandomLetter();
        System.out.println("------------Random Letter-------------");
        System.out.println(randomLetter);


        String randomPassword = generator.generatePassword();
        System.out.println("-----------Random Password-------------");
        System.out.println(randomPassword);

        ArrayList<String> passwordSet = generator.generatePasswordSet(5);
        System.out.println("-----------Password Set-----------------");
        System.out.println(passwordSet);
    }
}
import java.util.Random;
import java.util.ArrayList;

public class PuzzleJava {

    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> rolls = new ArrayList<Integer>();
        Random randMachine = new Random();
        int temp;
        for(int i = 0; i < 10; i++) {
            temp = (randMachine.nextInt(19) + 1);
            rolls.add(temp);
        }
        return rolls;
    }

    public String getRandomLetter() {
        String[] letterArray = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        Random randMachine = new Random();
        int temp = randMachine.nextInt(26);
        String letter = "a";
        for(int i = 0; i <= temp; i++) {
            if(i == temp) {
                letter = letterArray[temp];
            }
        }
        return letter;

    }

    public String generatePassword() {
        String[] letterArray = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        Random randMachine = new Random();
        int temp = randMachine.nextInt(26);
        String password = letterArray[temp];
        for(int i = 0; i <= 26; i++) {
            temp = randMachine.nextInt(26);
            password += letterArray[temp];
            if(password.length() == 8) {
                break;
            }
        }
        return password;
    }

    public ArrayList<String> generatePasswordSet(int length) {
        ArrayList<String> passwords = new ArrayList<String>();
        for(int i = 0; i < length; i++) {
            passwords.add(generatePassword());
        }
        return passwords;
    }

}
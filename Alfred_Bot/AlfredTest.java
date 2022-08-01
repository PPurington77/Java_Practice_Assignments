public class AlfredTest {

    public static void main(String[] args) {

        AlfredQuotes alfredBot = new AlfredQuotes();

        String testGreeting = alfredBot.basicGreeting();
        String testGuestGreeting = alfredBot.guestGreeting("Patrick");
        String testDateAnnouncement = alfredBot.dateAnnouncement();

        String alexisTest = alfredBot.respondBeforeAlexis("Alexis! Play some lofi beats.");
        String alfredTest = alfredBot.respondBeforeAlexis("I can't find my yo-yo. Maybe Alfred will know where it is.");
        String winningTest = alfredBot.respondBeforeAlexis("I lost to the joker, I thought I couldn't be beat");
        String doesNotExistTest = alfredBot.respondBeforeAlexis("It doesn't exist");
        String testGuestGreetingAgain = alfredBot.guestGreeting("Patrick", "morning");


        System.out.println(testGreeting);
        System.out.println(testGuestGreeting);
        System.out.println(testDateAnnouncement);
        System.out.println(alexisTest);
        System.out.println(alfredTest);
        System.out.println(winningTest);
        System.out.println(doesNotExistTest);
        System.out.println(testGuestGreetingAgain);

    }
}
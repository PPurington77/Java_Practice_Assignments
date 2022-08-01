import java.util.Date;
public class AlfredQuotes {
    public String basicGreeting() {
        
        return "Hello, lovely to see you. How are you?";
    }
    public String guestGreeting(String name) {
        String greetGuest = String.format("Hello %s, I hope you are well.", name);
        return greetGuest;
    }

    public String guestGreeting(String name, String dayPeriod) {
        String greetGuest = String.format("Good %s, %s, lovely to see you!", dayPeriod, name);
        return greetGuest;

    }
    public String dateAnnouncement() {
        Date date = new Date();
        return "Today is " + date;
    }
    public String respondBeforeAlexis(String conversation) {
        int alexis = conversation.indexOf("Alexis"); //if it finds Alexis then it return the index of where it is at in the string...
        //if alexis isn't found in the string it returns -1
        int alfred = conversation.indexOf("Alfred");
        //see above comments for alexis
        int beat = conversation.indexOf("beat");
        if (alexis != -1 ) {
            return ("Right away, sir. She certainly isn't sophisticated enough for that");
        }
        else if (alfred != -1) {
            return ("At your service. As you wish, naturally");
        }
        else if (beat != -1) {
            return("Maybe that's what Batman is about. Not winning. But failing.");
        }
        else {
            return "Right, and with that I shall retire";
            //neither alexis or alfred were found in the string conversation
        }
    }
}
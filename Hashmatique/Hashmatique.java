import java.util.HashMap;

public class Hashmatique {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Candy Shop", "I'll take you to the candy shop");
        map.put("Who", "Who...Mike Jones..");
        map.put("grill", "Let me see your grill");
        map.put("In the club", "You can find me in the club");

        System.out.println(map.get("Candy Shop"));


        for (String key : map.keySet()) {
            System.out.println(String.format("Track: %s \nLyrics: %s", key, map.get(key)));
        }
    }
}
package hackathon;

public class User {
	private String name;
	static int id = 1;
	private int userID;
	
	public User(String name) {
		this.name = name;
		this.userID = id++;
		
	}
	
	public static void incrementID() {
		
	}
}

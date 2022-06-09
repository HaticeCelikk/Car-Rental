public class Admin extends Person {

	private String username;
	private String password;

	public Admin(String name, String surname, String mail, String phone, String city, String username,
			String password) {
		super(name, surname, mail, phone, city);
		this.username = username;
		this.password = password;
	}
 
	public String getUsername() {
		return username;
	}
 
	
	public String getPassword() {
		return password;
	}

	
}
 
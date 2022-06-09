public class Customer extends Person {
	private int Id;
	private String username;
	private String password;
	private int budget;
	private String gender;

	public Customer(int Id, String name, String surname, String mail, String phone, String city, String username,
			String password, int budget) {
		super(name, surname, mail, phone, city);
		this.Id = Id;
		this.username = username;
		this.password = password;
		this.budget = budget;
	}

	public Customer(int id, String name, String surname, String mail, String phone, String city, String username,
			String password, int budget, String gender) {
		super(name, surname, mail, phone, city);
		this.Id = Id;
		this.username = username;
		this.password = password;
		this.budget = budget;
		this.gender = gender;
	}

	public int getId() {
		return Id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	@Override
	public String toString() {
		return Id + ";" + super.getName() + ";" + super.getSurname() + ";" + super.getMail() + ";" + super.getPhone()
				+ ";" + super.getCity() + ";" + username + ";" + password + ";" + budget;
	}

}

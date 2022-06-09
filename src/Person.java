public class Person {
	private String name;
	private String surname;
	private String mail;
	private String phone;
	private String city;

	public Person(String name, String surname, String mail, String phone, String city) {
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.phone = phone;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getMail() {
		return mail;
	}

	public String getPhone() {
		return phone;
	}

	public String getCity() {
		return city;
	}

}

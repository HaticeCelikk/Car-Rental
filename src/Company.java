
import java.util.ArrayList;

public class Company {
	private Admin admin;
	private ArrayList<Customer> customers;
	private ArrayList<CarForRent> carsforrent;
	private ArrayList<CarForSale> carsforsale;
	private static int customerCount = 0;

	public Company() {
		carsforrent = new ArrayList<CarForRent>();
		carsforsale = new ArrayList<CarForSale>();
		customers = new ArrayList<Customer>();
	}

	public Customer getCustomer(int i) {
		return customers.get(i);
	}

	public Customer getLastCustomer() {
		return customers.get(customers.size() - 1);
	}

	public CarForRent getLastCarRent() {
		return carsforrent.get(carsforrent.size() - 1);
	}

	public CarForSale getLastCarSale() {
		return carsforsale.get(carsforsale.size() - 1);
	}

	public ArrayList<Customer> getAllCustomers() {
		return customers;
	}

	public ArrayList<CarForRent> getCarsForRent() {
		return carsforrent;
	}

	public ArrayList<CarForSale> getCarsForSale() {
		return carsforsale;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public void addCarForRent(CarForRent car) {
		carsforrent.add(car);
	}

	public void addCarForSale(CarForSale car) {
		carsforsale.add(car);
	}

	public void addCustomer(Customer customer) {
		customers.add(customer);
		customerCount++;
	}

	public int getCustomerCount() {
		return customerCount;
	}

}

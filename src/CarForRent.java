public class CarForRent extends Car {
	private boolean isAvailable;

	private int pricePerHour;

	public CarForRent(int id, String brand, String model, String color, String year, String engineType,
			String engineSize, boolean isAvailable, int pricePerHour, String image) {
		super(id, brand, model, color, year, engineType, engineSize, image);
		this.isAvailable = isAvailable;
		this.pricePerHour = pricePerHour;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getPricePerHour() {
		return pricePerHour;
	}

	@Override
	public String toString() {
		return super.getId() + ";" + super.getBrand() + ";" + super.getModel() + ";" + super.getColor() + ";"
				+ super.getYear() + ";" + super.getEngineType() + ";" + super.getEngineSize() + ";" + isAvailable + ";"
				+ pricePerHour + ";" + super.getImage();
	}

}
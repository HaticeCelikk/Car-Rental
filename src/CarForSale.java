
public class CarForSale extends Car {
	private String km;
	private boolean isUsed;
	private boolean isSold;
	private int price;

	public CarForSale(int id, String brand, String model, String color, String year, String engineType,
			String engineSize, String km, boolean isUsed, int price, boolean isSold, String image) {
		super(id, brand, model, color, year, engineType, engineSize, image);
		this.km = km;
		this.isUsed = isUsed;
		this.isSold = isSold;
		this.price = price;
	}

	public String getKm() {
		return km;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return super.getId() + ";" + super.getBrand() + ";" + super.getModel() + ";" + super.getColor() + ";"
				+ super.getYear() + ";" + super.getEngineType() + ";" + super.getEngineSize() + ";" + km + ";" + isUsed
				+ ";" + price + ";" + isSold + ";" + super.getImage();
	}

	public boolean isSold() {
		return isSold;
	}

}

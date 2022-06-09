abstract class Car {
	private int id;
	private String brand;
	private String model;
	private String color;
	private String year;
	private String engineType;
	private String engineSize;
	private String image;
	public Car(int id, String brand, String model, String color, String year, String engineType, String engineSize,String image) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.year = year;
		this.engineType = engineType;
		this.engineSize = engineSize;
		this.image=image;
	} 
 
	public int getId() {
		return id;
	}

	

	public String getBrand() {
		return brand;
	}


	public String getModel() {
		return model;
	}

	public String getColor() {
		return color;
	}

	public String getYear() {
		return year;
	}


	public String getEngineType() {
		return engineType;
	}

	public String getEngineSize() {
		return engineSize;
	}


	public String getImage() {
		return image;
	}


	

}

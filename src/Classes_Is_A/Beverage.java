package Classes_Is_A;

public abstract class Beverage {

	protected int beverageID;
	protected String name;
	protected String color;
	protected double volume;
	protected double price;
	protected String taste;
	protected static final int minvol = 10;
	
	public Beverage() {
		
	}
	
	public Beverage(int beverageID, String name, String color, double volume, double price, String taste) {
				
		this.beverageID = beverageID;
		this.name = name;
		this.color = color;
		this.volume = volume;
		this.price = price;
		this.taste = taste;
		
	}
	
	public boolean checkID(int id) {
		
		return this.beverageID == id;
	}
	
	public int getBeverageID() {
		return beverageID;
	}
	public String getName() {
		return name;
	}
	public String getColor() {
		return color;
	}
	public double getVolume() {
		return volume;
	}
	public double getPrice() {
		return price;
	}
	public String getTaste() {
		return taste;
	}
	public void setBeverageID(int beverageID) {
		this.beverageID = beverageID;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setTaste(String taste) {
		this.taste = taste;
	}
	
	public String toString() {
		
		return "\nBeverage id : " + beverageID + "\nName : " + name + "\nColor : " + color + "\nVolume : " + "ml "+ volume +"\nPrice : " + " $" + price  +"\nTaste : " + taste;
	}
}

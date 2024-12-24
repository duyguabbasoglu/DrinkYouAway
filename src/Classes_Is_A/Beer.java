package Classes_Is_A;

import Interface.BeverageInterface;

public class Beer extends Beverage implements BeverageInterface {

	private double alcoholRate;
	private String container;
	private String region;
	private String maltType;
	
	public Beer() {
		
	}
	
	public Beer(int beverageID, String name, String color, double volume, double price, String taste, double alcoholRate, String container, String region, String maltType) {
		super(beverageID,name,color, volume, price, taste);
		this.alcoholRate = alcoholRate;
		this.container = container;
		this.region = region;
		this.maltType = maltType;
		
	}

	public double getAlcoholRate() {
		return alcoholRate;
	}

	public void setAlcoholRate(double alcoholRate) {
		this.alcoholRate = alcoholRate;
	}

	public String getContainer() {
		return container;
	}

	public void setContainer(String container) {
		this.container = container;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getMaltType() {
		return maltType;
	}

	public void setMaltType(String maltType) {
		this.maltType = maltType;
	}
	
	public String toString() {
		
		return("\nBeer\n" + super.toString() +"\nRate of alcohol : " + alcoholRate + "\nContainer : " + container + "\nFrom " + region + "\nMalt type : " + maltType);
	}

	@Override
	public double calcPrice() {
		
		price = 100.50;  
        
        if (alcoholRate > 5.0)
            price += 50.0;
        else if (alcoholRate > 7.5)
            price += 100.0;
        else if (alcoholRate > 10.0)
            price += 150.0;
        
        if (container.equalsIgnoreCase("bottle"))
            price += 20.0;
        else if (container.equalsIgnoreCase("can"))
            price += 10.0;
        
        if (region.equalsIgnoreCase("europe"))
            price += 15.0;
        else if (region.equalsIgnoreCase("america"))
            price += 30.0;
        else if (region.equalsIgnoreCase("australia"))
            price += 25.0;

        if (maltType.equalsIgnoreCase("pale"))
            price += 10.0;
        else if (maltType.equalsIgnoreCase("amber"))
            price += 20.0;
        else if (maltType.equalsIgnoreCase("dark"))
            price += 30.0;
        
        if (Beverage.minvol < volume)
        	price += 15;
        
        return price;
		
	}
}

package Classes_Is_A;

import Interface.BeverageInterface;

public class Wine extends Beverage implements BeverageInterface {
	
	private int yearsExist;
	private boolean isHot;
	private String region;
	private String grapeType;
	
	public Wine() {
		
	}
	
	public Wine(int BeverageID, String name, String color, double volume, double price, String taste, int yearsExist, boolean isHot, String region, String grapeType) {
		super(BeverageID, name, color, volume, price, taste);
		this.yearsExist = yearsExist;
		this.isHot = isHot;
		this.region = region;
		this.grapeType = grapeType;
	}
	
	

	public int getYearsExist() {
		return yearsExist;
	}

	public boolean isHot() {
		return isHot;
	}

	public String getRegion() {
		return region;
	}

	public String getGrapeType() {
		return grapeType;
	}

	public void setYearsExist(int yearsExist) {
		this.yearsExist = yearsExist;
	}

	public void setHot(boolean isHot) {
		this.isHot = isHot;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setGrapeType(String grapeType) {
		this.grapeType = grapeType;
	}

	@Override
	public String toString() {
		return "\nWine\n" + super.toString() + "\nYears Exist : " + yearsExist + "\nIs Hot : " + isHot + "\nRegion : " + region + "\nGrape Type : " + grapeType ;
	}
	
	@Override
    public double calcPrice() {
		
		price = 300.50;
		
		if (yearsExist >= 20)
			price += 100;
		else if (yearsExist >= 50)
			price += 200;
		else if (yearsExist >= 100)
			price += 500;
		
        if (isHot)
        	price += 50.50;
        
        if (region.equalsIgnoreCase("europe"))
        	price += 20;
        
        else if(region.equalsIgnoreCase("Asia"))
        	price += 80.80;
        
        else if(region.equalsIgnoreCase("america"))
        	price = 100.50;
        
        else if(region.equalsIgnoreCase("norse"))
        	price += 150;
        
        else if(region.equalsIgnoreCase("Australia"))
        	price += 10;
        
        

        if (grapeType.equalsIgnoreCase("merlot"))
        	price += 50;
        
        else if(grapeType.equalsIgnoreCase("pinot"))
        	price += 40.80;
        
        else if(grapeType.equalsIgnoreCase("shiraz"))
        	price = 140.50;
        
        else if(grapeType.equalsIgnoreCase("cabernet"))
        	price += 99.50;
        
        if (Beverage.minvol < volume)
    	price += 15;
        
        
        return price;
	}
}

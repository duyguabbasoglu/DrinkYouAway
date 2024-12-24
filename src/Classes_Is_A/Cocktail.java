package Classes_Is_A;

import java.util.*;

import Classes_Has_A.CreateYours;
import Interface.BeverageInterface;
public class Cocktail extends Beverage implements BeverageInterface {

	private double alcoholRate;
	private String container;
	private String alcoholType;
	
	private CreateYours custom = null;
	
	public Cocktail() {
		
	}
	
	public Cocktail(int beverageID, String name, String color, double volume, double price, String taste, double alcoholRate, String container, String alcoholType,CreateYours cy) {
		super(beverageID, name, color, volume, price, taste);
		this.alcoholRate = alcoholRate;
		this.container = container;
		this.alcoholType = alcoholType;
		this.custom=cy;
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

	public String getAlcoholType() {
		return alcoholType;
	}

	public void setAlcoholType(String alcoholType) {
		this.alcoholType = alcoholType;
	}
	
	public String toString() {
		
		return ("\nCocktail\n" + super.toString() +
				"\nAlcohol ratio : " + alcoholRate + 
				"\nContainer type : " + container +
				"\nType of alcohol : " + alcoholType);
	}
	
	public CreateYours createYourCocktail() {
		
		Scanner input = new Scanner(System.in);
		
		// we will use buttons in GUI to create custom cocktails
		// we will make some adjustments on it
		
				String o1, o2, o3, check;
			
			do {
				do {
					System.out.println("\nDo you want to add syrup? ");
					o1 = input.nextLine();
				} while (o1.equalsIgnoreCase("no"));
				
				do {
					System.out.println("\nDo you want to add juice? ");
					o2 = input.nextLine();
				} while (o2.equalsIgnoreCase("no"));
				
				do {
					System.out.println("\nDo you want to add decoration? ");
					o3 = input.nextLine();
				} while (o3.equalsIgnoreCase("no"));
				
				System.out.println("\nDo you want to do any change?");
				check = input.nextLine();
				
			} while (check.equalsIgnoreCase("no"));
		
		custom = new CreateYours(o1, o2, o3);
		
		return custom;
	}
	@Override
	public double calcPrice() {
        price = 150.0;
        
        if (alcoholRate > 10.0)
            price += 50.0;
        else if (alcoholRate > 20.0)
            price += 100.0;
        
        if (container.equalsIgnoreCase("glass"))
            price += 20.0;
        else if (container.equalsIgnoreCase("bottle"))
            price += 40.0;

        if (alcoholType.equalsIgnoreCase("vodka"))
            price += 30.0;
        else if (alcoholType.equalsIgnoreCase("rum"))
            price += 40.0;
        else if (alcoholType.equalsIgnoreCase("whiskey"))
            price += 50.0;
        
        if (Beverage.minvol < volume)
        	price += 15;
            

        return price;
    }
}

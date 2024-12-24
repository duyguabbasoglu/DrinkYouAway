package Main_And_System_Class;
import java.util.*;
import Classes_Is_A.Beverage;
import Classes_Has_A.Order;

public class BeverageSys {
	
	private static ArrayList<Beverage> beverages = new ArrayList<>();
	private static Set<Order> orders = new HashSet<>();
	private static int orderID = 0;
	
	

	public static void setBeverages(ArrayList<Beverage> beverages) {
		BeverageSys.beverages = beverages;
	}

	public static boolean addOrder(int bevid, int quantity) {
		
		
		System.out.println(displayMenu());
			
		System.out.println("\nSTARTING TO ADD ORDER...");
			

		Beverage drink = searchBeverage(bevid);
		
		if(drink == null)
			return false;
		
		Order order = new Order(orderID, quantity, drink);
		
		orderID++;
		
		orders.add(order);
		
		return true;
		
	}
	
	

	public static boolean checkBeverageID(int id) {
		
		for(Beverage drink : beverages) 
			if(drink.checkID(id))
				return true;
			
		return false;
	}
	
	public static Beverage searchBeverage(int id) {
		
		for(Beverage drink : beverages)
			if(drink.getBeverageID()==id)
			{
				return drink;
			}
		return null;
	}
	
	public static String displayReceipt() { //Its old name was calculate
		
		if(orders.isEmpty())
			return "You need to order something !!!";
		
		double gross = 0.0;
		int drinknum = 0;
		String s="";
		
		System.out.println("RECEIPT");
		
		for(Order o : orders) {
			
			System.out.print(o.toString());
			s+=o;
			
			gross += o.calcPrice();
			
			drinknum += o.getQuantity();
			
		}
		
		System.out.printf("\nTOTAL PRICE : $%.2f%n", gross);
		s+="\nTOTAL PRICE : "+gross;
		
		// in further development as an application, we thought that we are able to add the costs of 
		// ingredients with another calcPrice method helps us to see z report, balance sheet and profit
		
		double avg = gross / drinknum; 
		
		System.out.printf("Average Price : $%.2f%n", avg);
		s+="Average Price : "+avg;
		return s;
	}
	
	
	// our code is open to further developments like having enough efficiency 
	// to add ingredient stocks and deductions
	public static Order searchOrder(int id) {
		
		for(Order order : orders)
			if(order.getOrderID() == id)
				return order;
		
		return null;
	}
	
	public static boolean removeOrder(int id) {
		
		Order order = searchOrder(id);
		
		if (order == null)
			return false;
		
		orders.remove(order);
		return true;
	}
	
	public static String getOrder(int id) { //Will be used in the GUI in the next steps
		
		Order order = searchOrder(id);
		
		return order.toString();
	}
	
	public static String displayMenu() {
		
		String str = "\nMENU";
		
		for(Beverage drink : beverages)
			str += drink.toString();
		
		return str;
		
	}

public static String displayBy(String select) {
    	
    	StringBuilder out = new StringBuilder();
    	
        switch (select) { 
            case "beverageID":
            	beverages.sort((b1, b2) -> Integer.valueOf(b1.getBeverageID()).compareTo(b2.getBeverageID()));
                out.append("Sorted by BeverageID:\n");
                break;
                
            case "name":
            	 beverages.sort((b1, b2) -> b1.getName().compareTo(b2.getName()));
                 out.append("Sorted by Name:\n");
                 break;
                 
            case "color":
            	beverages.sort((b1, b2) -> b1.getColor().compareTo(b2.getColor()));
                out.append("Sorted by Color:\n");
                break;
                
            case "volume":
            	beverages.sort((b1, b2) -> Double.compare(b1.getVolume(), b2.getVolume()));
                out.append("Sorted by Volume:\n");
                break;

            case "price":
            	beverages.sort((b1, b2) -> Double.compare(b1.getPrice(), b2.getPrice()));
                out.append("Sorted by Price:\n");
                break;
                
            case "taste":
            	beverages.sort((b1, b2) -> b1.getTaste().compareTo(b2.getTaste()));
                out.append("Sorted by Taste:\n");
                break;
        }
        
        for (Beverage beverage : beverages)
        	out.append(beverage).append("\n");
        
        return out.toString();
    }

    public static String displayBeverages() {
    	String s="";
        System.out.println("Beverages: ");
        for (Beverage beverage : beverages) {
            System.out.println(beverage); 
            s+=beverage;
        }
        return s;
    }
    
    public static void addMenu(Beverage beverage){
        beverages.add(beverage);
    }
	
}

package Classes_Has_A;

import Classes_Is_A.Beverage;

public class Order {

	private int orderID;
	private int quantity;
	private Beverage drink;
	
	public Beverage getDrink() {
		return drink;
	}

	public void setDrink(Beverage drink) {
		this.drink = drink;
	}

	public Order() {
		
		this.orderID = 0;
		this.quantity = 0;
	}
	
	public Order(int orderID, int quantity, Beverage drink) {
		this.orderID = orderID;
		this.quantity = quantity;
		this.drink = drink;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "\nOrder\nOrder ID : " + orderID + "\nQuantity : " + quantity + "\nDrink info : " + drink.toString();
	}
    
	public double calcPrice() {
    	
    	if(drink == null)
    		return 0.0;
    	
    	else
    		return (quantity * drink.getPrice());
    }
}

package Classes_Has_A;

public class CreateYours {

	private String juice;
    private String syrup;
    private String decoration;
    private double price;

    
    public CreateYours() {
        this.juice = "";
        this.syrup = "";
        this.decoration = "";
        this.price = 0.0;
    }

    
    public CreateYours(String juice, String syrup, String decoration) {
        this.juice = juice;
        this.syrup = syrup;
        this.decoration = decoration;
        this.price = calcPrice();
    }

    
    public String getJuice() {
        return juice;
    }

    public void setJuice(String juice) {
        this.juice = juice;
        this.price = calcPrice();
    }

    public String getSyrup() {
        return syrup;
    }

    public void setSyrup(String syrup) {
        this.syrup = syrup;
        this.price = calcPrice();
    }

    public String getDecoration() {
        return decoration;
    }

    public void setDecoration(String decoration) {
        this.decoration = decoration;
        this.price = calcPrice();
    }

    public double getPrice() {
        return price;
    }

    
    public double calcPrice() {
        price = 300.0;  

        if (juice.equalsIgnoreCase("orange"))
            price += 10.0;
        else if (juice.equalsIgnoreCase("apple"))
            price += 15.0;
        else if (juice.equalsIgnoreCase("grape"))
            price += 20.0;

        if (syrup.equalsIgnoreCase("chocolate"))
            price += 10.0;
        else if (syrup.equalsIgnoreCase("vanilla"))
            price += 15.0;
        else if (syrup.equalsIgnoreCase("caramel"))
            price += 20.0;

        if (decoration.equalsIgnoreCase("umbrella"))
            price += 5.0;
        else if (decoration.equalsIgnoreCase("lemon slice"))
            price += 3.0;

        return price;
    }

    
    @Override
    public String toString() {
        return "CreateYours [juice=" + juice + ", syrup=" + syrup + ", decoration=" + decoration + ", price=" + price + "]";
    }
}

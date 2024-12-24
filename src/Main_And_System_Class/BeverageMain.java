package Main_And_System_Class;
import Classes_Has_A.CreateYours;
import Classes_Is_A.*;
import GUI.MainFrame;

public class BeverageMain {


    public static void main(String[] args) {
    	
    	CreateYours cy1 = new CreateYours("Orange", "Chocolate", "Umbrella");
        CreateYours cy2 = new CreateYours("Apple", "Vanilla", "Lemon Slice");
        CreateYours cy3 = new CreateYours("Grape", "Caramel", "");
        
        
    Beverage wine1 = new Wine(1, "Chardonnay", "Yellow", 750, 20.0, "Fruity", 5, true, "France", "White");
    Beverage beer1 = new Beer(2, "Lager", "Golden", 500, 5.0, "Malty", 4.5, "Can", "Germany", "Barley");
    Beverage cocktail1 = new Cocktail(3, "Margarita", "Light Green", 250, 15.0, "Citrus", 12.5, "Glass", "Tequila", cy1);

    Beverage wine2 = new Wine(4, "Merlot", "Red", 750, 25.0, "Berry", 4, false, "Italy", "Red");
    Beverage beer2 = new Beer(5, "Stout", "Dark", 500, 7.0, "Roasty", 5.0, "Bottle", "Ireland", "Wheat");
    Beverage cocktail2 = new Cocktail(6, "Martini", "Clear", 200, 18.0, "Herbal", 8.0, "Glass", "Gin", cy2);

    Beverage wine3 = new Wine(7, "Pinot", "Red", 750, 18.0, "Dry", 8, true, "Italy", "Red");
    Beverage beer3 = new Beer(8, "IPA", "Amber", 500, 6.0, "Hoppy", 6.0, "Bottle", "USA", "Hops");
    Beverage cocktail3 = new Cocktail(9, "Old Fashioned", "Brown", 200, 12.0, "Smoky", 15.0, "Glass", "Whiskey", cy3);
    
    
    BeverageSys.addMenu(beer1);
    BeverageSys.addMenu(wine1);
    BeverageSys.addMenu(cocktail1);

    BeverageSys.addMenu(beer2);
    BeverageSys.addMenu(wine2);
    BeverageSys.addMenu(cocktail2);

    BeverageSys.addMenu(beer3);
    BeverageSys.addMenu(wine3);
    BeverageSys.addMenu(cocktail3);
    
    
    MainFrame main =new MainFrame();
    main.setVisible(true);
        
        
    }
}
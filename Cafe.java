/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements{

    // Attributes
    private int nCoffeeOunces;
    private int nSugarPackets; 
    private int nCreams;
    private int nCups; 

    /**
     * The constructor for cafe with given information that intialize the confidition for a cafe.
     * 
     * @param name the name of the coffee shop
     * @param address the address of the coffee shop
     * @param nFloors the number of floors of the coffee shop
     * @param nCoffeeOunces the number of ounces coffee in stock
     * @param nSugarPackets the number of packages of sugar in stock
     * @param nCreams the number of splashes of cream in the stock
     * @param nCups the number of cups in the stock
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        System.out.println("You have built a cafe: ☕");
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }


    /**
     * This sellCoffee method that updates the information of the stock in the coffee shop after selling cups of coffee
     * 
     * @param size size of coffee in ounces
     * @param nSugarPackets the number of sugar packets used for the coffee
     * @param nCreams the number of splashes of cream for the coffee
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if (size <= this.nCoffeeOunces && nSugarPackets <= this.nSugarPackets && nCreams <= this.nCreams && this.nCups > 0){
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
        }

    }

    /**
     * Restock the inventory when being called (only allowed to be called privately)
     * 
     * @param nCoffeeOunces amount of coffee in ounces to be restocked
     * @param nSugarPackets number of sugar packets to be restocked
     * @param nCreams amount of creams to be restocked
     * @param nCups number of cups to be restocked
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }
    
    /**
     * The main method to show the functionality of the methods. 
     */
    public static void main(String[] args) {
        Cafe myCafe = new Cafe("Compass Cafe", "10 Neilson Drive", 3, 100, 50, 40, 150);
        myCafe.sellCoffee(2, 3, 3);
        myCafe.restock(300, 300, 300, 300);
    }
    
}

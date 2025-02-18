abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    public abstract double calculateTotalPrice();
    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price per item: " + price);
        System.out.println("Quantity: " + quantity);
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
class VegItem extends FoodItem {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }
}
class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }
    public double calculateTotalPrice() {
        return getPrice() * getQuantity() + 5; 
    }
    public void applyDiscount() {
        System.out.println("Applying 10% discount on non-veg item.");
    }
    public void getDiscountDetails() {
        System.out.println("Discount: 10% on non-veg items.");
    }
}
interface Discountable {
    void applyDiscount();
    void getDiscountDetails();
}
public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        FoodItem item1 = new VegItem("Veg Pizza", 200, 2);
        FoodItem item2 = new NonVegItem("Chicken Roll", 150, 3);
        FoodItem[] foodItems = { item1, item2 };
        double totalPrice = 0;
        for (FoodItem item : foodItems) {
            item.getItemDetails();
            double price = item.calculateTotalPrice();
            totalPrice += price;
            System.out.println("Total Price: " + price);
            if (item instanceof Discountable) {
                Discountable discountableItem = (Discountable) item;
                discountableItem.applyDiscount();
                discountableItem.getDiscountDetails();
            }
            System.out.println();
        }
        System.out.println("Total Order Price: " + totalPrice);
    }
}

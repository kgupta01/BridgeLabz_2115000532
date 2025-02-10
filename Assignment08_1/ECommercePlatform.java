abstract class Product {
    private int productId;
    private String name;
    private double price;
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
    public abstract double calculateDiscount();
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }
    public double calculateDiscount() {
        return getPrice() * 0.10; 
    }
    public double calculateTax() {
        return getPrice() * 0.15; 
    }
    public void getTaxDetails() {
        System.out.println("Electronics tax is: " + calculateTax());
    }
}
class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }
    public double calculateDiscount() {
        return getPrice() * 0.20; 
    }
    public double calculateTax() {
        return getPrice() * 0.08; 
    }
    public void getTaxDetails() {
        System.out.println("Clothing tax is: " + calculateTax());
    }
}
class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }
    public double calculateDiscount() {
        return getPrice() * 0.05; 
    }
}
interface Taxable {
    double calculateTax();
    void getTaxDetails();
}
public class ECommercePlatform {
    public static void main(String[] args) {
        Product p1 = new Electronics(1, "Laptop", 1000);
        Product p2 = new Clothing(2, "T-shirt", 50);
        Product p3 = new Groceries(3, "Apple", 10);
        Product[] products = { p1, p2, p3 };
        for (Product product : products) {
            double discount = product.calculateDiscount();
            double tax = 0;
            if (product instanceof Taxable) {
                Taxable taxableProduct = (Taxable) product;
                tax = taxableProduct.calculateTax();
                taxableProduct.getTaxDetails();
            }
            double finalPrice = product.getPrice() + tax - discount;
            System.out.println("Final price of " + product.getName() + " is: " + finalPrice);
        }
    }
}

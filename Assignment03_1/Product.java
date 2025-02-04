public class Product {
    static double discount = 10.0;
    final int productID;
    String productName;
    double price;
    int quantity;
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }
    public Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }
    public void displayProductDetails() {
        System.out.println("Product ID: " + productID);
        System.out.println("Product Name: " + productName);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Discount: " + discount + "%");
    }
    public static void main(String[] args) {
        Product product1 = new Product(101, "Laptop", 999.99, 5);
        System.out.println(product1 instanceof Product);
	product1.displayProductDetails();
        updateDiscount(15.0);
	product1.displayProductDetails();
    }
}


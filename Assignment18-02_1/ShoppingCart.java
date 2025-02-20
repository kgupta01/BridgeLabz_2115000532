import java.util.*;
public class ShoppingCart {
    private Map<String, Double> priceMap = new HashMap<>();
    private Map<String, Double> orderedCart = new LinkedHashMap<>();
    private Map<String, Double> sortedCart = new TreeMap<>(Comparator.comparingDouble(priceMap::get));
    public void addProduct(String product, double price) {
        priceMap.put(product, price);
        orderedCart.put(product, price);
        sortedCart.put(product, price);
    }
    public Map<String, Double> getCartInOrder() {
        return new LinkedHashMap<>(orderedCart);
    }
    public Map<String, Double> getCartSortedByPrice() {
        return new LinkedHashMap<>(sortedCart);
    }
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Apple", 1.5);
        cart.addProduct("Banana", 0.8);
        cart.addProduct("Orange", 1.2);   
        System.out.println("Cart in order: " + cart.getCartInOrder());
        System.out.println("Cart sorted by price: " + cart.getCartSortedByPrice());
    }
}

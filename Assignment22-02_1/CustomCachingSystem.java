import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;
@Retention(RetentionPolicy.RUNTIME)
@interface CacheResult {
}
class ExpensiveService {
    private static final Map<Integer, Integer> cache = new HashMap<>();
    @CacheResult
    public int computeSquare(int number) {
        if (cache.containsKey(number)) {
            System.out.println("Returning cached result for: " + number);
            return cache.get(number);
        }
        System.out.println("Computing square for: " + number);
        int result = number * number;
        cache.put(number, result);
        return result;
    }
}
public class CustomCachingSystem {
    public static void main(String[] args) throws Exception {
        ExpensiveService service = new ExpensiveService();
        System.out.println(service.computeSquare(5)); 
        System.out.println(service.computeSquare(5)); 
        System.out.println(service.computeSquare(10));
        System.out.println(service.computeSquare(10));
    }
}

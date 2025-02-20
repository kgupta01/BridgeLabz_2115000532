import java.util.*;
public class RotateList {
    public static <T> void rotateList(List<T> list, int positions) {
        int n = list.size();
        positions = positions % n;
        Collections.rotate(list, -positions);
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(10, 20, 30, 40, 50));
        rotateList(list, 2);
        System.out.println(list);
    }
}



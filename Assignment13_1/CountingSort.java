import java.util.*;
public class CountingSort {
    public static void countingSort(int[] ages) {
        int[] count = new int[19];
        for (int age : ages) count[age]++;
        int index = 0;
        for (int i = 10; i <= 18; i++) {
            while (count[i] > 0) {
                ages[index++] = i;
                count[i]--;
            }
        }
    }
    public static void main(String[] args) {
        int[] ages = {12, 15, 14, 10, 18, 17, 13, 16, 14, 12};
        countingSort(ages);
        System.out.println(Arrays.toString(ages));
    }
}

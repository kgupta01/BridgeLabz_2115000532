public class InsertionSort {
    public static void insertionSort(int[] employeeIDs) {
        int n = employeeIDs.length;
        for (int i = 1; i < n; i++) {
            int key = employeeIDs[i];
            int j = i - 1;
            while (j >= 0 && employeeIDs[j] > key) {
                employeeIDs[j + 1] = employeeIDs[j];
                j--;
            }
            employeeIDs[j + 1] = key;
        }
    }
    public static void main(String[] args) {
        int[] employeeIDs = {104, 102, 108, 101, 105, 107};
        System.out.println("Original Employee IDs:");
        for (int id : employeeIDs) {
            System.out.print(id + " ");
        }
        insertionSort(employeeIDs);
        System.out.println("\nSorted Employee IDs:");
        for (int id : employeeIDs) {
            System.out.print(id + " ");
        }
    }
}

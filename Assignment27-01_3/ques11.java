public class ques11 {
    public static double[][] generateEmployeeData() {
        double[][] employeeData = new double[10][2];
        for (int i = 0; i < 10; i++) {
            double salary = Math.random() * 90000 + 10000;
            double yearsOfService = Math.random() * 15; 
            employeeData[i][0] = salary;
            employeeData[i][1] = yearsOfService;
        }
        return employeeData;
    }
    public static double[][] calculateBonusAndNewSalary(double[][] employeeData) {
        double[][] newEmployeeData = new double[10][3];
        for (int i = 0; i < 10; i++) {
            double salary = employeeData[i][0];
            double yearsOfService = employeeData[i][1];
            double bonus = 0;
            if (yearsOfService > 5) {
                bonus = salary * 0.05;
            } else {
                bonus = salary * 0.02;
            }
            double newSalary = salary + bonus;
            newEmployeeData[i][0] = salary;
            newEmployeeData[i][1] = newSalary;
            newEmployeeData[i][2] = bonus;
        }
        return newEmployeeData;
    }
    public static void displaySalaryAndBonusDetails(double[][] newEmployeeData) {
        double totalOldSalary = 0, totalNewSalary = 0, totalBonus = 0;
        System.out.println("Old Salary | New Salary | Bonus");
        for (int i = 0; i < 10; i++) {
            totalOldSalary += newEmployeeData[i][0];
            totalNewSalary += newEmployeeData[i][1];
            totalBonus += newEmployeeData[i][2];
            System.out.printf("%.2f | %.2f | %.2f\n", newEmployeeData[i][0], newEmployeeData[i][1], newEmployeeData[i][2]);
        }
        System.out.printf("\nTotal Old Salary: %.2f", totalOldSalary);
        System.out.printf("\nTotal New Salary: %.2f", totalNewSalary);
        System.out.printf("\nTotal Bonus Amount: %.2f\n", totalBonus);
    }
    public static void main(String[] args) {
        double[][] employeeData = generateEmployeeData();
        double[][] newEmployeeData = calculateBonusAndNewSalary(employeeData);
        displaySalaryAndBonusDetails(newEmployeeData);
    }
}

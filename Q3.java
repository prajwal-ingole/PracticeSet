import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
   
        Map<String, Double> studentGrades = new HashMap<>();
        System.out.println("Enter student names and grades (separated by space):");
        for (int i = 0; i < 5; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            String studentName = sc.next();
            double grade = sc.nextDouble();
            studentGrades.put(studentName, grade);
        }

        System.out.println("\nList of Students and Their Grades:");
        for (Map.Entry<String, Double> entry : studentGrades.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        double totalGrade = 0;
        for (double grade : studentGrades.values()) {
            totalGrade += grade;
        }
        double averageGrade = totalGrade / studentGrades.size();
        System.out.println("\nAverage Grade of All Students: " + averageGrade);
        sc.close();
    }


}
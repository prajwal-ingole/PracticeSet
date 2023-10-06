
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
	    private ArrayList<String> studentList = new ArrayList<>();

	    public void addStudent(String name) {
	        studentList.add(name);
	        System.out.println(name + " has been added to the student list.");
	    }

	    public void removeStudent(String name) {
	        if (studentList.contains(name)) {
	            studentList.remove(name);
	            System.out.println(name + " has been removed from the student list.");
	        } else {
	            System.out.println(name + " is not found in the student list.");
	        }
	    }

	    public void printStudents() {
	        System.out.println("List of Students:");
	        for (String name : studentList) {
	            System.out.println(name);
	        }
	    }

	    public static void main(String[] args) {
	        StudentManager studentManager = new StudentManager();
	        Scanner sc = new Scanner(System.in);

	        while (true) {
	            System.out.println("\nMENU:");
	            System.out.println("1. Add Student");
	            System.out.println("2. Remove Student");
	            System.out.println("3. Print Students");
	            System.out.println("4. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = sc.nextInt();
	            sc.nextLine(); // Consume newline

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter student name to add: ");
	                    String addName = sc.nextLine();
	                    studentManager.addStudent(addName);
	                    break;
	                case 2:
	                    System.out.print("Enter student name to remove: ");
	                    String removeName = sc.nextLine();
	                    studentManager.removeStudent(removeName);
	                    break;
	                case 3:
	                    studentManager.printStudents();
	                    break;
	                case 4:
	                    System.out.println("Exiting the program.");
	                    System.exit(0);
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }

}
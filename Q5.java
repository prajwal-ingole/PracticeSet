
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


class std{
private ArrayList<String> studentList = new ArrayList<>();
private boolean isSorted = false;

public void addStudent(String name) {
    studentList.add(name);
    isSorted = false;
    System.out.println(name + " has been added to the student list.");
}

public void removeStudent(String name) {
    if (studentList.contains(name)) {
        studentList.remove(name);
        isSorted = false;
        System.out.println(name + " has been removed from the student list.");
    } else {
        System.out.println(name + " is not found in the student list.");
    }
}

public void sortStudentsAlphabetically() {
    Collections.sort(studentList);
    isSorted = true;
    System.out.println("Students sorted alphabetically (A to Z).");
}

public void sortStudentsReverseAlphabetically() {
    Collections.sort(studentList, Collections.reverseOrder());
    isSorted = true;
    System.out.println("Students sorted in reverse alphabetical order (Z to A).");
}

public void printStudents() {
    if (studentList.isEmpty()) {
        System.out.println("The student list is empty.");
    } else {
        System.out.println("List of Students " + (isSorted ? "(Sorted)" : "(Not Sorted):"));
        for (String name : studentList) {
            System.out.println(name);
        	}
    	}
	}
}

public class Q5 {
	 public static void main(String[] args) {
	        std sM = new std();
	        Scanner sc = new Scanner(System.in);

	        while (true) {
	            System.out.println("\nMENU:");
	            System.out.println("1. Add Student");
	            System.out.println("2. Remove Student");
	            System.out.println("3. Sort Students Alphabetically");
	            System.out.println("4. Sort Students Reverse Alphabetically");
	            System.out.println("5. Print Students");
	            System.out.println("6. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = sc.nextInt();
	            sc.nextLine(); // Consume newline

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter student name to add: ");
	                    String addName = sc.nextLine();
	                    sM.addStudent(addName);
	                    break;
	                case 2:
	                    System.out.print("Enter student name to remove: ");
	                    String removeName = sc.nextLine();
	                    sM.removeStudent(removeName);
	                    break;
	                case 3:
	                    sM.sortStudentsAlphabetically();
	                    break;
	                case 4:
	                    sM.sortStudentsReverseAlphabetically();
	                    break;
	                case 5:
	                    sM.printStudents();
	                    break;
	                case 6:
	                    System.out.println("Exiting the program.");
	                    System.exit(0);
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }
}
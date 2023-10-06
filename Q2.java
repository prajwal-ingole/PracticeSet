import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class Student {
	public String name;
	public String id ;
	public List<Integer> test= new ArrayList<Integer>();
	
	public Student(String name, String id) throws InvalidIDFormatException {
        if (!id.matches("[0-9]{7}")) {
            throw new InvalidIDFormatException("Invalid ID format: " + id);
        }
        this.name = name;
        this.id = id;
    }

    public void addTestScore(int score) throws InvalidTestScoreException {
        if (score < 0 || score > 100) {
            throw new InvalidTestScoreException("Invalid test score: " + score);
        }
        test.add(score);
    }

    public double calculateAverageScore() throws IllegalArgumentException {
        if (test.isEmpty()) {
            throw new IllegalArgumentException("No test scores available for student: " + name);
        }

        int sum = 0;
        for (int score : test) {
            sum += score;
        }
        return (double) sum / test.size();
    }

	public String getname() {
		
		return name;
	}

	public String getid() {
		
		return id;
	}

	
	

}
class InvalidIDFormatException extends Exception {
    public InvalidIDFormatException(String message) {
        super(message);
    }
}
class InvalidTestScoreException extends Exception {
    public InvalidTestScoreException(String message) {
        super(message);
    }
}
class GradeBook {
	
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void assignGrades() {
        for (Student student : students) {
            try {
                double average = student.calculateAverageScore();
                System.out.println("Student: "+student.getname()+", ID: "+student.getid()+",Average Score: " + average);
                if (average >= 90) {
                    System.out.println("Grade: A");
                } else if (average >= 80) {
                    System.out.println("Grade: B");
                } else if (average >= 70) {
                    System.out.println("Grade: C");
                } else if (average >= 60) {
                    System.out.println("Grade: D");
                } else {
                    System.out.println("Grade: F");
                }
                System.out.println();
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return students;
	}

	
}


public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GradeBook gradeBook = new GradeBook();

        while (true) {
            try {
                System.out.println("MENU:");
                System.out.println("1. Add Student");
                System.out.println("2. Enter Test Scores");
                System.out.println("3. Calculate Grades");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter student name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter student ID (7 digits): ");
                        String id = sc.nextLine();

                        try {
                            Student st = new Student(name, id);
                            gradeBook.addStudent(st);
                            System.out.println("Student added.");
                        } catch (InvalidIDFormatException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    case 2:
                        System.out.print("Enter student ID: ");
                        String studentID = sc.nextLine();
                        Student student = null;

                        for (Student s : gradeBook.getStudents()) {
                            if (s.getid().equals(studentID)) {
                                student = s;
                                break;
                            }
                        }

                        if (student == null) {
                            System.out.println("Student not found with ID: " + studentID);
                            break;
                        }

                        try {
                            System.out.print("Enter test score: ");
                            int score = sc.nextInt();
                            student.addTestScore(score);
                            System.out.println("Test score added.");
                        } catch (InvalidTestScoreException | InputMismatchException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    case 3:
                        gradeBook.assignGrades();
                        break;
                    case 4:
                        System.out.println("Exiting the program.");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid choice.");
                sc.nextLine(); 
            }
        }
    }
}


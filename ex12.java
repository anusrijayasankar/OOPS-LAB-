import java.util.Scanner;

// Abstract class
abstract class Student {
    private int studentId;
    private String name;
    protected int mark1, mark2, mark3;

    // Constructor
    Student(int studentId, String name, int mark1, int mark2, int mark3) {
        this.studentId = studentId;
        this.name = name;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
    }

    // Encapsulation using getters
    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    // Abstract method
    abstract void calculatePerformance();
}

// Child class
class Performance extends Student {

    Performance(int studentId, String name,
                int mark1, int mark2, int mark3) {
        super(studentId, name, mark1, mark2, mark3);
    }

    // Method overriding
    @Override
    void calculatePerformance() {

        int total = mark1 + mark2 + mark3;
        double average = total / 3.0;

        String grade;

        if (average >= 90)
            grade = "A+";
        else if (average >= 80)
            grade = "A";
        else if (average >= 70)
            grade = "B";
        else if (average >= 60)
            grade = "C";
        else if (average >= 50)
            grade = "D";
        else
            grade = "F";

        System.out.println("\n================================");
        System.out.println(" STUDENT PERFORMANCE REPORT");
        System.out.println("================================");
        System.out.println("Student ID : " + getStudentId());
        System.out.println("Name       : " + getName());
        System.out.println("Mark 1     : " + mark1);
        System.out.println("Mark 2     : " + mark2);
        System.out.println("Mark 3     : " + mark3);
        System.out.println("Total      : " + total);
        System.out.printf("Average    : %.2f\n", average);
        System.out.println("Grade      : " + grade);
        System.out.println("================================");
    }
}

// Main class
public class SmartStudentManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("SMART STUDENT MANAGEMENT SYSTEM");
            System.out.println("--------------------------------");

            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();

            sc.nextLine();

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Mark 1: ");
            int m1 = sc.nextInt();

            System.out.print("Enter Mark 2: ");
            int m2 = sc.nextInt();

            System.out.print("Enter Mark 3: ");
            int m3 = sc.nextInt();

            // Validate marks
            if (m1 < 0 || m1 > 100 ||
                m2 < 0 || m2 > 100 ||
                m3 < 0 || m3 > 100) {

                throw new IllegalArgumentException(
                    "Marks must be between 0 and 100.");
            }

            // Create object
            Student student =
                new Performance(id, name, m1, m2, m3);

            // Polymorphism
            student.calculatePerformance();

        } catch (IllegalArgumentException e) {

            System.out.println("Error: " + e.getMessage());

        } catch (Exception e) {

            System.out.println("Invalid input!");
        }

        sc.close();
    }
}

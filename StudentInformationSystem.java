import java.util.Scanner;

public class StudentInformationSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\n--- Student Information System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input!");
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    if (!ValidationUtils.isValidAge(age)) {
                        System.out.println("Invalid age!");
                        break;
                    }

                    System.out.print("Grade (A-F): ");
                    String grade = sc.nextLine();

                    if (!ValidationUtils.isValidGrade(grade)) {
                        System.out.println("Invalid grade!");
                        break;
                    }

                    System.out.print("Contact: ");
                    String contact = sc.nextLine();

                    manager.addStudent(new Student(id, name, age, grade, contact));
                    break;

                case 2:
                    manager.viewStudents();
                    break;

                case 3:
                    System.out.print("Search by ID or Name: ");
                    sc.nextLine(); // clear buffer
                    String input = sc.nextLine();

                    Student found;
                    try {
                        found = manager.searchById(Integer.parseInt(input));
                    } catch (NumberFormatException e) {
                        found = manager.searchByName(input);
                    }

                    if (found != null) {
                        System.out.printf("%-5s %-15s %-5s %-10s %-15s%n",
                                "ID", "Name", "Age", "Grade", "Contact");
                        System.out.println(found);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Student ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    Student s = manager.searchById(updateId);
                    if (s == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    System.out.print("New Name: ");
                    s.setName(sc.nextLine());

                    System.out.print("New Age: ");
                    int newAge = sc.nextInt();
                    sc.nextLine();
                    if (ValidationUtils.isValidAge(newAge)) {
                        s.setAge(newAge);
                    }

                    System.out.print("New Grade: ");
                    String newGrade = sc.nextLine();
                    if (ValidationUtils.isValidGrade(newGrade)) {
                        s.setGrade(newGrade);
                    }

                    System.out.print("New Contact: ");
                    s.setContact(sc.nextLine());

                    System.out.println("Student updated successfully.");
                    break;

                case 5:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = sc.nextInt();

                    if (manager.deleteStudent(deleteId)) {
                        System.out.println("Student deleted.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

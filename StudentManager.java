 class Student {
    private int studentId;
    private String name;
    private int age;
    private String grade;
    private String contact;

    public Student(int studentId, String name, int age, String grade, String contact) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.contact = contact;
    }

    // Getters and Setters
    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGrade() {
        return grade;
    }

    public String getContact() {
        return contact;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String toString() {
        return String.format("%-5d %-15s %-5d %-10s %-15s",
                studentId, name, age, grade, contact);
    }
}

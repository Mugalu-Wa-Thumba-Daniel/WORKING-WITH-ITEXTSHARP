package WorkingWithItexsharp.model;

public class Student {
    // Student attributes
    private int id;                // Unique identifier for the student
    private String name;           // Student's name
    private int age;               // Student's age
    private String program;        // Student's program/field of study
    private String email;          // Student's email address

    // Default constructor
    public Student() {
    }

    // Constructor with parameters
    public Student(int id, String name, int age, String program, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.program = program;
        this.email = email;
    }

    // Getters and setters for each attribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // toString method to display student information
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", program='" + program + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

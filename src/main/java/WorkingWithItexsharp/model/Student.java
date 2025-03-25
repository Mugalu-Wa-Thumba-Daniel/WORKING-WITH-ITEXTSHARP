package WorkingWithItexsharp.model;

public class Student {
    // Attributs de l'étudiant
    private int id;                // Identifiant unique de l'étudiant
    private String name;           // Nom de l'étudiant
    private int age;               // Âge de l'étudiant
    private String program;        // Programme/filiaire de l'étudiant
    private String email;          // Adresse e-mail de l'étudiant

    // Constructeur par défaut
    public Student() {
    }

    // Constructeur avec paramètres
    public Student(int id, String name, int age, String program, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.program = program;
        this.email = email;
    }

    // Getters et Setters pour chaque attribut
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

    // Méthode toString pour afficher les informations de l'étudiant
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

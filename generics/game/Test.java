package generics.game;

/**
 * Class Test demonstrates the usage of parameterized classes and methods.
 */
public class Test {
  public static void main(String[] args) {
    Employee employee = new Employee("employee", 30);
    Employee employee2 = new Employee("employee2", 25);

    Schoolar schoolar = new Schoolar("schoolar", 20);
    Schoolar schoolar2 = new Schoolar("schoolar2", 22);
    Schoolar schoolar3 = new Schoolar("schoolar3", 22);
    Schoolar schoolar4 = new Schoolar("schoolar4", 22);

    Student student = new Student("student", 20);
    Student student2 = new Student("student2", 22);

    Team<Employee> employeeTeam = new Team<>("Employee Team");
    employeeTeam.addParticipant(employee);
    employeeTeam.addParticipant(employee2);

    Team<Schoolar> schoolarTeam = new Team<>("Schoolar Team");
    schoolarTeam.addParticipant(schoolar);
    schoolarTeam.addParticipant(schoolar2);

    Team<Schoolar> schoolarTeam2 = new Team<>("Schoolar Team2");
    schoolarTeam2.addParticipant(schoolar3);
    schoolarTeam2.addParticipant(schoolar4);

    Team<Student> studentTeam = new Team<>("Student Team");
    studentTeam.addParticipant(student);
    studentTeam.addParticipant(student2);

    schoolarTeam.playWith(schoolarTeam2);
  }
}

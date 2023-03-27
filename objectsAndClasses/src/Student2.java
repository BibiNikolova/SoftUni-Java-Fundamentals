import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student2 {
    static class Student {
        String firstName;
        String lastName;
        int age;
        String city;

        Student(String firstName, String lastName, int age, String city) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.city = city;
        }

        public boolean isFrom(String city) {
            return this.city.equals(city);
        }

        public String getInfo() {
            return String.format(" %s %s is %d years old",
                    this.firstName, this.lastName, this.age);
        }

        String getFirstName() {
            return this.firstName;
        }

        String getLastName() {
            return this.lastName;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> studentsList = new ArrayList<>();
        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            String[] studentArr = input.split("\\s+");
            String firstName = studentArr[0];
            String lastName = studentArr[1];
            int age = Integer.parseInt(studentArr[2]);
            String city = studentArr[3];

            Student existingStudent = findStudent(studentsList, firstName, lastName);
            if (existingStudent == null) {
                Student currentStudent = new Student(firstName, lastName, age, city);
                studentsList.add(currentStudent);
            } else {
                existingStudent.setAge(age);
                existingStudent.setCity(city);
            }
            input = scanner.nextLine();
        }
        String city = scanner.nextLine();
        for (Student student : studentsList) {
            if (student.isFrom(city)) {
                System.out.println(student.getInfo());
            }
        }
    }

    private static Student findStudent(List<Student> studentsList, String firstName, String lastName) {
        for (int i = 0; i < studentsList.size(); i++) {
            Student s = studentsList.get(i);

            if (s.getFirstName().equals(firstName)
                    && s.getLastName().equals(lastName)) {
                return s;
            }
        }
        return null;
    }
}

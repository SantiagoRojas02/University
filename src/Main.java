import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Lista e Inicialización de profesores
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new TeacherFullTime("Ana Osorio", 3000f, 5));   // name, baseSalary, yearsExperience
        teachers.add(new TeacherFullTime("Isabella Amaya", 2800f, 10));
        teachers.add(new TeacherPartTime("Camilo Murillo", 1000f, 20)); // name, baseSalary, activeHoursPerWeek
        teachers.add(new TeacherPartTime("Owen Holguin", 1200f, 15));

        //Lista e Inicialización de estudiantes
        List<Student> students = new ArrayList<>();
        students.add(new Student("Juan", 01, 21));   // name, id, age
        students.add(new Student("María", 02, 22));
        students.add(new Student("Pedro", 03, 23));
        students.add(new Student("Lucía", 04, 24));
        students.add(new Student("Andrés", 05, 25));
        students.add(new Student("Sofía", 06, 26));

        //Inicialización de clases
        List<Class> classes = new ArrayList<>();
        List<Student> class1Students = new ArrayList<>();
        class1Students.add(students.get(0));
        class1Students.add(students.get(1));
        classes.add(new Class("Matemáticas", "A101", class1Students, teachers.get(0)));

        List<Student> class2Students = new ArrayList<>();
        class2Students.add(students.get(2));
        class2Students.add(students.get(3));
        classes.add(new Class("Lógica", "A102", class2Students, teachers.get(1)));

        List<Student> class3Students = new ArrayList<>();
        class3Students.add(students.get(4));
        classes.add(new Class("Programación", "B201", class3Students, teachers.get(2)));

        List<Student> class4Students = new ArrayList<>();
        class4Students.add(students.get(5));
        classes.add(new Class("Física", "B103", class4Students, teachers.get(3)));

        int option = 0;
        while (option != 6) {
            System.out.println("1. Mostrar profesores");
            System.out.println("2. Mostrar clases");
            System.out.println("3. Registrar estudiante");
            System.out.println("4. Crear clase, asignar estudiantes y profesores");
            System.out.println("5. Buscar estudiante en alguna clase por ID");
            System.out.println("6. Exit");
            System.out.print("Seleccione una opción: ");

            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    for (Teacher t : teachers) {
                        System.out.print("Name: " + t.getName());

                        // Salario segun contrato
                        if (t instanceof TeacherFullTime) {
                            TeacherFullTime ft = (TeacherFullTime) t;
                            System.out.print(" Teacher Full Time ");
                            System.out.print(" Years of experience: " + ft.getXpYears());
                        } else if (t instanceof TeacherPartTime) {
                            TeacherPartTime pt = (TeacherPartTime) t;
                            System.out.print(" Teacher Part Time");
                            System.out.print(" Hours/week: " + pt.getHoursWeek());

                            System.out.println(" Total salary: " + t.calculateSalary());
                        }
                    }
                    break;
                case 2: // Mostrar clases (sin submenú)
                    for (Class c : classes) {
                        System.out.println("Class: " + c.getName());
                        System.out.println("Teacher: " + c.getTeacher().getName());
                        System.out.println("Students:");
                        for (Student s : c.getStudentsList()) {
                            System.out.println("Nombre: " + s.getName() + " (ID: " + s.getId() + ")");
                        }
                    }
                    break;
                case 3:

                    System.out.print("Ingrese nombre del estudiante: ");
                    String newName = sc.nextLine();

                    System.out.print("Ingrese ID del estudiante: ");
                    int newId = sc.nextInt();

                    System.out.print("Ingrese la edad del estudiante: ");
                    int newAge = sc.nextInt();

                    Student newStudent = new Student(newName, newId, newAge);

                    // Mostrar clases disponibles
                    System.out.println("Seleccione la clase a la que desea agregar el estudiante:");
                    for (int i = 0; i < classes.size(); i++) { // Recorrer lista clases y mostrar el nombre
                        System.out.println((i + 1) + ". " + classes.get(i).getName());
                    }

                    int choice = sc.nextInt() - 1;

                    if (choice > 0 && choice <= classes.size()) {
                        classes.get(choice).addStudent(newStudent);
                        System.out.println("Estudiante añadido a la clase: " + classes.get(choice).getName());
                    } else {
                        System.out.println("No se pudo añadir al estudiante");
                    }
                    break;

                case 4:
                    // Datos nueva clase
                    System.out.print("Ingrese el nombre de la clase: ");
                    String className = sc.nextLine();

                    System.out.print("Ingrese el aula: ");
                    String classroom = sc.nextLine();

                    // Elegir profesor
                    System.out.println("Seleccione un profesor:");
                    for (int i = 0; i < teachers.size(); i++) {
                        System.out.println((i + 1) + ". " + teachers.get(i).getName());
                    }
                    int Choice = sc.nextInt() - 1;

                    Teacher selectedTeacher = null;
                    if (Choice > 0 && Choice <= teachers.size()) {
                        selectedTeacher = teachers.get(Choice);
                    } else {
                        break;
                    }

                    // Elegir estudiantes
                    List<Student> selectedStudents = new ArrayList<>();
                    System.out.println("Seleccione estudiantes (ingrese IDs separados por coma).");
                    System.out.println("Estudiantes disponibles:");
                    for (Student s : students) {
                        System.out.println("ID: " + s.getId() + " - " + s.getName());
                    }

                    String studentInput = sc.nextLine();
                    String[] studentIds = studentInput.split(",");

                    for (String idStr : studentIds) {
                        try {
                            int id = Integer.parseInt(idStr.trim());
                            for (Student s : students) {
                                if (s.getId() == id) {
                                    selectedStudents.add(s);
                                }
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Id inválido " + idStr);
                        }
                    }

                    // Creacion la clase
                    Class newClass = new Class(className, classroom, selectedStudents, selectedTeacher);
                    classes.add(newClass);

                    System.out.println("Clase añadida: " + className + " en aula " + classroom);
                    break;

                case 5:
                    System.out.print("Ingrese el Id del estudiante: ");
                    int studentId = sc.nextInt();

                    boolean found = false;
                    for (Class c : classes) {
                        for (Student s : c.getStudentsList()) {
                            if (s.getId() == studentId) {
                                System.out.println("Estudiante " + studentId + " está en la clase: " + c.getName());
                                found = true;
                            }
                        }
                    }

                    if (!found) {
                        System.out.println("El estudiante no está en ninguna clase" + studentId);
                    }
                    break;
                case 6:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        }
        sc.close();

    }
}
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HashMap<String, Student> students = new HashMap<>();

        // ====================== TASK 1 ======================
        students.put("S1", new Student("nurai", 3.5, 18));
        students.put("S2", new Student("beknur", 3.5, 20)); // same GPA
        students.put("S3", new Student("nurzat", 3.9, 17));
        students.put("S4", new Student("umar", 3.7, 19));
        students.put("S5", new Student("anara", 3.2, 19));
        // Сделай минимум два студента с одинаковым GPA (для Task 3)

        // TODO: Напечатай всех студентов (ID + объект)
        for (String a: students.keySet()){
            System.out.println(a+ " : " + students.get(a));
        }

        // TODO: Найди студента по ID и выведи его
        System.out.println(students.get("S5"));

        // TODO: Удали одного студента по ID
        students.remove(("S1"));

        // TODO: Обнови GPA у одного студента
        students.get("S4").setGpa(3.5);

        // ====================== SORTING (IMPORTANT) ======================
        // TODO: Создай ArrayList из всех студентов (students.values())
        List<Student> list = new ArrayList<>(students.values());

        // TODO 6a: Отсортируй по GPA (natural ordering) и выведи
        Collections.sort(list);
        for (Student s : list) {
            System.out.println(s);
        }
        // TODO 6b: Отсортируй по имени (Comparator) и выведи
        list.sort(Comparator.comparing(Student::getName));
        for (Student s : list) {
            System.out.println(s);
        }

        // ====================== TASK 2 ======================
        System.out.println("\n=== Task 2: Top 3 by GPA ===");
        // TODO: Создай новый список, отсортируй по GPA по убыванию, выведи первые 3
        List<Student> topList = new ArrayList<>(students.values());
        topList.sort((a, b) -> Double.compare(b.getGpa(), a.getGpa()));

        for (int i = 0; i < 3 && i < topList.size(); i++) {
            System.out.println(topList.get(i));
        }

        // ====================== TASK 3 ======================
        System.out.println("\n=== Task 3: Students with same GPA ===");
        // TODO: Сгруппируй студентов по GPA и выведи только те, где больше 1 студента
        HashMap<Double, List<String>> gpaMap = new HashMap<>();

        for (Student s : students.values()) {
            gpaMap.putIfAbsent(s.getGpa(), new ArrayList<>());
            gpaMap.get(s.getGpa()).add(s.getName());
        }

        for (double gpa : gpaMap.keySet()) {
            if (gpaMap.get(gpa).size() > 1) {
                System.out.println("GPA " + gpa + " :  " + gpaMap.get(gpa));
            }
        }

        // ====================== TASK 4 ======================
        System.out.println("\n=== Task 4: Courses ===");
        HashMap<Course, List<Student>> courseMap = new HashMap<>();
        // TODO: Создай 2–3 курса, добавь студентов, выведи всё

        Course math = new Course("Math");
        Course cs = new Course("CS");

        courseMap.put(math, new ArrayList<>());
        courseMap.put(cs, new ArrayList<>());

        courseMap.get(math).add(students.get("S1"));
        courseMap.get(math).add(students.get("S2"));
        courseMap.get(cs).add(students.get("S3"));

        for (Course c : courseMap.keySet()) {
            System.out.println(c + " : " + courseMap.get(c));
        }

        // ====================== TASK 5 ======================
        System.out.println("\n=== Task 5: GPA desc + Name ===");
        // TODO: Создай Comparator (GPA убывание → если равно, то имя возрастание) и отсортируй
        List<Student> complexSort = new ArrayList<>(students.values());

        complexSort.sort((a, b) -> {
            int gpaCompare = Double.compare(b.getGpa(), a.getGpa());
            if (gpaCompare != 0) return gpaCompare;
            return a.getName().compareTo(b.getName());
        });

        complexSort.forEach(System.out::println);
    }
}




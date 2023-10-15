
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        String option;
        do {
            System.out.println("---------- M E N U ----------");
            System.out.println("|   1. Pokaż zadania        |");
            System.out.println("|   2. Dodaj nowe zadanie   |");
            System.out.println("|   3. Zakończ zadanie      |");
            System.out.println("| ------------------------- |");
            System.out.println("|   Q. Zakończ program      |");
            System.out.println("-----------------------------");
            System.out.println("Wybierz akcję: ");

            option = scanner.nextLine();

            switch (option) {
                case "1" -> showTasks();
                case "2" -> addNewTask();
                case "3" -> changeStatus();
                case "q", "Q" -> System.out.println("Do widzenia!");
                default -> System.out.println("Nie rozpoznano zadania.");
            }
        } while (!option.equals("Q") && !option.equals("q"));
    }

    private static void showTasks() {
        if(tasks.isEmpty()) {
            System.out.println("Brak zadań na liście.");
        } else {
            System.out.println("-------- Z A D A N I A --------");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(i + 1 + ". " + tasks.get(i).toString());
            }
            System.out.println("-------------------------------");
        }
    }

    private static void addNewTask() {
        System.out.println("Podaj nazwę zadania: ");
        String name = scanner.nextLine();
        tasks.add(new Task(name));
        System.out.println("Pomyślnie dodano zadanie.");
    }

    private static void changeStatus() {
        System.out.println("Podaj numer zadania: ");
        int number = scanner.nextInt();
        if(number > tasks.size() || number <= 0) {
            System.out.println("Nie znaleziono zadania o takim numerze.");
        } else {
            tasks.get(number - 1).setFinished();
            System.out.println("Pomyślnie ukończono zadanie.");
        }
    }


    static class Task {
        private final String name;
        private boolean isFinished;

        public Task(String name) {
            this.name = name;
            this.isFinished = false;
        }

        public void setFinished() {
            isFinished = true;
        }

        @Override
        public String toString() {
            String checkBox = isFinished ? "[x] " : "[ ] ";
            return checkBox + name;
        }
    }
}

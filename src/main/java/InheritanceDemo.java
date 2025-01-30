import java.util.ArrayList;

public class InheritanceDemo {
    public static void main(String[] args) {
        ArrayList<Worker> workers = new ArrayList<>();

        workers.add(new Worker("John", "Doe", "W001", "Mr.", 1990, 20.0));
        workers.add(new Worker("Alice", "Johnson", "W002", "Ms.", 1985, 22.5));
        workers.add(new Worker("Robert", "Brown", "W003", "Mr.", 1993, 18.75));

        workers.add(new SalaryWorker("Sarah", "Williams", "S001", "Dr.", 1982, 25.0, 52000));
        workers.add(new SalaryWorker("Michael", "Davis", "S002", "Prof.", 1978, 30.0, 60000));
        workers.add(new SalaryWorker("Emily", "Clark", "S003", "Ms.", 1995, 28.5, 55000));

        int[] weeklyHours = {40, 50, 40};

        System.out.println("-----------------------------------------------------------------");
        System.out.println("| Name              | ID    | Week 1 ($) | Week 2 ($) | Week 3 ($) |");
        System.out.println("-----------------------------------------------------------------");

        for (Worker worker : workers) {
            System.out.printf("| %-16s | %-5s |", worker.getFirstName() + " " + worker.getLastName(), worker.getID());
            for (int hours : weeklyHours) {
                double weeklyPay = worker.calculateWeeklyPay(hours);
                System.out.printf(" %10.2f |", weeklyPay);
            }
            System.out.println();
        }

        System.out.println("-----------------------------------------------------------------");

        System.out.println("\nDetailed Weekly Pay Breakdown:\n");
        for (int i = 0; i < weeklyHours.length; i++) {
            System.out.println("Week " + (i + 1) + " (" + weeklyHours[i] + " hours worked):");
            for (Worker worker : workers) {
                worker.displayWeeklyPay(weeklyHours[i]);
            }
        }
    }
}

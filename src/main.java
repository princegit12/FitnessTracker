import java.util.ArrayList;
import java.util.Scanner;

class FitnessActivity {
    private String activityName;
    private int duration; // in minutes
    private int caloriesBurned;

    public FitnessActivity(String activityName, int duration, int caloriesBurned) {
        this.activityName = activityName;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
    }

    @Override
    public String toString() {
        return "Activity: " + activityName + ", Duration: " + duration + " mins, Calories Burned: " + caloriesBurned;
    }
}

public class FitnessTrackerApp {
    private ArrayList<FitnessActivity> activityLog = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addActivity() {
        System.out.print("Enter activity name: ");
        String activityName = scanner.nextLine();
        System.out.print("Enter duration in minutes: ");
        int duration = scanner.nextInt();
        System.out.print("Enter calories burned: ");
        int caloriesBurned = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer

        FitnessActivity activity = new FitnessActivity(activityName, duration, caloriesBurned);
        activityLog.add(activity);
        System.out.println("Activity added successfully!");
    }

    public void viewActivities() {
        if (activityLog.isEmpty()) {
            System.out.println("No activities logged yet.");
        } else {
            for (FitnessActivity activity : activityLog) {
                System.out.println(activity);
            }
        }
    }

    public static void main(String[] args) {
        FitnessTrackerApp app = new FitnessTrackerApp();
        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        while (running) {
            System.out.println("1. Add Activity");
            System.out.println("2. View Activities");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    app.addActivity();
                    break;
                case 2:
                    app.viewActivities();
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting... Thank you for using the Fitness Tracker!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}
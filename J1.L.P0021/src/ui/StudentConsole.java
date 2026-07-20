package ui;

import constant.AppConfigs;
import java.util.ArrayList;
import service.StudentService;
import util.Validation;

/**
 * Main menu loop. Delegates each feature to its dedicated view.
 */
public class StudentConsole {

    private final StudentService service = new StudentService(
            new ArrayList<>());
    private final CreateView createView;
    private final FindSortView findSortView;
    private final UpdateDeleteView updateDeleteView;
    private final ReportView reportView;

    /**
     * Initializes all sub-views with the shared service.
     */
    public StudentConsole() {
        createView = new CreateView(service);
        findSortView = new FindSortView(service);
        updateDeleteView = new UpdateDeleteView(service);
        reportView = new ReportView(service);
    }

    /**
     * Starts the main program loop.
     */
    public void start() {
        boolean running = true;
        while (running) {
            System.out.println(
                    "\n===== WELCOME TO STUDENT MANAGEMENT =====");
            System.out.println(
                    AppConfigs.CREATE + ". Create");
            System.out.println(
                    AppConfigs.FIND_AND_SORT + ". Find and Sort");
            System.out.println(
                    AppConfigs.UPDATE_OR_DELETE + ". Update/Delete");
            System.out.println(
                    AppConfigs.REPORT + ". Report");
            System.out.println(
                    AppConfigs.EXIT + ". Exit");
            System.out.println(
                    "=========================================");

            int choice = Validation.readInteger(
                    "Please choose (1-5): ",
                    AppConfigs.CREATE, AppConfigs.EXIT,
                    "Error: Input must be a number!",
                    "Error: Choice must be from 1 to 5!");

            switch (choice) {
                case AppConfigs.CREATE:
                    createView.show();
                    break;
                case AppConfigs.FIND_AND_SORT:
                    findSortView.show();
                    break;
                case AppConfigs.UPDATE_OR_DELETE:
                    updateDeleteView.show();
                    break;
                case AppConfigs.REPORT:
                    reportView.show();
                    break;
                case AppConfigs.EXIT:
                    System.out.println(
                            "Thank you for using the system. "
                            + "Goodbye!");
                    running = false;
                    break;
                default:
                    break;
            }
        }
    }
}

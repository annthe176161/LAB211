package ui;

import java.util.Map;
import service.StudentService;

/**
 * Console view for displaying the student report.
 */
public class ReportView {

    private final StudentService service;

    /**
     * @param service the student service
     */
    public ReportView(StudentService service) {
        this.service = service;
    }

    /**
     * Displays the report of students grouped by name and course.
     */
    public void show() {
        System.out.println("\n--- Report ---");
        Map<String, Integer> data = service.countByCourseAndName();
        if (data.isEmpty()) {
            System.out.println("The student list is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> e : data.entrySet()) {
            sb.append(e.getKey())
                    .append(" | ")
                    .append(e.getValue())
                    .append("\n");
        }
        System.out.print(sb);
    }
}

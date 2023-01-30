package duke;

import java.util.Scanner;

/**
 * UI that deals with the display of data for the user once the chatbot is started up.
 */
public class Ui {

    /**
     * Divider line.
     */
    private static final String LINE = "__________________________________________";
    /**
     * A scanner that scans for user input.
     */
    private final Scanner SCANNER;

    /**
     * Constructor for a new UI with a scanner.
     */
    public Ui() {
        SCANNER = new Scanner(System.in);
    }

    /**
     * Displays the welcome message when the chatbot is started.
     */
    public void showWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        String introMsg = "Hello! I'm Duke.\n What can I do for you today?";

        showLine();
        showMsg(logo);
        showMsg(introMsg);
        showLine();
    }

    /**
     * Display a divider line.
     */
    public void showLine() {
        showMsg(Ui.LINE);
    }

    /**
     * Display the message provided.
     *
     * @param msg The message to be displayed
     */
    public void showMsg(String msg) {
        System.out.println(msg);
    }

    /**
     * Displays the error/hint message.
     *
     * @param errorMsg The error/hint message
     */
    public void showError(String errorMsg) {
        showMsg(errorMsg);
        showMsg("Please try again!");
    }

    /**
     * Displays the string representation of the task being added, together with the new updated number of tasks in
     * the task list.
     *
     * @param taskString The string representation of the task being added
     * @param size       The number of tasks in the list of tasks
     */
    public void showAddTask(String taskString, int size) {
        String msgHeader = "I've added this task into the list:";
        String msgFooter = String.format("Now you have a total of %s tasks in the list", size);

        showMsg(msgHeader);
        showMsg(taskString);
        showMsg(msgFooter);
    }

    /**
     * Displays the string representation of the task being deleted, together with the new updated number of tasks in
     * the task list.
     *
     * @param taskString The string representation of the task being deleted
     * @param size       The number of tasks in the list of tasks
     */
    public void showDeleteTask(String taskString, int size) {
        String msgHeader = "I've deleted this task into the list:";
        String msgFooter = String.format("Now you have a total of %s tasks in the list", size);

        showMsg(msgHeader);
        showMsg(taskString);
        showMsg(msgFooter);
    }

    /**
     * Scans and returns the full string representation of the command input.
     *
     * @return The full string representation of the command
     */
    public String readCommand() {
        return SCANNER.nextLine();
    }

    /**
     * Closes the scanner that reads user input.
     */
    public void close() {
        SCANNER.close();
    }
}

package duke;

import java.util.Scanner;

public class Ui {

    private static final String LINE = "__________________________________________";
    private final Scanner SCANNER;

    public Ui() {
        SCANNER = new Scanner(System.in);
    }

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

    public void showLine() {
        showMsg(Ui.LINE);
    }

    public void showMsg(String msg) {
        System.out.println(msg);
    }

    public void showError(String errorMsg) {
        showMsg(errorMsg);
        showMsg("Please try again!");
    }

    public void showAddTask(String taskString, int size) {
        String msgHeader = "I've added this task into the list:";
        String msgFooter = String.format("Now you have a total of %s tasks in the list", size);

        showMsg(msgHeader);
        showMsg(taskString);
        showMsg(msgFooter);
    }

    public void showDeleteTask(String taskString, int size) {
        String msgHeader = "I've deleted this task into the list:";
        String msgFooter = String.format("Now you have a total of %s tasks in the list", size);

        showMsg(msgHeader);
        showMsg(taskString);
        showMsg(msgFooter);
    }

    public String readCommand() {
        return SCANNER.nextLine();
    }

    public void close() {
        SCANNER.close();
    }
}

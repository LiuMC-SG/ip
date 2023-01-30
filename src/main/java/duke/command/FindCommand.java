package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.task.Task;

/**
 * A command that stores the command to find all tasks that match the specific term as a substring. The action of
 * finding the tasks that match can be carried out when called.
 */
public class FindCommand extends Command {
    /**
     * The finding term.
     */
    private final String TERM;

    /**
     * Constructor for a command to find all tasks that match the specific term as a substring.
     *
     * @param commandString The find command in string representation
     * @param term The finding term
     */
    public FindCommand(String commandString, String term) {
        super(AvailableCommands.FIND, commandString);
        TERM = term;
    }

    /**
     * Finds all tasks that matches the finding term. Display out a numbered list of all of these tasks.
     *
     * @param taskList List of tasks that are stored
     * @param ui       UI to deal with the visual output
     * @param storage  Storage to deal with input and output of data
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        String msgHeader = "These are the tasks with matching descriptions in them:";
        ui.showMsg(msgHeader);

        int counter = 1;
        for (Task task : taskList.getTasks()) {
            if (task.isInDescription(TERM)) {
                String output = String.format("%d. %s", counter++, task);
                ui.showMsg(output);
            }
        }
    }
}

package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.task.Task;

import java.util.ArrayList;

/**
 * A command that stores the command to delete a task. The action of deleting the task can be carried out when called.
 */
public class DeleteCommand extends Command {
    /**
     * The string representation of the index to be deleted.
     */
    private final String INDEX_STRING;

    /**
     * Constructor for a command to delete a task.
     *
     * @param commandString The delete command in string representation
     * @param indexString   The string representation of the index to be deleted
     */
    public DeleteCommand(String commandString, String indexString) {
        super(AvailableCommands.DELETE, commandString);
        INDEX_STRING = indexString;
    }

    /**
     * Deletes the task in the task list with the given index.
     * Checks if the index in string representation is valid. If so, deletes the appropriate task. Otherwise, throw
     * an exception that states the issue with the string representation of the index.
     *
     * @param taskList List of tasks that are stored
     * @param ui       UI to deal with the visual output
     * @param storage  Storage to deal with input and output of data
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        ArrayList<Task> tasks = taskList.getTasks();
        int index = isValidIndex(INDEX_STRING, tasks);

        Task task = tasks.get(index);
        tasks.remove(index);

        ui.showDeleteTask(task.toString(), tasks.size());
    }
}

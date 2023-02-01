package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.task.Task;
import duke.task.Todo;
import duke.textui.TextUi;

/**
 * A command that stores the command to add a new todo task. The action of adding the task can be carried out when
 * called.
 */
public class AddTodoCommand extends Command {
    /**
     * The description of the todo task.
     */
    private final String DATA;

    /**
     * Constructor for a command to add new todo task.
     *
     * @param commandString The add todo command in string representation
     * @param data          The description of the todo task
     */
    public AddTodoCommand(String commandString, String data) {
        super(AvailableCommands.ADD_TODO, commandString);
        DATA = data;
    }

    /**
     * Adds a new todo task into the task list with the given description.
     *
     * @param taskList List of tasks that are stored
     * @param ui       UI to deal with the visual output
     * @param storage  Storage to deal with input and output of data
     */
    @Override
    public String execute(TaskList taskList, TextUi ui, Storage storage) throws DukeException {
        Task todo = new Todo(DATA);
        taskList.addTask(todo);

        return ui.showAddTask(todo.toString(), taskList.size());
    }
}

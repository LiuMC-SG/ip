package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.task.Event;
import duke.task.Task;

/**
 * A command that stores the command to add a new event task. The action of adding the task can be carried out when
 * called.
 */
public class AddEventCommand extends Command {
    /**
     * The description, start and end date of the event task.
     */
    private final String DATA;

    /**
     * Constructor for a command to add new event task.
     *
     * @param commandString The add event command in string representation
     * @param data          The description, start and end date of the event task
     */
    public AddEventCommand(String commandString, String data) {
        super(AvailableCommands.ADD_EVENT, commandString);
        DATA = data;
    }

    /**
     * Adds a new event task into the task list.
     * The start and end dates are filtered out. If they exist, then an event task will be created. Otherwise, an
     * exception would be thrown stating that either the start or end dates were not specified.
     *
     * @param taskList List of tasks that are stored
     * @param ui       UI to deal with the visual output
     * @param storage  Storage to deal with input and output of data
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        String[] splitData1 = DATA.split(" /from ", 2);
        if (splitData1.length < 2) {
            throw new DukeException("Event command format error. Missing /from");
        }

        String[] splitData2 = splitData1[1].split(" /to ", 2);
        if (splitData2.length < 2) {
            throw new DukeException("Event command format error. Missing /to");
        }

        Task event = new Event(splitData1[0], splitData2[0], splitData2[1]);
        taskList.addTask(event);

        ui.showAddTask(event.toString(), taskList.size());
    }
}

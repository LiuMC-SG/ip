package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;

/**
 * A command that stores the command to quit the chatbot. The action of exiting the chatbot can be carried out when
 * called.
 */
public class ExitCommand extends Command {
    /**
     * Constructor for a command to exit the chatbot.
     *
     * @param commandString The exit command in string representation
     */
    public ExitCommand(String commandString) {
        super(AvailableCommands.EXIT, commandString);
    }

    /**
     * Exits the chatbot and shows the exit message.
     *
     * @param tasklist List of tasks that are stored
     * @param ui       UI to deal with the visual output
     * @param storage  Storage to deal with input and output of data
     */
    @Override
    public void execute(TaskList tasklist, Ui ui, Storage storage) throws DukeException {
        String exitMsg = "Thank you for coming!\n"
                + "Hope to see you again soon!\n"
                + "~~Bye";
        ui.showMsg(exitMsg);

        storage.updateData(tasklist);
        ui.close();
    }
}

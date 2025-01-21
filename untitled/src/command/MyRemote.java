package command;

import java.util.Stack;

public class MyRemote {
    ICommand command;
    Stack<ICommand> undoStack = new Stack<>();

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void execute() {
        command.execute();
        undoStack.push(command);
    }

    public void undo() {
        if(undoStack.size() > 0) {
            ICommand command = undoStack.pop();
            command.undo();
        }
    }
}

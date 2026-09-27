import java.util.ArrayDeque;
import java.util.Deque;

public class EditorApp {
    private Deque<Command> commandHistory = new ArrayDeque<>();

    public void executeCommand(Command command) {
        command.execute();
        commandHistory.push(command);
    }

    public void undo() {
        if (!commandHistory.isEmpty()) {
            Command command = commandHistory.pop();
            command.undo();
        }
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        EditorApp app = new EditorApp();

        Command firstInsert =
                new InsertCommand(editor, 0, "Hello");

        app.executeCommand(firstInsert);
        System.out.println("After first insert: " + editor.getText());

        Command secondInsert =
                new InsertCommand(editor, 5, " World");

        app.executeCommand(secondInsert);
        System.out.println("After second insert: " + editor.getText());

        Command thirdInsert =
                new InsertCommand(editor, 11, "!");

        app.executeCommand(thirdInsert);
        System.out.println("After third insert: " + editor.getText());

        app.undo();
        System.out.println("After first undo: " + editor.getText());

        app.undo();
        System.out.println("After second undo: " + editor.getText());

        app.undo();
        System.out.println("After third undo: " + editor.getText());
    }
}

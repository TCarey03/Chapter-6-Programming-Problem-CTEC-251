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

        // Insert the original text
        app.executeCommand(
                new InsertCommand(editor, 0, "Hello World!")
        );

        System.out.println("Original text: " + editor.getText());

        // Delete "World"
        app.executeCommand(
                new DeleteCommand(editor, 6, 5)
        );

        System.out.println("After deletion: " + editor.getText());

        // Undo the deletion
        app.undo();

        System.out.println("After undo: " + editor.getText());
    }
}

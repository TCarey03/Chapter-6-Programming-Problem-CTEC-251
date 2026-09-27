import java.util.ArrayDeque;
import java.util.Arrays;
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

        Command header =
                new InsertCommand(editor, 0, "HEADER");

        Command newline =
                new InsertCommand(editor, 6, "\n");

        Command footer =
                new InsertCommand(editor, 7, "FOOTER");

        MacroCommand template = new MacroCommand(
                Arrays.asList(header, newline, footer)
        );

        // Execute the entire template
        app.executeCommand(template);

        System.out.println("After macro:");
        System.out.println(editor.getText());

        // Undo the entire template
        app.undo();

        System.out.println("After undo:");
        System.out.println(editor.getText());
    }
}

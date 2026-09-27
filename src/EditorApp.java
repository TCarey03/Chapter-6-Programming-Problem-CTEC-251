public class EditorApp {
    private Command lastCommand;

    public void executeCommand(Command command) {
        command.execute();
        lastCommand = command;
    }

    public void undo() {
        if (lastCommand != null) {
            lastCommand.undo();
            lastCommand = null;
        }
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        EditorApp app = new EditorApp();

        Command insertCommand =
                new InsertCommand(editor, 0, "Hello World!");

        app.executeCommand(insertCommand);

        System.out.println("After insert: " + editor.getText());

        app.undo();

        System.out.println("After undo: " + editor.getText());
    }
}

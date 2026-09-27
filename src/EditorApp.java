public class EditorApp {
    public void executeCommand(Command command) {
        command.execute();
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        Command insertCommand =
                new InsertCommand(editor, 0, "Hello World!");

        EditorApp app = new EditorApp();

        app.executeCommand(insertCommand);

        System.out.println(editor.getText());
    }
}
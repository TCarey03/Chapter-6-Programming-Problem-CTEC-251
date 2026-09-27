public class DeleteCommand implements Command {
    private TextEditor editor;
    private int position;
    private int length;
    private String deletedText;

    public DeleteCommand(TextEditor editor, int position, int length) {
        this.editor = editor;
        this.position = position;
        this.length = length;
    }

    @Override
    public void execute() {
        // Save the text before deleting it
        deletedText = editor.getText()
                .substring(position, position + length);

        // Delete the selected text
        editor.deleteText(position, position + length);
    }

    @Override
    public void undo() {
        // Restore the deleted text
        editor.insertText(position, deletedText);
    }
}

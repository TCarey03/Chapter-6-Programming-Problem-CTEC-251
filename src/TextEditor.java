public class TextEditor {
    private StringBuilder text;

    public TextEditor() {
        text = new StringBuilder();
    }

    public void insertText(int position, String content) {
        text.insert(position, content);
    }

    public String getText() {
        return text.toString();
    }
}
public class TextEditor {
    private StringBuilder text;

    public TextEditor() {
        text = new StringBuilder();
    }

    public void insertText(int position, String content) {
        text.insert(position, content);
    }

    public void deleteText(int start, int end) {
        text.delete(start, end);
    }

    public String getText() {
        return text.toString();
    }
}

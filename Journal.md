Phase 1: The Foundation

The EditorApp is decoupled from the TextEditor because it does not directly call methods such as editor.insertText(). Instead, the EditorApp works with the Command interface and tells the command to execute.

The InsertCommand contains the reference to the TextEditor and knows what text should be inserted and where it should be inserted. This keeps the actual text manipulation inside the command and receiver instead of putting that logic inside EditorApp.

If the app had to call editor.insertText() directly, the EditorApp would become more dependent on the TextEditor class. Adding new operations, such as deleting text, would require adding more direct calls and logic to the app. Using Command objects makes it easier to add different operations without changing the basic structure of EditorApp.

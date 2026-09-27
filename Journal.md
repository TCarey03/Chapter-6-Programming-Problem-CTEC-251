Phase 1: The Foundation

The EditorApp is decoupled from the TextEditor because it does not directly call methods such as editor.insertText(). Instead, the EditorApp works with the Command interface and tells the command to execute.

The InsertCommand contains the reference to the TextEditor and knows what text should be inserted and where it should be inserted. This keeps the actual text manipulation inside the command and receiver instead of putting that logic inside EditorApp.

If the app had to call editor.insertText() directly, the EditorApp would become more dependent on the TextEditor class. Adding new operations, such as deleting text, would require adding more direct calls and logic to the app. Using Command objects makes it easier to add different operations without changing the basic structure of EditorApp.

--------------------------

Phase 2: Basic Undo

Having the Command object responsible for its own undo logic makes the EditorApp class simpler because the app does not need to know how each individual command should be reversed.

For example, InsertCommand knows that undoing an insertion means deleting the text that was inserted. The EditorApp only needs to call lastCommand.undo().

This also makes the design easier to expand. If I add another type of command later, that command can provide its own undo() behavior without adding more undo logic to EditorApp.

-------------------------

Phase 3: Command History

A Stack is ideal for managing undo operations because undoing actions should happen in Last-In-First-Out (LIFO) order. The most recent command should always be the first command that gets undone.

For example, if I insert "Hello", then " World", and then "!", the "!" should be removed first. After that, " World" should be removed, and finally "Hello".

If I used a Queue instead, the first command I added would be removed first. This would be First-In-First-Out (FIFO), which would not match the normal behavior of an undo system.

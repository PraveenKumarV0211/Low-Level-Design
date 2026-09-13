package Model;

import java.util.ArrayDeque;
import java.util.Deque;

public class TextEditor {
    private final Document doc = new Document();
    private final Deque<Command> undoStack = new ArrayDeque<>();
    private final Deque<Command> redoStack = new ArrayDeque<>();
    private String clipboard = "";

    private void run(Command c) {
        c.execute();
        doc.clearSelection();
        undoStack.push(c);
        redoStack.clear();
    }

    public void insert(String text) {
        if (text == null || text.isEmpty()) return;
        run(new InsertCommand(doc, text));
    }

    public int delete(int k) {
        int cursor = doc.getCursor();
        int start = Math.max(0, cursor - k);
        if (start == cursor) return 0;
        run(new DeleteRangeCommand(doc, start, cursor));
        return cursor - start;
    }

    public void moveCursorLeft(int k) {
        doc.setCursor(doc.getCursor() - k);
        doc.clearSelection();
    }

    public void moveCursorRight(int k) {
        doc.setCursor(doc.getCursor() + k);
        doc.clearSelection();
    }

    public void select(int start, int end) {
        doc.select(start, end);
    }

    public void copy() {
        if (!doc.hasSelection()) return;
        clipboard = doc.getContent().substring(doc.getSelStart(), doc.getSelEnd());
    }

    public void cut() {
        if (!doc.hasSelection()) return;
        DeleteRangeCommand c = new DeleteRangeCommand(doc, doc.getSelStart(), doc.getSelEnd());
        run(c);
        clipboard = c.getRemoved();
        doc.clearSelection();
    }

    public void paste() {
        if (clipboard.isEmpty()) return;
        run(new InsertCommand(doc, clipboard));
    }

    public void undo() {
        if (undoStack.isEmpty()) return;
        Command c = undoStack.pop();
        c.undo();
        redoStack.push(c);
    }

    public void redo() {
        if (redoStack.isEmpty()) return;
        Command c = redoStack.pop();
        c.execute();
        undoStack.push(c);
    }

    public String getContent() { return doc.getContent(); }

    public int getCursor() { return doc.getCursor(); }
}

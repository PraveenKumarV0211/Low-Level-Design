package Model;

public class Document {
    private final StringBuilder buffer = new StringBuilder();
    int cursor = 0;
    int selStart = -1;
    int selEnd = -1;

    int length() { return buffer.length(); }

    int getCursor() { return cursor; }

    String getContent() { return buffer.toString(); }

    void setCursor(int pos) {
        cursor = Math.max(0, Math.min(pos, buffer.length()));
    }
    void insertAt(int pos, String text) {
        buffer.insert(pos, text);
    }

    String deleteRange(int start, int end) {
        String removed = buffer.substring(start, end);
        buffer.delete(start, end);
        return removed;
    }
    void select(int start, int end) {
        selStart = Math.max(0, Math.min(start, buffer.length()));
        selEnd = Math.max(selStart, Math.min(end, buffer.length()));
    }

    boolean hasSelection() { return selStart >= 0 && selEnd > selStart; }

    int getSelStart() { return selStart; }

    int getSelEnd() { return selEnd; }

    void clearSelection() {
        selStart = -1;
        selEnd = -1;
    }

}



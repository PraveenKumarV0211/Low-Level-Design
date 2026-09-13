package Model;

class DeleteRangeCommand implements Command {
    private final Document doc;
    private final int start;
    private final int end;
    private String removed;

    DeleteRangeCommand(Document doc, int start, int end) {
        this.doc = doc;
        this.start = start;
        this.end = end;
    }

    public void execute() {
        removed = doc.deleteRange(start, end);
        doc.setCursor(start);
    }

    public void undo() {
        doc.insertAt(start, removed);
        doc.setCursor(end);
    }

    String getRemoved() { return removed; }
}
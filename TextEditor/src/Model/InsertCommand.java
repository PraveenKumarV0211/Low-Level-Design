package Model;

public class InsertCommand implements Command {
    private final Document doc;
    private final String text;
    private final int pos;

    InsertCommand(Document doc, String text) {
        this.doc = doc;
        this.text = text;
        this.pos = doc.getCursor();
    }

    public void execute() {
        doc.insertAt(pos, text);
        doc.setCursor(pos + text.length());
    }

    public void undo() {
        doc.deleteRange(pos, pos + text.length());
        doc.setCursor(pos);
    }
}

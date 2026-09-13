import Model.TextEditor;

public class Main {
    public static void main(String[] args) {
        TextEditor e = new TextEditor();

        e.insert("Hello");
        print(e, "insert Hello");

        e.insert(" World");
        print(e, "insert ' World'");

        e.select(0, 5);
        e.copy();
        e.moveCursorRight(100);
        e.paste();
        print(e, "copy 0..5 then paste at end");

        System.out.println("delete(5) removed = " + e.delete(5));
        print(e, "delete 5 left of cursor");

        e.undo();
        print(e, "undo");

        e.undo();
        print(e, "undo");

        e.redo();
        print(e, "redo");

        e.insert("!");
        print(e, "insert '!' (redo stack now cleared)");
    }

    private static void print(TextEditor e, String label) {
        System.out.println(label + " -> \"" + e.getContent() + "\" cursor=" + e.getCursor());
    }
}
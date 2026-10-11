import java.util.*; // for Stack

public class TextEditor {
    private String currentText;
    private Stack<String> undoStack;

    public TextEditor() {
        currentText = "";
        undoStack = new Stack<>();
    }

    // Method to add texts
    public void addText(String text) {
        // Save current state before changing it
        undoStack.push(currentText);

        currentText += text;
    }

    // Method to undo the last action
    public void undo() {
        if (!undoStack.isEmpty()) {
            currentText = undoStack.pop();   // restore previous state
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    // Method to display the current text
    public String getCurrentText() {
        return currentText;
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.addText("Hello, ");
        System.out.println("Current Text: " + editor.getCurrentText());

        editor.addText("World!");
        System.out.println("Current Text: " + editor.getCurrentText());

        editor.undo();
        System.out.println("After Undo: " + editor.getCurrentText());

        editor.undo();
        System.out.println("After Undo: " + editor.getCurrentText());

        editor.undo(); // Attempting to undo when there's nothing to undo
    }
}


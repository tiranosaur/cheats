package org.example.gof.behavior;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;

// Фиксирует и хранит текущее состояние объекта, чтобы оно легко восстанавливалось. Класс для хранения состояния
public class Memento {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        TextEditorCaretaker caretaker = new TextEditorCaretaker();

        editor.setContent("Version 1");
        caretaker.save(editor);
        System.out.println("Content after first save: " + editor.getContent());

        editor.setContent("Version 2");
        caretaker.save(editor);
        System.out.println("Content after second save: " + editor.getContent());

        editor.setContent("Version 3");
        System.out.println("Content before undo: " + editor.getContent());

        caretaker.undo(editor);
        System.out.println("Content after first undo: " + editor.getContent());

        caretaker.undo(editor);
        System.out.println("Content after second undo: " + editor.getContent());
    }
}

@AllArgsConstructor
@Getter
class TextEditorMemento {
    private final String state;
}

@Getter
@Setter
class TextEditor {
    private String content;

    public TextEditorMemento save() {
        return new TextEditorMemento(content);
    }

    public void restore(TextEditorMemento memento) {
        content = memento.getState();
    }
}

class TextEditorCaretaker {
    private final LinkedList<TextEditorMemento> history = new LinkedList<>();

    public void save(TextEditor editor) {
        history.push(editor.save());
    }

    public void undo(TextEditor editor) {
        if (!history.isEmpty()) {
            editor.restore(history.removeLast());
        } else {
            System.out.println("No states to undo.");
        }
    }
}

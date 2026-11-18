package ru.mirea.work2.patterns;

import java.util.ArrayDeque;
import java.util.Deque;

public class UndoStringBuilder {
    private final StringBuilder value = new StringBuilder();
    private final Deque<Command> history = new ArrayDeque<>();

    private interface Command {
        void undo();
    }

    private class SaveTextCommand implements Command {
        private final String previousText;

        SaveTextCommand(String previousText) {
            this.previousText = previousText;
        }

        public void undo() {
            value.setLength(0);
            value.append(previousText);
        }
    }

    private void save() {
        history.push(new SaveTextCommand(value.toString()));
    }

    public UndoStringBuilder append(String text) {
        save();
        value.append(text);
        return this;
    }

    public UndoStringBuilder insert(int index, String text) {
        save();
        value.insert(index, text);
        return this;
    }

    public UndoStringBuilder delete(int start, int end) {
        save();
        value.delete(start, end);
        return this;
    }

    public UndoStringBuilder replace(int start, int end, String text) {
        save();
        value.replace(start, end, text);
        return this;
    }

    public UndoStringBuilder reverse() {
        save();
        value.reverse();
        return this;
    }

    public boolean undo() {
        if (history.isEmpty()) {
            return false;
        }
        history.pop().undo();
        return true;
    }

    public String toString() {
        return value.toString();
    }

    public static void main(String[] args) {
        UndoStringBuilder text = new UndoStringBuilder();
        text.append("Hello");
        text.append(" world");
        text.reverse();
        System.out.println(text);
        text.undo();
        System.out.println(text);
    }
}

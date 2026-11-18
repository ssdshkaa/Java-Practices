package ru.mirea.work2.patterns;

import java.util.ArrayList;
import java.util.List;

public class ObservableStringBuilder {
    private final StringBuilder value = new StringBuilder();
    private final List<StringListener> listeners = new ArrayList<>();

    public void subscribe(StringListener listener) {
        listeners.add(listener);
    }

    public void unsubscribe(StringListener listener) {
        listeners.remove(listener);
    }

    public ObservableStringBuilder append(String text) {
        value.append(text);
        notifyListeners();
        return this;
    }

    public ObservableStringBuilder insert(int index, String text) {
        value.insert(index, text);
        notifyListeners();
        return this;
    }

    public ObservableStringBuilder delete(int start, int end) {
        value.delete(start, end);
        notifyListeners();
        return this;
    }

    public ObservableStringBuilder replace(int start, int end, String text) {
        value.replace(start, end, text);
        notifyListeners();
        return this;
    }

    public ObservableStringBuilder reverse() {
        value.reverse();
        notifyListeners();
        return this;
    }

    private void notifyListeners() {
        String currentText = value.toString();
        List<StringListener> copy = new ArrayList<>(listeners);
        for (StringListener listener : copy) {
            listener.textChanged(currentText);
        }
    }

    public String toString() {
        return value.toString();
    }

    public static void main(String[] args) {
        ObservableStringBuilder text = new ObservableStringBuilder();
        PrintStringListener listener = new PrintStringListener();
        text.subscribe(listener);
        text.append("Привет");
        text.insert(0, "!");
        text.delete(0, 1);
        text.replace(0, 1, "п");
        text.reverse();
        text.unsubscribe(listener);
        text.append("!");
    }
}

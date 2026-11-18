package ru.mirea.work2.shop;

import ru.mirea.pr4.Computer;

public class Shop {
    private Computer[] computers = new Computer[10];
    private int computerCount;

    public void addComputer(Computer computer) {
        if (computerCount == computers.length) {
            Computer[] expanded = new Computer[computers.length * 2];
            System.arraycopy(computers, 0, expanded, 0, computerCount);
            computers = expanded;
        }
        computers[computerCount++] = computer;
    }

    public boolean removeComputer(int index) {
        if (index < 0 || index >= computerCount) return false;
        int moved = computerCount - index - 1;
        if (moved > 0) System.arraycopy(computers, index + 1, computers, index, moved);
        computers[--computerCount] = null;
        return true;
    }

    public boolean removeComputer(Computer computer) {
        for (int i = 0; i < computerCount; i++) {
            if (computers[i] == computer) return removeComputer(i);
        }
        return false;
    }

    public Computer findComputer(String text) {
        if (text == null) return null;
        String query = text.toLowerCase();
        for (int i = 0; i < computerCount; i++) {
            if (computers[i].toString().toLowerCase().contains(query)) return computers[i];
        }
        return null;
    }

    public Computer getComputer(int index) {
        if (index < 0 || index >= computerCount) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        return computers[index];
    }

    public int getComputerCount() {
        return computerCount;
    }
}

package ru.mirea.pr4;
public class Monitor {
    private double diagonal;
    public Monitor(double diagonal) { this.diagonal = diagonal; }
    public double getDiagonal() { return diagonal; }
    public void setDiagonal(double diagonal) { this.diagonal = diagonal; }
    @Override public String toString() { return diagonal + " дюймов"; }
}

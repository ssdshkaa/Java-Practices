package ru.mirea.pr4;
public class Processor {
    private String model;
    private int frequency;
    public Processor(String model, int frequency) { this.model = model; this.frequency = frequency; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public int getFrequency() { return frequency; }
    public void setFrequency(int frequency) { this.frequency = frequency; }
    @Override public String toString() { return model + ", " + frequency + " МГц"; }
}

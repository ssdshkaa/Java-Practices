package ru.mirea.work2.strings;
public class ProcessStrings implements StringProcessor {
    @Override
    public int count(String text) {
        return text.length();
    }

    @Override
    public String oddPositions(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i += 2) {
            result.append(text.charAt(i));
        }
        return result.toString();
    }

    @Override
    public String reverse(String text) {
        return new StringBuilder(text).reverse().toString();
    }

    public static void main(String[] args) {
        StringProcessor processor = new ProcessStrings();
        System.out.println(processor.count("hello"));
        System.out.println(processor.oddPositions("hello"));
        System.out.println(processor.reverse("hello"));
    }
}

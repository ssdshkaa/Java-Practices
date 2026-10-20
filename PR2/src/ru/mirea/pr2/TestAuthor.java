package ru.mirea.pr2;

public class TestAuthor {
    public static void main(String[] args) {
        Author author = new Author("Tan Ah Teck", "ahTeck@somewhere.com", 'M');
        System.out.println(author);
        System.out.println(author.getName());
        System.out.println(author.getEmail());
        System.out.println(author.getGender());
        author.setEmail("tan@somewhere.com");
        System.out.println(author);
    }
}

package ru.mirea.pr2;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    String name;
    double grade;
    private Date birthDate;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public Student(String name, double grade, Date birthDate) {
        this(name, grade);
        this.birthDate = birthDate;
    }

    public Date getBirthDate() { return birthDate; }
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }
    public String getBirthDateString(String pattern) {
        if (birthDate == null) return "Дата рождения не указана";
        return new SimpleDateFormat(pattern).format(birthDate);
    }

    public void printBirthDate() {
        if (birthDate == null) { System.out.println("Дата рождения не указана"); return; }
        DateFormat shortFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        DateFormat mediumFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
        DateFormat fullFormat = new SimpleDateFormat("EEEE, d MMMM yyyy 'года'");
        System.out.println(shortFormat.format(birthDate));
        System.out.println(mediumFormat.format(birthDate));
        System.out.println(fullFormat.format(birthDate));
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', grade=" + grade
                + ", birthDate='" + getBirthDateString("dd.MM.yyyy") + "'}";
    }

    public void printGrade() {
        System.out.println(grade);
    }
}

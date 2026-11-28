package ru.mirea.work3.part3;

public class NestedClassesDemo {
    private String message = "Поле внешнего объекта";

    // Статический вложенный класс создаётся без внешнего объекта.
    static class Nested {
        void print() {
            System.out.println("Статический вложенный класс");
        }
    }

    // Внутренний класс связан с объектом и видит его private-поле.
    class Inner {
        void print() {
            System.out.println(message);
        }
    }

    void demonstrate() {
        // Локальный класс виден только внутри этого метода.
        class Local {
            void print() {
                System.out.println("Локальный класс: " + message);
            }
        }
        new Local().print();
        // Анонимный класс реализует интерфейс без отдельного имени.
        Runnable action = new Runnable() {
            @Override
            public void run() {
                System.out.println("Анонимный класс: " + message);
            }
        };
        action.run();
    }

    public static void main(String[] args) {
        new Nested().print();
        NestedClassesDemo outer = new NestedClassesDemo();
        Inner inner = outer.new Inner();
        inner.print();
        outer.demonstrate();
    }
}

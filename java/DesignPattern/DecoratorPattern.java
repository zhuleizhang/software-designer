package DesignPattern;

public class DecoratorPattern {
    public static void main(String[] args) {
        System.out.println("DesignPattern DecoratorPattern start");

        Person student = new Student("张三");
        student = new DecoratorA(student);
        student = new DecoratorB(student);
        student.operation();
    }
}

abstract class Person {
    protected String name;

    abstract void operation();
}

class Student extends Person {
    public Student(String name) {
        this.name = name;
    }

    @Override
    void operation() {
        System.out.println("学习");
    }
}

abstract class Decorator extends Person {
    protected Person person;

    abstract void operation();
}

class DecoratorA extends Decorator {
    public DecoratorA(Person person) {
        this.person = person;
    }

    @Override
    void operation() {
        person.operation();
        System.out.println("吃饭");
    }
}

class DecoratorB extends Decorator {
    public DecoratorB(Person person) {
        this.person = person;
    }

    @Override
    void operation() {
        person.operation();
        System.out.println("睡觉");
    }
}
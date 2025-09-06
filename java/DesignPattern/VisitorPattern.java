package DesignPattern;

import java.util.ArrayList;

public class VisitorPattern {
    public static void main(String[] args) {
        VisitorPersonStructure structure = new VisitorPersonStructure();

        Visitor1 visitor1 = new Visitor1();
        structure.accept(visitor1);
        System.out.println("老师和学生的年龄总和: " + visitor1.getAgeSum());

        Visitor2 visitor2 = new Visitor2();
        structure.accept(visitor2);
        System.out.println("教师最大年龄: " + visitor2.getTeacherMaxAge());
        System.out.println("学生最大年龄: " + visitor2.getStudentMaxAge());
    }
}

abstract class VisitorPerson {
    protected String name;
    protected int age;

    public VisitorPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    abstract void accept(InnerVisitor visitor);
}

class VisitorStudent extends VisitorPerson {
    public VisitorStudent(String name, int age) {
        super(name, age);
    }

    @Override
    public void accept(InnerVisitor visitor) {
        visitor.visitStudent(this);
    }
}

class VisitorTeacher extends VisitorPerson {
    public VisitorTeacher(String name, int age) {
        super(name, age);
    }

    @Override
    public void accept(InnerVisitor visitor) {
        visitor.visitTeacher(this);
    }
}

interface InnerVisitor {
    public void visitStudent(VisitorStudent student);

    public void visitTeacher(VisitorTeacher teacher);

}

class Visitor1 implements InnerVisitor {
    private int ageSum;

    public int getAgeSum() {
        return this.ageSum;
    }

    @Override
    public void visitStudent(VisitorStudent student) {
        this.ageSum += student.age;
    }

    @Override
    public void visitTeacher(VisitorTeacher teacher) {
        this.ageSum += teacher.age;
    }
}

class Visitor2 implements InnerVisitor {
    private int teacherMaxAge;
    private int studentMaxAge;

    public int getTeacherMaxAge() {
        return this.teacherMaxAge;
    }

    public int getStudentMaxAge() {
        return this.studentMaxAge;
    }

    @Override
    public void visitStudent(VisitorStudent student) {
        this.studentMaxAge = Math.max(this.studentMaxAge, student.age);
    }

    @Override
    public void visitTeacher(VisitorTeacher teacher) {
        this.teacherMaxAge = Math.max(this.teacherMaxAge, teacher.age);
    }
}

class VisitorPersonStructure {
    private ArrayList<VisitorPerson> persons = new ArrayList<>();

    public VisitorPersonStructure() {
        persons.add(new VisitorStudent("张三", 18));
        persons.add(new VisitorStudent("李四", 19));
        persons.add(new VisitorTeacher("王五", 30));
        persons.add(new VisitorTeacher("赵六", 55));
    }

    public void accept(InnerVisitor visitor) {
        for (VisitorPerson person : persons) {
            person.accept(visitor);
        }
    }

}
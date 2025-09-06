package DesignPattern;

public class TemplateMethodPattern {

    public static void main(String[] args) {
        TemplateMethod templateMethod = new TemplateMethodStudent();
        templateMethod.templateMethod();

        System.out.println("----------------");
        templateMethod = new TemplateMethodTeacher();
        templateMethod.templateMethod();
    }

}

abstract class TemplateMethod {
    abstract void doSomething1();

    abstract void doSomething2();

    public void templateMethod() {
        System.out.println("上课时间到");
        this.doSomething1();
        System.out.println("下课时间到");
        this.doSomething2();
    }
}

class TemplateMethodStudent extends TemplateMethod {
    public void doSomething1() {
        System.out.println("学生要：听课、学习、记笔记");
    }

    public void doSomething2() {
        System.out.println("学生要：休息、复习");
    }
}

class TemplateMethodTeacher extends TemplateMethod {
    public void doSomething1() {
        System.out.println("学生要：讲课");
    }

    public void doSomething2() {
        System.out.println("学生要：休息、准备下一节课");
    }
}
class Student extends Person {

    @Override
    public void sayHello() {
        System.out.println("Hello, iam a student, my name is " + getName() + " and I am " + getAge() + " years old.");
    }
}
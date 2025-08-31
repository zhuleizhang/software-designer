public class Main {
  public static void main(String[] args) {
    int a = 10;
    int b = 20;
    int c = a + b;
    System.out.println(c);

    Person p = new Person();
    p.setName("张三");
    p.setAge(18);
    p.sayHello();
    System.out.println(p.getAge());

    Student s = new Student();
    s.setName("李四");
    s.setAge(18);
    s.sayHello();
    System.out.println(s.getAge());

  }
}
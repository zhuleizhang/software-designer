package DesignPattern;

public class Singleton {

    public static void main(String[] args) {
        InnerSingleton singleton1 = InnerSingleton.getInstance();
        InnerSingleton singleton2 = InnerSingleton.getInstance();
        InnerSingleton singleton3 = InnerSingleton.getInstance();
        System.out.println(singleton1 == singleton2);
        System.out.println(singleton2 == singleton3);
        System.out.println(singleton1 == singleton3);
        System.out.println(Integer.toHexString(System.identityHashCode(singleton1)));
        System.out.println(Integer.toHexString(System.identityHashCode(singleton2)));
        System.out.println(Integer.toHexString(System.identityHashCode(singleton3)));
    }

}

class InnerSingleton {
    private static InnerSingleton instance = new InnerSingleton();

    private InnerSingleton() {
    }

    public static InnerSingleton getInstance() {
        return instance;
    }
}

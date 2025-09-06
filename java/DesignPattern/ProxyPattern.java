package DesignPattern;

public class ProxyPattern {

    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        Subject proxy = new ProxySubject(realSubject);
        proxy.buy();

    }

}

interface Subject {
    public void buy();
}

class ProxySubject implements Subject {
    private RealSubject realSubject;

    public ProxySubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void buy() {
        System.out.println("ProxySubject buy before");
        this.realSubject.buy();
        System.out.println("ProxySubject buy after");
    }

}

class RealSubject implements Subject {
    @Override
    public void buy() {
        System.err.println("RealSubject buy");
    }
}

// package DesignPattern;

// public class ProxyPattern {

// public static void main(String[] args) {
// InnerInterface proxy = new ProxySubject();
// proxy.methodA();

// // Subject subject = new RealSubject();
// }

// }

// abstract class Subject {
// public abstract void request();

// public String get() {
// return "";
// }
// }

// interface Proxy {
// public void get();
// }

// class RealProxy implements Proxy {
// public void get() {
// System.out.println("RealProxy get");
// }

// }

// class RealSubject extends Subject {
// @Override
// public void request() {
// System.err.println("RealSubject request");
// }
// }

// class ProxySubject implements InnerInterface {

// @Override
// public void methodA() {
// System.out.println("ProxySubject methodA");
// }
// }
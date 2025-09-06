package DesignPattern;

import java.util.ArrayList;

public class ObserverPattern {

    public static void main(String[] args) {
        ObserverSubject subject = new ConcreteObserverSubject();

        Observer observer1 = new Observer("张三", subject);
        Observer observer2 = new Observer("李四", subject);
        subject.attach(observer1);
        subject.attach(observer2);

        subject.setState("状态1");

        subject.detach(observer1);

        subject.setState("状态2");
    }

}

interface ObserverSubject {
    public void attach(Observer observer);

    public void detach(Observer observer);

    public void notifyObservers();

    public String getState();

    public void setState(String state);
}

class ConcreteObserverSubject implements ObserverSubject {
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    private String state;

    public ConcreteObserverSubject() {
        this.state = "初始状态";
    }

    @Override
    public void setState(String state) {
        this.state = state;
        this.notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public String getState() {
        return this.state;
    }
}

class Observer {
    private String name;
    private String state;
    private ObserverSubject subject;

    public Observer(String name, ObserverSubject subject) {
        this.name = name;
        this.subject = subject;
    }

    public void update() {
        this.state = this.subject.getState();
        System.out.println(this.name + " 收到更新，状态为：" + this.state);
    }
}
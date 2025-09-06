package DesignPattern;

import java.util.List;
import java.util.ArrayList;

public class MementoPattern {

    public static void main(String[] args) {
        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator();

        originator.setState("状态1");
        Memento memento = originator.createMemento();
        caretaker.addMemento(memento);

        originator.setState("状态2");
        memento = originator.createMemento();
        caretaker.addMemento(memento);

        originator.setState("状态3");
        memento = originator.createMemento();
        caretaker.addMemento(memento);

        caretaker.showMementos();

        System.out.println(originator.getState());

        System.out.println("恢复到第2次备份的状态");
        originator.setMemento(caretaker.getMemento(2));
        System.out.println(originator.getState());
    }
}

class Originator {
    private String state;

    public Memento createMemento() {
        return new Memento(this.state);
    }

    public void setMemento(Memento memento) {
        this.state = memento.getState();
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }

}

class Caretaker {
    private List<Memento> mementos = new ArrayList<>();

    public void addMemento(Memento memento) {
        mementos.add(memento);
    }

    public Memento getMemento(int index) {
        if (index < 1 || index > mementos.size()) {
            return null;
        }
        return mementos.get(index - 1);
    }

    public void showMementos() {
        for (int i = 0; i < mementos.size(); i++) {
            System.out.println("第" + (i + 1) + "次备份的内容为：" + mementos.get(i).getState());
        }
    }
}
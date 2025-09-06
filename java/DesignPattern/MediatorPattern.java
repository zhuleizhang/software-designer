package DesignPattern;

public class MediatorPattern {
    public static void main(String[] args) {
        ColleagueMediator mediator = new ColleagueMediator();
        Colleague1 colleague1 = new Colleague1(mediator);
        Colleague2 colleague2 = new Colleague2(mediator);

        mediator.setColleague1(colleague1);
        mediator.setColleague2(colleague2);

        colleague1.sendMessage("考试加油～");
        colleague2.sendMessage("成功上岸～");
    }
}

interface Mediator {
    void sendMessage(String message, Colleague colleague);
}

abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public void sendMessage(String message) {
        mediator.sendMessage(message, this);
    }

    public abstract void receiveMessage(String message);
}

class Colleague1 extends Colleague {
    public Colleague1(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Colleague1 收到消息：" + message);
    }

    public void sendMessage(String message) {
        System.out.println("Colleague1 发送消息：" + message);
        super.sendMessage(message);
    }
}

class Colleague2 extends Colleague {
    public Colleague2(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Colleague2 收到消息：" + message);
    }

    public void sendMessage(String message) {
        System.out.println("Colleague2 发送消息：" + message);
        super.sendMessage(message);
    }
}

class ColleagueMediator implements Mediator {
    private Colleague1 colleague1;
    private Colleague2 colleague2;

    public void setColleague1(Colleague1 colleague1) {
        this.colleague1 = colleague1;
    }

    public void setColleague2(Colleague2 colleague2) {
        this.colleague2 = colleague2;
    }

    @Override
    public void sendMessage(String message, Colleague colleague) {
        if (colleague == this.colleague1) {
            this.colleague2.receiveMessage(message);
        } else if (colleague == this.colleague2) {
            this.colleague1.receiveMessage(message);
        }
    }
}

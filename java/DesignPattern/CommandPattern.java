package DesignPattern;

public class CommandPattern {
    public static void main(String[] args) {
        Tv tv = new Tv();

        Command onCommand = new OnCommand(tv);
        Command offCommand = new OffCommand(tv);

        Invoker invoker = new Invoker();
        invoker.setCommand(onCommand);
        invoker.call();

        System.out.println("------------------");
        invoker.setCommand(offCommand);
        invoker.call();
    }

}

class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void call() {
        command.execute();
    }
}

interface Command {
    public void execute();
}

class Tv {
    public void on() {
        System.out.println("Tv is on");
    }

    public void off() {
        System.out.println("Tv is off");
    }
}

class OnCommand implements Command {
    private Tv tv;

    public OnCommand(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.on();
    }
}

class OffCommand implements Command {
    private Tv tv;

    public OffCommand(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.off();
    }
}
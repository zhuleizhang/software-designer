package DesignPattern;

public class StatePattern {
    public static void main(String[] args) {
        MachineContext context = new MachineContext();
        context.request();
        context.request();
        context.request();
        context.request();
        context.request();
        context.request();
    }
}

interface StatePatternState {
    public void handle(MachineContext context);
}

class ConcreteStateA implements StatePatternState {
    @Override
    public void handle(MachineContext context) {
        int count = context.getCount();
        if (count > 0) {
            System.out.println("购买成功，库存减1");
            context.setCount(count - 1);
        } else {
            System.out.println("库存不足，等待补货");
            context.setState(new ConcreteStateB());
        }
    }
}

class ConcreteStateB implements StatePatternState {
    @Override
    public void handle(MachineContext context) {
        int count = context.getCount();
        if (count <= 0) {
            context.setCount(5);
            System.out.println("补货成功，切换到状态A");
            context.setState(new ConcreteStateA());
        } else {
            System.out.println("无需补货");
        }
    }
}

class MachineContext {
    private int count = 0;
    private StatePatternState state;

    public MachineContext() {
        this.count = 3;
        this.state = new ConcreteStateA();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void request() {
        this.state.handle(this);
    }

    public void setState(StatePatternState state) {
        this.state = state;
    }
}
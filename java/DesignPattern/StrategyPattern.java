package DesignPattern;

public class StrategyPattern {
    public static void main(String[] args) {
        StrategyContext context = new StrategyContext(new AddStrategy());
        context.doStrategy(1, 2);
        context = new StrategyContext(new ReduceStrategy());
        context.doStrategy(4, 2);
    }

}

class StrategyContext {
    private StrategyOfNumber strategy;

    public StrategyContext(StrategyOfNumber strategy) {
        this.strategy = strategy;
    }

    public void doStrategy(int a, int b) {
        strategy.doTwoNumberOperation(a, b);
    }
}

interface StrategyOfNumber {
    public void doTwoNumberOperation(int a, int b);
}

class AddStrategy implements StrategyOfNumber {
    @Override
    public void doTwoNumberOperation(int a, int b) {
        System.out.println("a + b = " + (a + b));
    }
}

class ReduceStrategy implements StrategyOfNumber {
    @Override
    public void doTwoNumberOperation(int a, int b) {
        System.out.println("a - b = " + (a - b));
    }
}

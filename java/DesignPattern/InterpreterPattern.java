package DesignPattern;

import java.util.HashSet;
import java.util.Set;

public class InterpreterPattern {

    public static void main(String[] args) {
        Context context = new Context();
        context.check("A区的测试人员");
        context.check("B区的开发人员");
        context.check("C区的运维人员");
        System.out.println("------------------");
        context.check("D区的测试人员");
        context.check("A区的销售人员");
    }
}

class Context {
    private String[] regions = { "A区", "B区", "C区" };
    private String[] persons = { "测试人员", "开发人员", "运维人员" };

    private TerminalExpression regionExpression;
    private TerminalExpression personExpression;
    private NonTerminalExpression nonTerminalExpression;

    public Context() {
        regionExpression = new TerminalExpression(regions);
        personExpression = new TerminalExpression(persons);
        nonTerminalExpression = new NonTerminalExpression(regionExpression, personExpression);
    }

    public void check(String info) {
        boolean result = nonTerminalExpression.Interpret(info);

        if (result) {
            System.out.println("识别成功");
        } else {
            System.out.println("识别失败");
        }
    }

}

interface Expression {
    boolean Interpret(String info);
}

class TerminalExpression implements Expression {
    private Set<String> set = new HashSet<String>();

    public TerminalExpression(String[] data) {
        for (String item : data) {
            set.add(item);
        }
    }

    @Override
    public boolean Interpret(String info) {
        return set.contains(info);
    }
}

class NonTerminalExpression implements Expression {
    private TerminalExpression region;
    private TerminalExpression person;

    public NonTerminalExpression(TerminalExpression region, TerminalExpression person) {
        this.region = region;
        this.person = person;
    }

    @Override
    public boolean Interpret(String info) {
        String[] strList = info.split("的");
        return region.Interpret(strList[0]) && person.Interpret(strList[1]);
    }

}
package DesignPattern;

public class FacadePattern {
    public static void main(String[] args) {
        System.out.println("DesignPattern FacadePattern start");
        MainSystem mainSystem = new MainSystem();
        mainSystem.methodA();
        mainSystem.methodB();
        mainSystem.methodC();

    }

}

class MainSystem {
    private SubSystemA subSystemA = new SubSystemA();
    private SubSystemB subSystemB = new SubSystemB();
    private SubSystemC subSystemC = new SubSystemC();

    public MainSystem() {
        this.subSystemA = new SubSystemA();
        this.subSystemB = new SubSystemB();
        this.subSystemC = new SubSystemC();
    }

    public void methodA() {
        subSystemA.methodA();
    }

    public void methodB() {
        subSystemB.methodB();
    }

    public void methodC() {
        subSystemC.methodC();
    }
}

class SubSystemA {
    public void methodA() {
        System.out.println("SubSystemA methodA");
    }
}

class SubSystemB {
    public void methodB() {
        System.out.println("SubSystemB methodB");
    }
}

class SubSystemC {
    public void methodC() {
        System.out.println("SubSystemC methodC");
    }
}
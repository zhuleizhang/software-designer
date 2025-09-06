package DesignPattern;

public class ChainOfResponsibility {
    public static void main(String[] args) {
        Handler counsellor = new Counsellor();
        Handler dean = new Dean();
        Handler headmaster = new Headmaster();

        counsellor.setSuccessor(dean);
        dean.setSuccessor(headmaster);

        counsellor.handleRequest(16);
    }
}

abstract class Handler {
    protected Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    abstract void handleRequest(int request);
}

class Counsellor extends Handler {

    @Override
    public void handleRequest(int request) {
        if (request <= 7) {
            System.out.println("辅导员已批假");
        } else {
            Handler next = this.successor;
            if (next != null) {
                next.handleRequest(request);
            } else {
                System.out.println("辅导员无法批假");
            }
        }
    }
}

class Dean extends Handler {

    @Override
    public void handleRequest(int request) {
        if (request <= 15) {
            System.out.println("院长已批假");
        } else {
            Handler successor = this.successor;
            if (successor != null) {
                successor.handleRequest(request);
            } else {
                System.out.println("院长无法批假");
            }
        }
    }
}

class Headmaster extends Handler {

    @Override
    public void handleRequest(int request) {
        if (request <= 30) {
            System.out.println("校长已批假");
        } else {
            Handler successor = this.successor;
            if (successor != null) {
                successor.handleRequest(request);
            } else {
                System.out.println("校长无法批假");
            }
        }
    }
}
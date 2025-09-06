package DesignPattern;

import java.util.HashMap;
import java.util.Map;

public class FlyweightPattern {
    public static void main(String[] args) {
        System.out.println("DesignPattern FlyweightPattern start");

        FlyweightFactory factory = new FlyweightFactory();
        Piece whitePiece1 = factory.getPiece("white");
        whitePiece1.draw(1, 1);
        Piece blackPiece1 = factory.getPiece("black");
        blackPiece1.draw(2, 2);
        Piece whitePiece2 = factory.getPiece("white");
        whitePiece2.draw(3, 3);
        System.out.println(whitePiece1 == whitePiece2);
        System.out.println(blackPiece1 == factory.getPiece("black"));
    }
}

class FlyweightFactory {
    protected Map<String, Piece> pieces = new HashMap<>();

    public FlyweightFactory() {
        pieces.put("white", new WhitePiece());
        pieces.put("black", new BlackPiece());
    }

    public Piece getPiece(String color) {
        return pieces.get(color);
    }

}

interface Piece {
    public abstract void draw(int x, int y);
}

class WhitePiece implements Piece {
    @Override
    public void draw(int x, int y) {
        System.out.println("WhitePiece draw at " + x + ", " + y);
    }
}

class BlackPiece implements Piece {
    @Override
    public void draw(int x, int y) {
        System.out.println("BlackPiece draw at " + x + ", " + y);
    }
}

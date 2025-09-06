package DesignPattern;

import java.util.ArrayList;

public class IteratorPattern {

    public static void main(String[] args) {
        BookAggregate aggregate = new BookAggregate();
        aggregate.addBook(new IteratorPatternBook("设计模式", 80));
        aggregate.addBook(new IteratorPatternBook("Head First 设计模式", 90));
        aggregate.addBook(new IteratorPatternBook("Effective Java", 100));

        Iterator iterator = aggregate.createIterator();
        while (!iterator.isDone()) {
            IteratorPatternBook book = (IteratorPatternBook) iterator.currentItem();
            System.out.println(book.getName() + " " + book.getPrice());
            iterator.next();
        }
    }

}

interface Iterator {
    public void first();

    public void next();

    public boolean isDone();

    public Object currentItem();
}

interface Aggregate {
    public Iterator createIterator();
}

class IteratorPatternBook {
    private String name;
    private double price;

    public IteratorPatternBook(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class BookIterator implements Iterator {
    private BookAggregate aggregate;
    private int index = 0;

    public BookIterator(BookAggregate aggregate) {
        this.aggregate = aggregate;
    }

    @Override
    public void first() {
        index = 0;
    }

    @Override
    public void next() {
        index++;
    }

    @Override
    public boolean isDone() {
        return index >= aggregate.getSize();
    }

    @Override
    public Object currentItem() {
        return aggregate.getItem(index);
    }
}

class BookAggregate implements Aggregate {
    private ArrayList<IteratorPatternBook> books = new ArrayList<>();
    private int count = 0;

    public void addBook(IteratorPatternBook book) {
        this.books.add(book);
        this.count++;
    }

    public int getSize() {
        return count;
    }

    public IteratorPatternBook getItem(int index) {
        return books.get(index);
    }

    @Override
    public Iterator createIterator() {
        return new BookIterator(this);
    }
}
// package DesignPattern;

// public class FactoryMethod {
// public static void main(String[] args) {
// ProductFactory factoryA = new ProductAFactory();
// Product productA = factoryA.createProduct();
// productA.show();

// ProductFactory factoryB = new ProductBFactory();
// Product productB = factoryB.createProduct();
// productB.show();
// }
// }

// interface ProductFactory {
// public Product createProduct();
// }

// class ProductAFactory implements ProductFactory {

// @Override
// public Product createProduct() {
// return new ProductA();
// }
// }

// class ProductBFactory implements ProductFactory {

// @Override
// public Product createProduct() {
// return new ProductB();
// }
// }

// interface Product {
// public void show();
// }

// class ProductA implements Product {

// public void show() {
// System.out.println("ProductA");
// }
// }

// class ProductB implements Product {

// public void show() {
// System.out.println("ProductB");
// }
// }
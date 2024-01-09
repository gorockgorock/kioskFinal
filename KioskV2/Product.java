package KioskV2;

public class Product extends Menu {
    protected double price;

    public double getPrice() {
        return this.price;
    }

    public Product(String name, String description, double price) {
        super.name = name;
        super.description = description;
        this.price = price;

    }
}
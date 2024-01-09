package KioskV2;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> orderList = new ArrayList<>();
    private int orderNumber = 1;

    public Cart() {}

    public Cart(List<Product> orderList) {
        this.orderList = orderList;
    }
    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Product order : orderList) {
            totalPrice += order.getPrice();
        }
        return totalPrice;
    }
    public List<Product> getOrderList() {
        return orderList;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOderNumber (int orderNumber) {
        this.orderNumber = orderNumber ;
    }

    public void addOrder(Product order) {
        orderList.add(order);
    }

    public void removeOrder(Product order) {orderList.remove(order);
   }

    public void clear() {
        orderList.clear();
    }



}

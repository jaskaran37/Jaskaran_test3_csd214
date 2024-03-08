package com.example.jaskaran_test3_sem3;

public class storeorder {
    private int orderId;
    private String customerName;
    private String mobileNumber;
    private String pizzaSize;
    private int numToppings;
    private double totalBill;

    public storeorder(int orderId, String customerName, String mobileNumber, String pizzaSize, int numToppings, double totalBill) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.mobileNumber = mobileNumber;
        this.pizzaSize = pizzaSize;
        this.numToppings = numToppings;
        this.totalBill = totalBill;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public int getNumToppings() {
        return numToppings;
    }

    public double getTotalBill() {
        return totalBill;
    }
}


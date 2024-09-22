package com.SpringCourse.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {

    @JsonProperty("id") // use this to identify the field from the json body if  the names are different
    private int orderID;
    private String orderName;
    private int orderQuatity;

    public int getOrderID() {
        return orderID;
    }

    public String getOrderName() {
        return orderName;
    }

    public int getOrderQuatity() {
        return orderQuatity;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public void setOrderQuatity(int orderQuatity) {
        this.orderQuatity = orderQuatity;
    }


    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }


    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", orderName='" + orderName + '\'' +
                ", orderQuatity=" + orderQuatity +
                '}';
    }
}

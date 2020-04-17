package com.example.dubstep.Model;

public class OrderItem
{
    String Phone_Number;
    double Latitude;
    double Longitude;
    String CartTotalAmount;
    String Status;

    public OrderItem()
    {

    }
    public OrderItem(String phone_number, double latitude, double longitude, String cartTotal,String status)
    {
        Phone_Number = phone_number;
        Latitude = latitude;
        Longitude = longitude;
        CartTotalAmount = cartTotal;
        Status = status;
    }

    public String getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(String phone_number) {
        Phone_Number = phone_number;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }

    public String getCartTotalAmount() {
        return CartTotalAmount;
    }

    public void setCartTotal(String cartTotal) {
        this.CartTotalAmount = cartTotal;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}

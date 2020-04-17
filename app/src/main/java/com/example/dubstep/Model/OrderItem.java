package com.example.dubstep.Model;

public class OrderItem
{
    String Phone_Number;
    double Latitude;
    double Longitude;
    String CartTotalAmount;
    public OrderItem()
    {

    }
    public OrderItem(String phone_number, double latitude, double longitude, String cartTotal)
    {
        Phone_Number = phone_number;
        Latitude = latitude;
        Longitude = longitude;
        CartTotalAmount = cartTotal;
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

}

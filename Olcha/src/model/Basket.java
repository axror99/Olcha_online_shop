package model;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Basket extends BaseModel {

    private int id;
    private String clientName;
    private String clientUsername;
    private int clientID;
    private int count;
    private double amountALL;
    private double priceForProduct;
    private static int generatedID = 0;
    private String simpleformat;
    private String formatTime;

    public Basket() {
        id = generatedID++;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getSimpleformat() {
        return simpleformat;
    }

    public String getFormatTime() {
        return formatTime;
    }

    public void setSimpleformat(String simpleformat) {
        this.simpleformat = simpleformat;
    }

    public void setFormatTime(String formatTime) {
        this.formatTime = formatTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientUsername() {
        return clientUsername;
    }

    public void setClientUsername(String clientUsername) {
        this.clientUsername = clientUsername;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getAmountALL() {
        return amountALL;
    }

    public void setAmountALL(double amountALL) {
        this.amountALL = amountALL;
    }

    public double getPriceForProduct() {
        return priceForProduct;
    }

    public void setPriceForProduct(double priceForProduct) {
        this.priceForProduct = priceForProduct;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", clientName='" + clientName + '\'' +
                ", clientUsername='" + clientUsername + '\'' +
                ", count=" + count +
                ", amountALL=" + amountALL +
                ", priceForProduct=" + priceForProduct +
                ", simpleformat=" + simpleformat+
                ", formatTime=" + formatTime +
                '}';
    }
}

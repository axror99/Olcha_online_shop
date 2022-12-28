package model;

public class User extends BaseModel {
    private int id;
    private static int generateId=0;
    private String username;
    private double wallet;
    private String who;


    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public User() {
        id=generateId++;
    }

    public User(String name, String username) {
        this();
        this.name = name;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

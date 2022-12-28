package model;

public class Product extends BaseModel {
    private int id;
    private static int generateID = 0;
    private double cost;
    private String about;
    private int catalogueID;
    private int countAdmin;
    private int countUser;
    private int basketID=-1;
    public Product() {
        id = generateID++;
    }

    public int getBasketID() {
        return basketID;
    }

    public void setBasketID(int basketID) {
        this.basketID = basketID;
    }

    public int getCountUser() {
        return countUser;
    }

    public void setCountUser(int countUser) {
        this.countUser = countUser;
    }

    public int getCount() {
        return countAdmin;
    }

    public void setCount(int count) {
        this.countAdmin = count;
    }

    public int getId() {
        return id;
    }

    public int getCatalogueID() {
        return catalogueID;
    }

    public void setCatalogueID(int catalogueID) {
        this.catalogueID = catalogueID;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
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
        return "Product{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", cost=" + cost +
                ", about='" + about + '\'' +
                ", catalogueID=" + catalogueID +
                ", countAdmin=" + countAdmin +
                '}';
    }
}

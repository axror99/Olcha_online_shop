package service;

import model.Basket;
import model.Catalogue;
import model.Product;
import model.User;

import java.util.ArrayList;
import java.util.List;

public interface BaseService {
    List<User>userList=new ArrayList<>();
    List<Product> allProduct =new ArrayList<>();
    List<Catalogue> allCatalogue =new ArrayList<>();
    List<Basket> allBasket = new ArrayList<>();
    List<Basket>basketForUser=new ArrayList<>();

    boolean add(Object o);
    boolean delete(Object o);

}

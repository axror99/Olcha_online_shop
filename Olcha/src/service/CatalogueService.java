package service;

import model.Basket;
import model.Catalogue;
import model.Product;
import model.User;

import java.util.List;

public class CatalogueService implements BaseService {

    @Override
    public boolean add(Object o) {
        Catalogue catalogue = (Catalogue) o;
        for (Catalogue catalogue1 : allCatalogue) {
            if (catalogue1 != null) {
                if (catalogue1.getName().equals(catalogue.getName())) {
                    return false;
                }
            }
        }
        allCatalogue.add(catalogue);
        return true;
    }

    public void showCatalogue(int id) {

        for (Catalogue catalogue : allCatalogue) {
            if (catalogue.getPrenatId() == id)
                System.out.print("-------> " + catalogue.getName() + " <-------");
        }
        System.out.println();
        int count = 1;
        for (Product product : ProductService.allProduct) {
            if (product != null) {
                if (product.getCatalogueID() == id && id != 0) {
                    System.out.println((count) + ")_____");
                    System.out.println(" [*****] " + product.getName());
                    System.out.println(" [*****] $ " + product.getCost());
                    System.out.println(" [*****] INFO:" + product.getAbout());
                    count++;
                }
            }
        }
    }


    public int showCatalogue(String name) {

        for (Catalogue catalogue : allCatalogue) {
            if (catalogue != null) {
                if (catalogue.getName().equals(name)) {
                    showCatalogue(catalogue.getId());
                    return catalogue.getId();
                }
            }
        }
        return -1;
    }


    public void addOrder(int order, int currentCatalogue, User currentUser, BasketService basketService, int number) {
        int count = 1;
        Basket basket=new Basket();
        for (Product product : ProductService.allProduct) {
            if (product != null) {
                if (product.getCatalogueID() == currentCatalogue ) {
                    if (count==order) {
                        basket.setName(product.getName());
                        basket.setClientUsername(currentUser.getUsername());
                        basket.setClientName(currentUser.getName());
                        basket.setCount(number);
                        basket.setPriceForProduct(product.getCost());
                    }

                    count++;
                }
            }
        }
    }


    public void show() {
        for (Catalogue catalogue : allCatalogue) {
            System.out.println(catalogue.toString());
        }
    }

    public Catalogue getCatalogueWitName(String name) {
        for (Catalogue catalogue : allCatalogue) {
            if (catalogue != null) {
                if (catalogue.getName().equals(name)) {
                    return catalogue;
                }
            }
        }
        return null;
    }

    @Override
    public boolean delete(Object o) {
        Catalogue currentCatalogue = (Catalogue) o;
        for (Catalogue catalogue : allCatalogue) {
            if (catalogue != null) {
                if (catalogue.getName().equals(currentCatalogue.getName())) {
                    allCatalogue.remove(catalogue);
                    return true;
                }
            }
        }
        return false;
    }


}

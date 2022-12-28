package service;

import model.Basket;
import model.Product;
import model.User;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BasketService implements BaseService{

    public void addOrder(int order, int currentCatalogue, User currentUser, int number, Basket basket) {
        int count = 1;
        //Basket basket = new Basket();
        for (Product product : ProductService.allProduct) {
            if (product != null) {
                if (product.getCatalogueID() == currentCatalogue) {
                    if (count == order) {
                        Calendar cal = Calendar.getInstance();
                        SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MMMM/yyyy");
                        Format formatTime = new SimpleDateFormat("HH:mm:ss");
                        basket.setSimpleformat(simpleformat.format(cal.getTime()));
                        basket.setFormatTime(formatTime.format(new Date()));
                       // basket.setName(product.getName());
                        product.setBasketID(basket.getId());
                        product.setCountUser(number);

                        basket.setClientUsername(currentUser.getUsername());
                        basket.setClientName(currentUser.getName());
                        basket.setCount(number);
                        basket.setPriceForProduct(product.getCost());
                        basket.setAmountALL(product.getCost() * product.getCount());
                        allBasket.add(basket);
                    }
                    count++;
                }
            }
        }
    }


    public void showOrder() {
        for (Basket basket : allBasket) {
            if (basket != null) {
                System.out.println(basket);
            }
        }
    }

    public void showOrderForUser(String username, String name, int basketID) {

        double allamount = 0;
        for (Basket basket : allBasket) {
            if (basket != null) {
                if (basket.getClientUsername().equals(username)) {
                    System.out.println("<******>  CHECK  <******>");
                    System.out.printf("Name..........= %s%n", basket.getClientName());
                    System.out.printf("Product  name = %s%n", basket.getName());
                    System.out.printf("How many......= %d%n", basket.getCount());
                    System.out.printf("Price.........= $ %f%n", basket.getPriceForProduct());
                    System.out.printf("Today's  time = %s%n", basket.getFormatTime());
                    System.out.printf("Today's  date = %s%n", basket.getSimpleformat());
                    System.out.printf("TOTAL  AMOUNT = $ %s%n", (basket.getCount() * basket.getPriceForProduct()));
                    System.out.println();
                }
            }
        }
        int count=0;
        for (Product product : allProduct) {
            if (product !=null)
            {
                if (product.getBasketID()==basketID)
                {
                    count++;
                }
            }
        }
        if (count>0) {
                        System.out.println("<******>  CHECK  <******>");
                        System.out.printf("Name..........= %s%n", name);
                        System.out.printf("Username......= %s%n", username);
            for (Product product : allProduct) {
                if (product != null) {
                    if (product.getBasketID() == basketID) {
                        System.out.printf("Product  name = %s%n", product.getName());
                        System.out.printf("How many......= %d%n", product.getCountUser());
                        System.out.printf("Price.........= $ %f%n", product.getCost());
                        allamount+=(product.getCost()*product.getCountUser());
                    }
                }
            }
            System.out.println();
            for (Basket basket : allBasket) {
                if (basket != null)
                {
                    if (basket.getId()== basketID)
                    {
                        System.out.printf("Today's  time = %s%n", basket.getFormatTime());
                        System.out.printf("Today's  date = %s%n", basket.getSimpleformat());
                        System.out.printf("TOTAL  AMOUNT = $ %s%n",allamount);
                        System.out.println();
                        break;
                    }
                }

            }

        }
    }
    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean delete(Object o) {
        return false;
    }
}

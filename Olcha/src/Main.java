import dto.CatalogueDto;
import dto.ProductDto;
import dto.UserDto;
import model.Basket;
import model.Catalogue;
import model.User;
import service.*;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class Main {
    static Scanner kiritishInt = new Scanner(System.in);
    static Scanner kiritishStr = new Scanner(System.in);
    static UserServise userservise = new UserServise();
    static CatalogueService catalogueService = new CatalogueService();
    static ProductService productService = new ProductService();
    static BasketService basketService = new BasketService();

    public static void main(String[] args) {
        menu1();
    }

    private static void menu1() {
        int var = 10;
        while (var != 0) {
            System.out.println("|----------------------|");
            System.out.println("|1.Log in    2.Sign Up |");
            System.out.println("|----------------------|");
            var = kiritishInt.nextInt();
            switch (var) {
                case 1 -> logIn();
                case 2 -> signUp();
            }
        }
    }

    private static void signUp() {
        User currentUser = null;
        do {
            System.out.println("Enter  username: ");
            String username = kiritishStr.next();
            if (username.equals("0")) {
                break;
            }
            currentUser = userservise.getUserWithUsername(username);

        } while (currentUser == null);
        if (currentUser != null) {
            if (currentUser.getWho().equals("ADMIN")) {
                adminSHOP();
            }else if (currentUser.getWho().equals("USER"))
            {
                Basket basket = new Basket();
                basket.setClientName(currentUser.getName());
                basket.setClientUsername(currentUser.getUsername());
                basket.setClientID(currentUser.getId());
                int var = 10;
                while (var != 0) {
                    System.out.println("1.SHOP    2.USER's_Order     0.EXIT");
                    var=kiritishInt.nextInt();
                    switch (var)
                    {
                        case 1->userSHOP(currentUser,basket);
                        case 2->basketService.showOrderForUser(currentUser.getUsername(),currentUser.getName(),basket.getId());
                    }

                }
//               BaseService.allBasket.add(basket);
            }
        }
    }

    public static void logIn() {
        int var1 = 10;
        while (var1 != 0) {
            System.out.println("|-------------------------|");
            System.out.println("|1.Admin   2.User  0.Exit |");
            System.out.println("|-------------------------|");
            var1 = kiritishInt.nextInt();
            switch (var1) {
                case 1 -> admin();
                case 2 -> addUser();
            }
        }
    }

    static void addUser() {
        System.out.println(UserDto.userDTO(kiritishStr, userservise));
    }

    static void admin() {
        int var1 = 10;
        while (var1 != 0) {
            System.out.println("|--------------------------------------------|");
            System.out.println("| 1. add Admin    2. Admins'  work   0. Exit |");
            System.out.println("|--------------------------------------------|");
            var1 = kiritishInt.nextInt();
            switch (var1) {
                case 1 -> {
                    System.out.println(UserDto.adminDTO(kiritishStr, userservise));
                }
                case 2 -> {
                    System.out.println("confirm  yourself  as Admin");
                    System.out.print("enter :");
                    String username = kiritishStr.next();

                    User user = UserServise.check(username);
                    if (user != null && user.getWho().equals("ADMIN")) {
                        System.out.println("done successfully");
                        System.out.println("----------------------------------");
                        adminWork();
                    } else {
                        System.out.println("Wrong , Please  try  again");
                    }
                }
            }
        }
    }

    private static void adminWork() {
        int var = 10;
        while (var != 0) {
            System.out.println("|--------------------------------------------------------------|");
            System.out.println("| 1. User      2.Product    3.Catalogue    4.showOrder  0.Exit |");
            System.out.println("|--------------------------------------------------------------|");
            var = kiritishInt.nextInt();
            switch (var) {
                case 1 -> userWork();
                case 2 -> productWork();
                case 3 -> catalogueWork();
                case 4 -> basketService.showOrder();
            }
        }

    }

    private static void userWork() {
        int var = 10;
        while (var != 0) {
            System.out.println("|------------------------------------------------------------|");
            System.out.println("| 1.showAllUsers    2.showDebtUsers    3.deleteUser   0.EXIT |");
            System.out.println("|------------------------------------------------------------|");
            var = kiritishInt.nextInt();
            switch (var) {
                case 1 -> userservise.showUser();
                case 2 -> userservise.showDebtUser();
                case 3 -> {
                    System.out.println("enter username :");
                    String username = kiritishStr.next();
                    User user = UserServise.check(username);
                    if (user != null && (user.getWho() == null)) {
                        System.out.println(userservise.delete(user));
                    } else {
                        System.out.println("Not  found  User");
                    }
                    System.out.println("----------------------------------");
                }
            }
        }
    }

    private static void productWork() {
        int var = 10;
        while (var != 0) {
            System.out.println("|---------------------------------------------------------------------------|");
            System.out.println("| 1.addProduct     2.editProduct  3.deleteProduct   4.showProduct    0.Exit |");
            System.out.println("|-------------------------------------------------------------------------0--|");
            var = kiritishInt.nextInt();
            switch (var) {
                case 1 -> {
                    addProduct();
                }
                // case 3->
                case 4 -> {
                    productService.showAllProduct();
                }
                // case 2->{};
                //case 3->
            }
        }
    }

    private static void catalogueWork() {
        int var = 10;
        while (var != 0) {
            System.out.println("|-------------------------------------------------------------------------|");
            System.out.println("| 1.add_Catalogue       2.show_Catalogue     3.Delete_Catalogue    0.Exit |");
            System.out.println("|-------------------------------------------------------------------------|");
            var = kiritishInt.nextInt();
            switch (var) {
                case 1 -> System.out.println(CatalogueDto.catalogueDto(kiritishStr, catalogueService));
                case 2 -> catalogueService.show();
                case 3 -> deleteCatalogue();
            }
        }
    }

    private static void deleteCatalogue() {
        catalogueService.showCatalogue(0);
        System.out.println("0. EXIT");
        String va1 = "10";
        while (!va1.equals("0")) {
            va1 = kiritishStr.next();
            if (va1.equals("here")) {
                System.out.println("Catalogue :");
                String varr = kiritishStr.next();
                Catalogue currentCatalogue = catalogueService.getCatalogueWitName(varr);
                System.out.println(catalogueService.delete(currentCatalogue));
                if (catalogueService.delete(currentCatalogue)) {
                    System.out.println("AGAIN  FOR DELETING (here)  vs  0. EXIT");
                }
            } else if (!va1.equals("0")) {
                catalogueService.showCatalogue(va1);
                System.out.println("0.Exit");
            }
        }
    }

//    static void shop(User currentUser) {
//        if (currentUser.getWho().equals("ADMIN")) {
//            adminSHOP();
//        } else // FOR CLIENT AND  USER  below
//        {
//            userSHOP(currentUser);
//        }
//    }

    private static void adminSHOP() {
        String var = "10";
        catalogueService.showCatalogue(0);
        System.out.println("0.Exit");
        while (!var.equals("0")) {
            var = kiritishStr.next();
            if (!var.equals("0")) {
                catalogueService.showCatalogue(var);
                System.out.println("0.Exit");
            }
        }
    }

    private static void userSHOP(User currentUser,Basket currentBasket) {
        String var = "10";
        int currentCatalogue = -1;
        String fakeVar="";
        catalogueService.showCatalogue(0);
        System.out.println("0.Exit");

        while (!var.equals("0")) {
            var = kiritishStr.next();
            char son = var.charAt(0);
            if (!var.equals("0") && (Character.isLetter(son))) {
                currentCatalogue = catalogueService.showCatalogue(var);
                fakeVar=var;
                System.out.println("0.Exit");

            } else if (Character.getNumericValue(son) > 0) {
                while (Character.getNumericValue(son)!=0) {
                    System.out.println("Nechta  dona  olasiz :");
                    int number = kiritishInt.nextInt();
                    basketService.addOrder(Character.getNumericValue(son), currentCatalogue, currentUser, number,currentBasket);
                    catalogueService.showCatalogue(fakeVar);
                    System.out.println("0.Exit");
                    son=kiritishStr.next().charAt(0);
                }
                break;
            }
        }
        Calendar cal = Calendar.getInstance();
                        SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MMMM/yyyy");
                        Format formatTime = new SimpleDateFormat("HH:mm:ss");
                        currentBasket.setSimpleformat(simpleformat.format(cal.getTime()));
                        currentBasket.setFormatTime(formatTime.format(new Date()));
        BaseService.allBasket.add(currentBasket);
    }


    private static void addProduct() {

        catalogueService.showCatalogue(0);
        System.out.println("0. EXIT");
        String va1 = "10";
        while (!va1.equals("0")) {
            va1 = kiritishStr.next();
            if (va1.equals("here")) {
                System.out.println("Catalogue :");
                String varr = kiritishStr.next();
                Catalogue currentCatalogue = catalogueService.getCatalogueWitName(varr);
                if (currentCatalogue != null) {
                    ProductDto.productDto(kiritishStr, productService, currentCatalogue);
                } else {
                    System.out.println("Entered    Wrong   Name !!!");
                }
                System.out.println("IF  YOU WANT TO ENTER  PRODUCT AGAIN (here)  OR  0.EXIT");
            } else if (!va1.equals("0")) {
                catalogueService.showCatalogue(va1);
                System.out.println("0.Exit");
            }
        }

    }
}

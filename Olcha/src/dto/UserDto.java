package dto;

import model.User;
import service.UserServise;

import java.util.Scanner;

public class UserDto {
    public static boolean userDTO(Scanner scanner, UserServise userservise)
    {
        System.out.println("enter  name :");
        String name= scanner.next();
        System.out.println("enter username :");
        String username= scanner.next();
        //System.out.println("enter  amount :");
        User user=new User(name,username);
        user.setWho("USER");
       // user.setWallet(scanner.nextDouble());

        return userservise.add(user);
    }

    public static boolean adminDTO(Scanner scanner, UserServise userservise)
    {
        System.out.println("enter  name :");
        String name= scanner.next();
        System.out.println("enter username :");
        String username= scanner.next();

        User user=new User(name,username);
       user.setWho("ADMIN");

        return userservise.add(user);
    }
}

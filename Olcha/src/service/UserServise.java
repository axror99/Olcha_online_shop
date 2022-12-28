package service;

import model.User;

public class UserServise implements BaseService {
    User[] users = new User[50];

    private static int index = 0;

    @Override
    public boolean add(Object o) {
        User user = (User) o;
        if (check(user.getUsername()) == null) {
            users[index++] = user;
            userList.add(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Object o) {
        User user = (User) o;
        if (check(user.getUsername()) == null) {
            return false;
        }
        user.setUsername(null);
        userList.remove(user);
        return true;
    }

    public void showDebtUser() {
        for (User user : userList) {
            if (user.getWallet() != 0) {
                System.out.printf("name :%-13s username :%-22s debt :%-8s%n", user.getName(), user.getUsername(), user.getWallet());
            }
        }
        System.out.println("----------------------------------");
    }

    public void showUser() {
        for (User user : userList) {
            if (user != null) {
                System.out.printf("name :%-13s username :%-15s role:%-10s %n", user.getName(), user.getUsername(),user.getWho());

            }
        }
        System.out.println("----------------------------------");
    }

    public static User check(String username) {
        for (User user : userList) {
            if (user != null) {
                if (user.getUsername().equals(username)) {
                    return user;
                }
            }
        }
        return null;
    }
   public User getUserWithUsername(String username)
   {
       for (User user : userList) {
           {
               if (user != null)
               {
                   if (user.getUsername().equals(username))
                   {
                       return user;
                   }
               }
           }
       }
       return null;
   }

}

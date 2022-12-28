package dto;

import model.Catalogue;
import model.Product;
import service.ProductService;

import java.util.Scanner;

public class ProductDto {
    public static void productDto(Scanner scanner, ProductService productService, Catalogue catalogue)
    {
        Product product=new Product();
        System.out.println("Enter  Product  Name :");
        product.setName(scanner.next());
        System.out.println("Enter  Product  Price :");
        String son= scanner.next();
        product.setCost(Integer.parseInt(son));
        System.out.println("Enter  Product  count :");
        String count= scanner.next();
        product.setCount(Integer.parseInt(count));
        product.setCatalogueID(catalogue.getId());
        System.out.println(productService.add(product));
    }
}

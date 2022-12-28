package dto;

import model.Catalogue;
import service.CatalogueService;

import java.util.Scanner;

public class CatalogueDto {
    public static boolean  catalogueDto(Scanner scanner, CatalogueService catalogueService)
    {
        Catalogue catalogue=new Catalogue();
        System.out.println("enter  Catalogue's  name :");
        catalogue.setName(scanner.next());
        System.out.println("enter  parent ID:");
        catalogue.setPrenatId(scanner.nextInt());

        return catalogueService.add(catalogue);
    }
}

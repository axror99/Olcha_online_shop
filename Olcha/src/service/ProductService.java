package service;

import model.Product;

public class ProductService implements BaseService{

    @Override
    public boolean add(Object o) {
        Product curretProduct=(Product) o;
        for (Product product : allProduct) {
            if (product!=null) {
                if (product.getName().equals(curretProduct.getName()))
                {
                    return false;
                }
            }
        }
        allProduct.add(curretProduct);
        return true;
    }
    @Override
    public boolean delete(Object o) {
        Product currentProduct=(Product) o;
        for (Product product : allProduct) {
            if (product != null)
            {
                if (product.getName().equals(currentProduct.getName()))
                {
                    allProduct.remove(product);
                    return true;
                }
            }
        }
        return false;
    }
    public void showAllProduct()
    {
        for (Product product : allProduct) {
            if (product !=null)
            {
                System.out.println(product);
            }
        }
        System.out.println();
    }
}

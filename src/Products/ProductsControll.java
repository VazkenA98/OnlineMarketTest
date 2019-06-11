package Products;

import User.User;
import User.Currency;

public class ProductsControll extends Product {

    public ProductsControll() {
    }

    public void getAllProducts(Currency currency) {
        products.print(currency);
    }


    public Double getPriceOfProduct(String productName) {

        return products.getPrice(productName);
    }

    public String getProductByName(String pName) {
        if (!products.getName(pName).equals(pName))
            return "we dont have that product";
        return products.getName(pName);
    }

    public void getProductInfoByName(String pName) {
        if (!products.getName(pName).equals(pName)) {
            System.out.println("we dont have that product");
        } else {
            products.printSearchedProduct(pName);
        }
    }
}

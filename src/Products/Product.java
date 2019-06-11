package Products;

public class Product {
    MyProducts<String, String, String> products = new MyProducts<String, String, String>();

    public Product() {
        products.add("iphone1", "good phone", "3000");
        products.add("iphone2", "good phone", "4000");
        products.add("iphone3", "good phone", "5000");
    }


}

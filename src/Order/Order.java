package Order;


import Delivery.Delivery;
import Discount.Discounts;
import Products.ProductsControll;
import Stock.Stock;
import User.User;
import User.UserControll;
import User.ExChange;
import Validator.Validate;

import java.util.Scanner;

public class Order implements ExChange {
    private String productName;
    private String address;
    private User user;
    private Stock stock;
    private Discounts discounts;
    private double finalCost ;
    private Scanner sc = new Scanner(System.in);

    public Order() {
    }

    public Order(String productName, String address, User user, Stock stock, Discounts discounts) {
        this.productName = productName;
        this.address = address;
        this.user = user;
        this.stock = stock;
        this.discounts = discounts;
        orderReview();


    }

    public void orderReview() {
        System.out.println("your order information:");
        printInfoOfBuyingPoduct();
        System.out.println("final price : " + getFinalCost());
        buyOrNot();

    }

    public void printInfoOfBuyingPoduct() {
        System.out.println("Name : " + user.getName());
        System.out.println("email : " + user.getMail());
        System.out.println("address : " + user.getAddress());
        System.out.println("product : " + productName);
        System.out.println("quantity : " + stock.getQuantityOfProducts());
        System.out.println("discount " + discounts.getDiscountAmount());
        finalCost = stock.getQuantityOfProducts() * ExChange.ChangeCurrency((new ProductsControll().getPriceOfProduct(productName)), user.wallet.getCurrency()) - discounts.getDiscountAmount();
        setFinalCost(finalCost);


    }


    public void checkFinalCostAmount() {
        if (user.wallet.getAmount() < finalCost) {
            System.out.println("your balance is less than final cost add money to your account plz");
            new UserControll().controlPage();
        } else {
            user.wallet.setAmount(user.wallet.getAmount() - finalCost);
        }
    }

    public void buyOrNot() {

        if (Validate.readOnlyYOrN(sc)) {
            checkFinalCostAmount();
            new Delivery(this);
        } else {
            new UserControll().controlPage();
        }
    }


    public double getFinalCost() {
        return finalCost;
    }


    public void setFinalCost(double finalCost) {
        this.finalCost = finalCost;
    }
}

import Products.ProductsControll;
import User.Currency;
import User.UserControll;
import Validator.Validate;

import java.util.Scanner;

public class OnlineMarket {

    private Scanner sc = new Scanner(System.in);

    public OnlineMarket() {
        marketPage();
    }

    public int menu() {
        System.out.println("please enter following number");
        System.out.println("1- see market items");
        System.out.println("2- search items");
        System.out.println("3- Creat acount");
        System.out.println("4- Exit page");
        int choice = Validate.readOnlyIntegers(sc);
        return choice;

    }

    public void marketPage() {
        switch (menu()) {
            case 1:
                new ProductsControll().getAllProducts(Currency.USD);
                marketPage();
                break;
            case 2:
                System.out.println("please enter product name");
                String str = sc.next();
                new ProductsControll().getProductInfoByName(str);
                marketPage();
                break;
            case 3:
                new UserControll().account();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("we dont have that option");
                marketPage();
                break;

        }
    }
}

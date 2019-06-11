package User;

import Discount.Discounts;
import Order.Order;
import Products.ProductsControll;
import Stock.Stock;
import Validator.Validate;

import java.util.Scanner;

public class UserControll implements ExChange {
    private Scanner sc = new Scanner(System.in);
    private static User user = new User();
    private ProductsControll product = new ProductsControll();
    private Stock stock = new Stock();

    public UserControll() {
    }

    public int menu() {
        System.out.println("please enter following number");
        System.out.println("1- buy product");
        System.out.println("2- search products");
        System.out.println("3- check my balance");
        System.out.println("4- check my account");
        System.out.println("5- add money");
        System.out.println("6- Exit page");
        int choice = Validate.readOnlyIntegers(sc);
        return choice;

    }

    public void controlPage() {
        switch (menu()) {
            case 1:
                buyProduct(false, null);
                controlPage();
                break;
            case 2:
                System.out.println("please enter product name");
                String str = sc.next();
                new ProductsControll().getProductInfoByName(str);
                if (str.equals(new ProductsControll().getProductByName(str))) {
                    Boolean wantToBuy = buySearchedItem();
                    buyProduct(wantToBuy, str);
                }
                controlPage();
                break;
            case 3:
                userBalance();
                controlPage();
                break;
            case 4:
                System.out.println(user);
                controlPage();
                break;
            case 5:
                System.out.println("enter amount of money");
                double amount = sc.nextDouble();
                user.wallet.setAmount(user.wallet.getAmount() + amount);
                controlPage();
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("we dont have that option");
                controlPage();
                break;

        }
    }

    public Boolean buySearchedItem() {
        boolean check = false;
        if (Validate.readOnlyYOrN(sc)) {
            check = true;
        } else {
            check = false;
        }
        return check;
    }

    public void creatAccount() {
        System.out.println("enter your name");
        String name = sc.next();
        System.out.println("enter you mail");
        String mail = sc.next();
        System.out.println("enter you address");
        String address = sc.next();
        EmailValid emailValid = new EmailValid(mail);
        if (emailValid.isVaild()) {
            register(name, mail, address);
        } else {
            System.out.println("re-enter informations again");
            creatAccount();
        }
    }

    public void creatWallet() {
        System.out.println("enter your account amount");
        Double amount = Validate.limitationOfWallet(sc);
        System.out.println("enter you currency");
        String currency = "";
        user.wallet.availableCurrency();
        do {
            String str = sc.next();
            currency = str.toUpperCase();
        } while (Validate.readOnlyEnumClass(sc, currency));
        setWallet(amount, currency);
        System.out.println();


    }

    public void register(String name, String mail, String address) {
        user.setName(name);
        user.setMail(mail);
        user.setAddress(address);

    }

    public void setWallet(Double amount, String currency) {
        user.wallet.setAmount(amount);
        user.wallet.setCurrency(Currency.valueOf(currency));

    }

    public void account() {
        creatAccount();
        creatWallet();
        controlPage();

    }


    public void userBalance() {
        System.out.println("your balance is = " + user.wallet.getAmount() + " " + user.wallet.getCurrency());

    }

    public void buyProduct(boolean wantBuy, String str) {
        String pName;
        if (wantBuy == true) {
            pName = str;
        } else {

            product.getAllProducts(user.wallet.getCurrency());
            System.out.println("enter product name to buy");
            pName = sc.next();
            if (!pName.equals(new ProductsControll().getProductByName(pName))) {
                System.out.println("we dont have that product");
                controlPage();
            }
        }
        checkBalance();
        System.out.println("price is = " + ExChange.ChangeCurrency(product.getPriceOfProduct(pName), user.wallet.getCurrency()));
        System.out.println("enter quantitiy");
        int qunatity = Validate.readOnlyIntegers(sc);
        Discounts discount = new Discounts();
        System.out.println("with discount = " + discount.getDiscountPercent());
        Double doubleQuantity = qunatity * ExChange.ChangeCurrency((product.getPriceOfProduct(pName)), user.wallet.getCurrency());
        discount.setDiscountAmount(doubleQuantity.intValue());
        setQuantity(qunatity);
        System.out.println("final price after discount = " + ((qunatity * ExChange.ChangeCurrency((product.getPriceOfProduct(pName)), user.wallet.getCurrency())) - discount.getDiscountAmount()));

        Order order = new Order(product.getProductByName(pName), user.getAddress(), this.user, this.stock, discount);


    }

    public void setQuantity(int count) {
        stock.setQuantityOfProducts(count);
    }

    public void checkBalance() {
        if (user.wallet.getAmount() == 0) {
            System.out.println("your balance is zero re-enter plz");
            double newAmount = Validate.limitationOfWallet(sc);
            user.wallet.setAmount(newAmount);
        }
    }


}

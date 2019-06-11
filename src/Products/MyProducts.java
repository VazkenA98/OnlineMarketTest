package Products;

import User.Currency;
import User.ExChange;

import java.util.*;

public class MyProducts<T1, T2, T3> implements ExChange {
    private T1 productName;
    private T2 productDiscription;
    private T3 productPrice;
    private Map<String, LinkedList<String>> map = new LinkedHashMap<>();
    private LinkedList<String> list;
    private String[] str = {"Product", "Discription", "price"};

    private void addToMap(String productName, LinkedList<String> list) {
        map.put(productName, list);

    }

    public void add(T1 productName, T2 productDiscription, T3 productPrice) {
        this.productPrice = productPrice;
        this.productDiscription = productDiscription;
        this.productName = productName;
        list = new LinkedList<String>();
        list.add((String) productName);
        list.add((String) productDiscription);
        list.add((String) productPrice);
        addToMap(list.get(0), list);

    }


    public void print(Currency currency) {
        int count = 1;
        for (Map.Entry<String, LinkedList<String>> entry : map.entrySet()) {
            System.out.print(count + "- ");
            for (int i = 0; i < entry.getValue().size(); i++) {

                if (i == 2) {
                    System.out.print(str[i] + ": " + ExChange.ChangeCurrency(Integer.parseInt(entry.getValue().get(i)), currency) + "  " + currency);
                } else {
                    System.out.print(str[i] + ": " + entry.getValue().get(i) + "  ");
                }

            }
            System.out.println();
            count++;

        }
    }


    public double getPrice(String productName) {
        double price = 0.0;
        for (Map.Entry<String, LinkedList<String>> entry : map.entrySet()) {
            if (entry.getKey().contains(productName)) {
                price = Double.parseDouble(entry.getValue().getLast());
            }

        }
        return price;

    }

    public String getName(String productName) {
        String price = "";
        for (Map.Entry<String, LinkedList<String>> entry : map.entrySet()) {
            if (entry.getKey().contains(productName)) {
                price = (entry.getValue().getFirst());
            }

        }
        return price;

    }

    public void printSearchedProduct(String productName) {
        for (Map.Entry<String, LinkedList<String>> entry : map.entrySet()) {
            if (entry.getKey().contains(productName)) {
                for (int i = 0; i < entry.getValue().size(); i++) {

                    if (i == 2) {
                        System.out.print(str[i] + ": " + ExChange.ChangeCurrency(Integer.parseInt(entry.getValue().get(i)), Currency.USD) + "  " + Currency.USD);
                    } else {
                        System.out.print(str[i] + ": " + entry.getValue().get(i) + "  ");
                    }

                }
            }

        }

    }
}





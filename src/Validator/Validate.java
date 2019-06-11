package Validator;

import User.Currency;

import java.util.Scanner;

public class Validate {

    public static int readOnlyIntegers(Scanner sc) {
        int integer = 0;
        try {
            integer = sc.nextInt();
        } catch (Exception e) {
            System.out.println("only integers are allowed");
            sc.nextLine();
            integer = readOnlyIntegers(sc);
        }
        return integer;
    }

    public static Double readOnlyDouble(Scanner sc) {

        double doubleNum = 0;
        try {
            doubleNum = sc.nextDouble();
        } catch (Exception e) {
            System.out.println("only number are allowed");
            sc.nextLine();
            doubleNum = readOnlyDouble(sc);
        }
        return doubleNum;
    }

    public static Double limitationOfWallet(Scanner sc) {
        boolean valid = true;
        double walletAmount = 0;
        while (valid) {
            walletAmount = readOnlyDouble(sc);
            if (walletAmount <= 0) {
                System.out.println("you cant enter 0 amount");
                System.out.println("please re-enter again");
                valid = true;
            } else {
                valid = false;
            }
        }
        return walletAmount;
    }

    public static boolean readOnlyEnumClass(Scanner sc, String str) {
        boolean enumCheck = false;
        int count = 0;
        for (Currency s : Currency.values()) {
            if (str.equals(s.toString())) {
                count++;
            }
        }
        if (count > 0) {
            enumCheck = false;
        } else {
            System.out.println("please re-enter Currency again there was an error");
            enumCheck = true;
        }
        return enumCheck;
    }

    public static boolean readOnlyYOrN(Scanner sc) {
        boolean valid = false;
        System.out.println("if you want to buy press Y else N");
        String str = sc.next();
        if (str.equals("Y") || str.equals("y") || str.equals("N") || str.equals("n")) {
            valid = true;
        } else {
            System.out.println("wrong input re-enter");
            readOnlyYOrN(sc);
        }

        return valid;
    }

}
